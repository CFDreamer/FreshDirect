package com.yearjane.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yearjane.util.CustomDateYMDHDSSerialize;

/**
 * 商品的信息
 * @author 
 *
 */
public class GoodsInfo extends Base{

	private static final long serialVersionUID = -5501857928007030415L;
	//主键 自增
	private Integer id;
	//商品的类型
	private GoodsType goodstype;
	//商品的名字
	private String goodsname;
	//商品的图片
	private String imagePath;
	//商品的介绍
	private String introduce;
	//商品的现价
	private Double nowPrice;
	//商品的原价
	private Double oldPrice;
	//商品的创建时间
	private Date createTime;
	//最后的修改时间
	private Date updateTime;
	//商品的销量
	private Integer sellCount;
	//商品是否上架（0：不上架；1：上架）
	private Integer  isenable;
	//商品的点击次数
	private Integer clickCout;
	//商品的库存
	private Integer stock;
	//操作员的姓名
	private String operatorName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public GoodsType getGoodstype() {
		return goodstype;
	}
	public void setGoodstype(GoodsType goodstype) {
		this.goodstype = goodstype;
	}
	
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Double getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(Double nowPrice) {
		this.nowPrice = nowPrice;
	}
	public Double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}
	@JsonSerialize(using=CustomDateYMDHDSSerialize.class)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	public Integer getSellCount() {
		return sellCount;
	}
	@JsonSerialize(using=CustomDateYMDHDSSerialize.class)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}
	public Integer getIsenable() {
		return isenable;
	}
	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}
	public Integer getClickCout() {
		return clickCout;
	}
	public void setClickCout(Integer clickCout) {
		this.clickCout = clickCout;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	@Override
	public String toString() {
		return "GoodsInfo [id=" + id + ", goodstype=" + goodstype + ", goodsname=" + goodsname + ", imagePath="
				+ imagePath + ", introduce=" + introduce + ", nowPrice=" + nowPrice + ", oldPrice=" + oldPrice
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", sellCount=" + sellCount
				+ ", isenable=" + isenable + ", clickCout=" + clickCout + ", stock=" + stock + ", operatorName="
				+ operatorName + "]";
	}
	
}
