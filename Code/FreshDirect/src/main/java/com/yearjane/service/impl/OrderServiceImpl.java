package com.yearjane.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yearjane.dao.GoodsDao;
import com.yearjane.dao.OrderDao;
import com.yearjane.dao.UserShopCarDao;
import com.yearjane.dto.Order;
import com.yearjane.dto.OrderDetailExecution;
import com.yearjane.dto.OrderInfoExecution;
import com.yearjane.dto.UserAddressExecution;
import com.yearjane.dto.UserShopCarExecution;
import com.yearjane.entity.GoodsInfo;
import com.yearjane.entity.OrderDetail;
import com.yearjane.entity.OrderInfo;
import com.yearjane.entity.UserAddress;
import com.yearjane.entity.UserShopCar;
import com.yearjane.enums.ResultResponseEnum;
import com.yearjane.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao oDao;
	@Autowired
	private UserShopCarDao cDao;
	@Autowired
	private GoodsDao gDao;

	@Override
	@Transactional
	public UserShopCarExecution createAccountPage(List<Integer> carids) {
		UserShopCarExecution execution=new UserShopCarExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		List<UserShopCar> list=new ArrayList<UserShopCar>();
		UserShopCar car=null;
		//获取id对应购物车的的记录,并添加到list集合
		try {
			for (Integer id  : carids) {
				car=new UserShopCar();
				car.setId(id);
				list.add(cDao.getUserShopCar(car).get(0));
				
			}
		} catch (Exception e) {
			throw new RuntimeException("查询失败");
		}
		execution=new UserShopCarExecution(ResultResponseEnum.RESULTOK,list,true);
		return execution;
	}

	@Override
	public UserAddressExecution getUserAddress(UserAddress userAddress) {
		UserAddressExecution execution=new UserAddressExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		List<UserAddress> list=new ArrayList<UserAddress>();
		list=oDao.getUserAddress(userAddress);
		execution=new UserAddressExecution(ResultResponseEnum.RESULTOK,list,true);
		return execution;
	}
	
	@Transactional
	@Override
	public OrderInfoExecution creteOrder(Integer uid, Order order) {
		OrderInfoExecution execution=new OrderInfoExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		List<UserShopCar> list=new ArrayList<UserShopCar>();
		UserShopCar car=null;
		//获取id对应购物车的的记录,并添加到list集合
		try {
			for (Integer id  : order.getCarids()) {
				car=new UserShopCar();
				car.setId(id);
				list.add(cDao.getUserShopCar(car).get(0));
				
			}
		} catch (Exception e) {
			throw new RuntimeException("查询失败");
		}
		
		OrderInfo info=new OrderInfo();
		UserAddress address=new UserAddress();
		address.setAddress_id(order.getAddress_id());
		info.setAddress(address);
		info.setAllprice(order.getAllprice());
		info.setCreateTime(new Date());
		String ono=String.valueOf(System.currentTimeMillis());
		info.setOno(ono);
		info.setRemarks(order.getRemarks());
		info.setState(0);
		info.setUid(uid);
		info.setUpdateTime(new Date());
		int effect=oDao.addOrderInfo(info);
		if(0>=effect) {
			execution=new OrderInfoExecution(ResultResponseEnum.ORDER_ADD_FAIL, false);
			throw new RuntimeException("添加订单失败");
		}
		//添加订单详情
		OrderDetail orderDetail=null;
		List<OrderDetail> listDetail=new ArrayList<OrderDetail>();
		for (UserShopCar shopCar : list) {
			orderDetail=new OrderDetail();
			orderDetail.setCount(shopCar.getCount());
			orderDetail.setGid(shopCar.getGoodsInfo());
			orderDetail.setOno(ono);
			listDetail.add(orderDetail);
		}
		effect=oDao.addOrderDetail(listDetail);
		if(0>=effect) {
			execution=new OrderInfoExecution(ResultResponseEnum.ORDER_DATIAL_ADD_FAIL, false);
			throw new RuntimeException("添加订单详情失败");
		}
		//删除购物车中对应的商品
		effect=cDao.deleteUserShopCar(order.getCarids());
		if(0>=effect) {
			execution=new OrderInfoExecution(ResultResponseEnum.RESULT_FAIL, false);
			throw new RuntimeException("删除购物车商品失败");
		}
		execution=new OrderInfoExecution(ResultResponseEnum.RESULTOK,info,true);
		return execution;
	}
	
	@Transactional
	@Override
	public OrderInfoExecution updateOrder(String ono) {
		OrderInfoExecution execution=new OrderInfoExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		//在订单详情表查询该订单的详细记录
		OrderDetail search=new OrderDetail();
		search.setOno(ono);
		List<OrderDetail> listDetail=new ArrayList<OrderDetail>();
		listDetail=oDao.getOrderDetails(search);
		Boolean flag=true;
		//查询对应的商品信息
		GoodsInfo info1=null;
		List<GoodsInfo> goodsList=new ArrayList<GoodsInfo>();
		for (OrderDetail detail : listDetail) {
			info1=new GoodsInfo();
			info1.setId(detail.getGid().getId());
			goodsList.add(gDao.getGoodsInfo(info1));
		}
		
		for(int i=0;i<goodsList.size();i++) {
			if(listDetail.get(i).getCount()>goodsList.get(i).getStock()) {
				execution=new OrderInfoExecution(ResultResponseEnum.RESULT_FAIL,goodsList.get(i).getGoodsname()+"只有"+goodsList.get(i).getStock()+"库存了",false);
				return execution;
			}
		}
		//库存减少，销量增加
		for(int i=0;i<goodsList.size();i++) {
			GoodsInfo update=new GoodsInfo();
			update.setId(listDetail.get(i).getGid().getId());
			update.setStock(goodsList.get(i).getStock()-listDetail.get(i).getCount());
			update.setSellCount(goodsList.get(i).getSellCount()+listDetail.get(i).getCount());
			int effect=gDao.updateGoodsInfo(update);
			if(0>=effect) {
				execution=new OrderInfoExecution(ResultResponseEnum.RESULT_FAIL, false);
				throw new RuntimeException("商品信息更新失败");
			}
			
		}
		OrderInfo info=new OrderInfo();
		info.setOno(ono);
		info.setState(1);
		int effect=oDao.updateOrderInfo(info);
		if(0>=effect) {
			execution=new OrderInfoExecution(ResultResponseEnum.RESULT_FAIL, false);
			throw new RuntimeException("更新订单状态失败");
		}
		
		execution=new OrderInfoExecution(ResultResponseEnum.RESULTOK,true);
		return execution;
	}
	
	@Transactional
	@Override
	public OrderInfoExecution deleteOrder(String ono) {
		OrderInfoExecution execution=new OrderInfoExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		OrderInfo info=new OrderInfo();
		OrderDetail detail=new OrderDetail();
		info.setOno(ono);
		info.setIsdeleted(1);
		int effect=oDao.updateOrderInfo(info);
		if(0>=effect) {
			execution=new OrderInfoExecution(ResultResponseEnum.RESULT_FAIL, false);
			throw new RuntimeException("订单删除失败");
		}
		detail.setOno(ono);
		detail.setIsdeleted(1);
		effect=oDao.deleteOrderDetail(detail);
		if(0>=effect) {
			execution=new OrderInfoExecution(ResultResponseEnum.RESULT_FAIL, false);
			throw new RuntimeException("订单删除失败");
		}
		execution=new OrderInfoExecution(ResultResponseEnum.RESULTOK,true);
		return execution;
	}

	@Override
	public OrderInfoExecution getOrderInfos(OrderInfo orderInfo) {
		OrderInfoExecution execution=new OrderInfoExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		List<OrderInfo> list=new ArrayList<OrderInfo>();
		list=oDao.getOrederInfos(orderInfo);
		execution=new OrderInfoExecution(ResultResponseEnum.RESULTOK,list,true);
		return execution;
	}

	@Override
	public OrderDetailExecution getDetaInfos(OrderDetail detail) {
		OrderDetailExecution execution=new OrderDetailExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		List<OrderDetail> list=new ArrayList<OrderDetail>();
		list=oDao.getOrderDetails(detail);
		execution=new OrderDetailExecution(ResultResponseEnum.RESULTOK,list,true);
		return execution;
	}
	
	@Transactional
	@Override
	public UserAddressExecution addUserAddress(UserAddress address) {
		UserAddressExecution execution=new UserAddressExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		//如果将该地址设为默认地址
		if(1==address.getIsdefault()) {
			List<UserAddress> result=new ArrayList< UserAddress>();
			UserAddress search=new UserAddress();
			search.setUid(address.getUid());
			search.setIsdefault(1);
			//查询该用户以前的默认地址记录
			result=oDao.getUserAddress(search);
			//如果存在该记录
			if(1==result.size()) {
				UserAddress update=new UserAddress();
				update.setIsdefault(0);
				update.setAddress_id(result.get(0).getAddress_id());
				//将该地址设为非默认地址
				int effect =oDao.updateUserAddress(update);
				if(0>=effect) {
					execution=new UserAddressExecution(ResultResponseEnum.RESULT_FAIL, false);
					throw new RuntimeException("地址默认状态修改失败");
				}
			}
		}
		int effect =oDao.addUserAddress(address);
		if(0>=effect) {
			execution=new UserAddressExecution(ResultResponseEnum.RESULT_FAIL, false);
			throw new RuntimeException("地址添加失败");
		}
		execution=new UserAddressExecution(ResultResponseEnum.RESULTOK,true);
		return execution;
	}
	
	@Transactional
	@Override
	public UserAddressExecution updateUserAddress(UserAddress address) {
		UserAddressExecution execution=new UserAddressExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		//如果要修改默认地址
		if(null!=address.getIsdefault()&&1==address.getIsdefault()) {
			List<UserAddress> result=new ArrayList< UserAddress>();
			UserAddress search=new UserAddress();
			search.setUid(address.getUid());
			search.setIsdefault(1);
			//查询该用户以前的默认地址记录
			result=oDao.getUserAddress(search);
			//如果存在该记录
			if(1==result.size()) {
				UserAddress update=new UserAddress();
				update.setIsdefault(0);
				update.setAddress_id(result.get(0).getAddress_id());
				//将该地址设为非默认地址
				int effect =oDao.updateUserAddress(update);
				if(0>=effect) {
					execution=new UserAddressExecution(ResultResponseEnum.RESULT_FAIL, false);
					throw new RuntimeException("地址默认状态修改失败");
				}
			}
		}
		int effect =oDao.updateUserAddress(address);
		if(0>=effect) {
			execution=new UserAddressExecution(ResultResponseEnum.RESULT_FAIL, false);
			throw new RuntimeException("地址默认状态修改失败");
		}
		execution=new UserAddressExecution(ResultResponseEnum.RESULTOK,true);
		return execution;
	}
}
