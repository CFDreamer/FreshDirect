package com.yearjane.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yearjane.util.CustomDateYMDHDSSerialize;

/**
 * 
 * @author 
 * 商品的类别
 */
public class GoodsType extends Base {

	private static final long serialVersionUID = 59597651228207605L;
	//商品类型id
	private Integer typeid;
	//商品类型的名称
	private String typename;
	//类型的父级id，当父级id为null时，是大分类，不为null说明是小的分类
	private GoodsType parent;
	//添加时间
	private Date addTime;
	//最后修改时间
	private Date updateTime;
	//操作员
	private String operatorName;
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}

	@JsonSerialize(using=CustomDateYMDHDSSerialize.class)
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	@JsonSerialize(using=CustomDateYMDHDSSerialize.class)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public GoodsType getParent() {
		return parent;
	}
	public void setParent(GoodsType parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "GoodsType [ typeid=" + typeid + ", typename=" + typename + ", parent=" + parent
				+ ", addTime=" + addTime + ", updateTime=" + updateTime + ", operatorName=" + operatorName + "]";
	}
	
	
	
	
	
}
