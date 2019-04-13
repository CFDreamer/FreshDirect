package com.yearjane.service;

import java.util.List;

import com.yearjane.dto.Order;
import com.yearjane.dto.OrderDetailExecution;
import com.yearjane.dto.OrderInfoExecution;
import com.yearjane.dto.UserAddressExecution;
import com.yearjane.dto.UserShopCarExecution;
import com.yearjane.entity.OrderDetail;
import com.yearjane.entity.OrderInfo;
import com.yearjane.entity.UserAddress;


public interface OrderService {
	/**
	 * 结算页面商品部分的生成
	 * @param uid
	 * @param carids
	 * @return
	 */
   public UserShopCarExecution  createAccountPage(List<Integer> carids);
   
   /**
    * 用户收货地址的查询
    * @param userAddress
    * @return
    */
   public UserAddressExecution getUserAddress(UserAddress userAddress);
   
   /**
    * 订单的创建
    * @param uid
    * @param carids
    * @return
    */
   public OrderInfoExecution creteOrder(Integer uid,Order order);
   
   /**
    * 订单状态的修改
    * @param orderInfo
    * @return
    */
   public OrderInfoExecution updateOrder(String ono);
   
   /**
    * 订单的删除
    * @param ono
    * @return
    */
   public OrderInfoExecution deleteOrder(String ono);
   
   /**
    * 查询订单
    * @param orderInfo
    * @return
    */
   public OrderInfoExecution getOrderInfos(OrderInfo orderInfo);
   
   /**
    * 查询订单详情
    * @param detail
    * @return
    */
   public OrderDetailExecution getDetaInfos(OrderDetail detail);
   
   /**
    * 添加收货地址
    * @param address
    * @return
    */
   public  UserAddressExecution addUserAddress(UserAddress address);
   
   /**
    * 更新收货地址
    * @param address
    * @return
    */
   public UserAddressExecution updateUserAddress(UserAddress address);
}
