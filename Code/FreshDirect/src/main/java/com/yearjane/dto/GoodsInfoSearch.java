package com.yearjane.dto;

/**
 * 商品批量查询辅助类
 * 
 * @author 陈小锋
 *
 */
public class GoodsInfoSearch {
	// 打折商品的标志 1打折  
	private Integer isDiscount;
	
	//是否是热卖商品 1热卖
	private Integer isHot;
	
	//是否是最新商品
	private Integer isNewGoods;
	public Integer getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(Integer isDiscount) {
		this.isDiscount = isDiscount;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getIsNewGoods() {
		return isNewGoods;
	}

	public void setIsNewGoods(Integer isNewGoods) {
		this.isNewGoods = isNewGoods;
	}

	

}
