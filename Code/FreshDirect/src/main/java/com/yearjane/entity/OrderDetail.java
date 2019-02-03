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
	private GoodsInfo goodsInfo;
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

	public GoodsInfo getGoods() {
		return goodsInfo;
	}
	public void setGoods(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	

}
