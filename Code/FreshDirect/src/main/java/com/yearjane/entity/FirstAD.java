package com.yearjane.entity;

/**
 * 
 * @author 
 * 首页轮播图
 */
public class FirstAD extends Base{

	private static final long serialVersionUID = -5689199918248707105L;
	//主键 自增
	private Integer id;
	//轮播图的图片
	private String imagePath;	
	//轮播对应的商品
	private GoodsInfo goodsInfo;
	//活动的url
	private String url;
	//是否展示（0：不展示；1：展示）
	private Integer isdisplay;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public GoodsInfo getGid() {
		return goodsInfo;
	}
	public void setGid(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getIsdisplay() {
		return isdisplay;
	}
	public void setIsdisplay(Integer isdisplay) {
		this.isdisplay = isdisplay;
	}
	

}
