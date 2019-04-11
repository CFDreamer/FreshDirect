package com.yearjane.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yearjane.util.CustomDateYMDHDSSerialize;

/**
 * 用户的购物车
 * @author 陈小锋
 *
 */
public class UserShopCar  extends Base{
	
	private static final long serialVersionUID = 926606399051613322L;
	//主键，自增
	private Integer id;
	//用户id
	private Integer uid;
	//购买的商品
	private GoodsInfo goodsInfo;
	//商品的个数
	private Integer count;
	//添加时间
	private Date addTime;
	//修改时间
	private Date updateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
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
	@Override
	public String toString() {
		return "UserShopCar [id=" + id + ", uid=" + uid + ", goodsInfo=" + goodsInfo + ", count=" + count + ", addTime="
				+ addTime + ", updateTime=" + updateTime + "]";
	}
	
}
