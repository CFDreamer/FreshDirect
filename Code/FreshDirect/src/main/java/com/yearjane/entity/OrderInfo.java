package com.yearjane.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yearjane.util.CustomDateYMDHDSSerialize;

/**
 * 
 * @author 
 * 订单表
 */
public class OrderInfo extends Base{

	private static final long serialVersionUID = 580884061165213395L;
	//主键 自增
	private Integer id;
	//订单的编号
	private String ono;
	//用户的id
	private Integer uid;
	//订单的总价
	private Double allprice;
	//订单的状态（0：未完成；1：已完成）
	private Integer state;
	//订单的创建时间
	private Date createTime;
	//订单的修改时间
	private Date updateTime;
	//备注
	private String remarks;
	//地址
	private UserAddress address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOno() {
		return ono;
	}
	public void setOno(String ono) {
		this.ono = ono;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Double getAllprice() {
		return allprice;
	}
	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@JsonSerialize(using=CustomDateYMDHDSSerialize.class)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@JsonSerialize(using=CustomDateYMDHDSSerialize.class)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public UserAddress getAddress() {
		return address;
	}
	public void setAddress(UserAddress address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", ono=" + ono + ", uid=" + uid + ", allprice=" + allprice + ", state=" + state
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", remarks=" + remarks + ", address="
				+ address + "]";
	}
	
}
