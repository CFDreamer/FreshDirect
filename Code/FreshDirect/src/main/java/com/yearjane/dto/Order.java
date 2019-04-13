package com.yearjane.dto;

import java.util.List;

/**
 * 提交订单的辅助类
 * 
 * @author 陈小锋
 *
 */
public class Order {
	private List<Integer> carids;
	private Double allprice;
	private String remarks;
	private Integer address_id;

	public List<Integer> getCarids() {
		return carids;
	}

	public void setCarids(List<Integer> carids) {
		this.carids = carids;
	}

	public Double getAllprice() {
		return allprice;
	}

	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	
}
