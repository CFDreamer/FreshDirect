package com.yearjane.dto;

import java.util.List;

import com.yearjane.entity.OrderDetail;
import com.yearjane.enums.ResultResponseEnum;

public class OrderDetailExecution extends BaseExecution {
	private OrderDetail orderDetail;
	private List<OrderDetail> orderDetailList;

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	/**
	 * 
	 * @param responseEnum
	 * @param status
	 */
	public OrderDetailExecution (ResultResponseEnum responseEnum,Boolean status) {
		super(responseEnum,status);
	}
	
	/**
	 * 
	 * @param responseEnum
	 * @param orderDetail
	 * @param status
	 */
	public OrderDetailExecution(ResultResponseEnum responseEnum,OrderDetail orderDetail,Boolean status) {
		super(responseEnum,status);
		this.orderDetail=orderDetail;
	}
	
	/**
	 * 
	 * @param responseEnum
	 * @param orderDetailList
	 * @param status
	 */
	public OrderDetailExecution(ResultResponseEnum responseEnum,List<OrderDetail> orderDetailList,Boolean status) {
		super(responseEnum,status);
		this.orderDetailList=orderDetailList;
	}
	
	/**
	 * 
	 */
	public OrderDetailExecution() {
		
	}

}
