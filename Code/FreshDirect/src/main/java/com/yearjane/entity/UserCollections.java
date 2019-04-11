package com.yearjane.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yearjane.util.CustomDateYMDHDSSerialize;

/**
 * 
 * @author 
 * 用户的收藏表
 */
public class UserCollections extends Base {

	private static final long serialVersionUID = 4748806369608605339L;
	//主键 自增
	private Integer id;
	//用户id
	private Integer uid;
	//收藏的商品
	private GoodsInfo gid;
	//添加的时间
	private Date addTime;
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
	public GoodsInfo getGid() {
		return gid;
	}
	public void setGid(GoodsInfo gid) {
		this.gid = gid;
	}
	@JsonSerialize(using=CustomDateYMDHDSSerialize.class)
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	@Override
	public String toString() {
		return "UserCollections [id=" + id + ", uid=" + uid + ", gid=" + gid + ", addTime=" + addTime + "]";
	}
	
}
