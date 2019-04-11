package com.yearjane.entity;

/**
 * 
 * @author 
 * 订单详情表
 */
public class OrderDetail extends Base{

	private static final long serialVersionUID = -4264147501885752823L;
	//主键 id
	private Integer id;
	//订单号
	private String ono;
	//商品
	private GoodsInfo gid;
	//数量
	private Integer count;
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

	
	public GoodsInfo getGid() {
		return gid;
	}
	public void setGid(GoodsInfo gid) {
		this.gid = gid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", ono=" + ono + ", gid=" + gid + ", count=" + count + "]";
	}
	
	
	

}
