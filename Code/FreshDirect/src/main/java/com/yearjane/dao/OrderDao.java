package com.yearjane.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yearjane.dto.OrderSearch;
import com.yearjane.entity.OrderDetail;
import com.yearjane.entity.OrderInfo;
import com.yearjane.entity.UserAddress;

public interface OrderDao {
	/**
	 * 添加订单
	 * @param orderInfo
	 * @return
	 */
	public int addOrderInfo(@Param("orderInfo") OrderInfo orderInfo);
	
	/**
	 * 添加订单详情
	 * @param detailList
	 * @return
	 */
	public int addOrderDetail(@Param("detailList") List<OrderDetail> detailList);
	
	/**
	 * 更新订单状态
	 * @param orderInfo
	 * @return
	 */
	public int updateOrderInfo(@Param("orderInfo") OrderInfo orderInfo);
	
	/**
	 * 删除订单详情
	 * @param orderDetail
	 * @return
	 */
	public int deleteOrderDetail(@Param("orderDetail") OrderDetail orderDetail);
	
	/**
	 * 查询订单记录
	 * @param orderInfo
	 * @param orderSearch
	 * @param star
	 * @param pagesize
	 * @return
	 */
	public List<OrderInfo> getOrederInfos(@Param("orderInfo") OrderInfo orderInfo);
	
	/**
	 * 订单详情查询
	 * @param orderDetail
	 * @return
	 */
	public List<OrderDetail> getOrderDetails(@Param("orderDetail") OrderDetail orderDetail);
	
	/**
	 * 根据id查地址  辅助分步查询
	 * @param id
	 * @return
	 */
	public UserAddress getUserAddressByid(@Param("id") Integer id);
	
	/**
	 * 添加收货地址
	 * @param userAddress
	 * @return
	 */
	public int addUserAddress(@Param("userAddress") UserAddress userAddress);
	
	/**
	 * 修改收货地址
	 * @param userAddress
	 * @return
	 */
	public  int updateUserAddress(@Param("userAddress") UserAddress userAddress);
	
	/**
	 * 获取用户收货地址
	 * @return
	 */
	public List<UserAddress> getUserAddress(@Param("userAddress") UserAddress userAddress);
	
	
}
