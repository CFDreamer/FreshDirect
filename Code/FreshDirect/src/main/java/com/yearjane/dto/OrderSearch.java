package com.yearjane.dto;

/**
 * 查询Order的辅助类
 * 
 * @author 陈小锋
 *
 */
public class OrderSearch {
	//需要查询订单的状态（0：未完成；1：已经完成）
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
