package com.yearjane.dto;

import java.util.List;

import com.yearjane.entity.GoodsInfo;

/**
 * 商品的Execution
 * @author 陈小锋
 *
 */
public class GoodsExecution extends BaseExecution {

	private GoodsInfo goodsInfo;
	private List<GoodsInfo> goodInfoList;
	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public List<GoodsInfo> getGoodInfoList() {
		return goodInfoList;
	}
	public void setGoodInfoList(List<GoodsInfo> goodInfoList) {
		this.goodInfoList = goodInfoList;
	}
	
	
}
