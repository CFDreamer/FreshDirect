package com.yearjane.dto;

import java.util.List;

import com.yearjane.entity.OrderInfo;
import com.yearjane.enums.ResultResponseEnum;

public class OrderInfoExecution extends BaseExecution {
	
	private OrderInfo orderInfo;
	private List<OrderInfo> orderInfoList;
	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	public List<OrderInfo> getOrderInfoList() {
		return orderInfoList;
	}
	public void setOrderInfoList(List<OrderInfo> orderInfoList) {
		this.orderInfoList = orderInfoList;
	}
	
	/**
	 * 
	 * @param responseEnum
	 * @param status
	 */
	public OrderInfoExecution (ResultResponseEnum responseEnum,Boolean status) {
		super(responseEnum,status);
	}
	
	/**
	 * 
	 * @param responseEnum
	 * @param orderInfo
	 * @param status
	 */
	public OrderInfoExecution(ResultResponseEnum responseEnum,OrderInfo orderInfo,Boolean status) {
		super(responseEnum,status);
		this.orderInfo=orderInfo;
	}
	
	/**
	 * 
	 * @param responseEnum
	 * @param orderInfoList
	 * @param status
	 */
	public OrderInfoExecution(ResultResponseEnum responseEnum,List<OrderInfo> orderInfoList,Boolean status) {
		super(responseEnum,status);
		this.orderInfoList=orderInfoList;
	}
	
	/**
	 * 
	 */
	public OrderInfoExecution() {
		
	}
}
