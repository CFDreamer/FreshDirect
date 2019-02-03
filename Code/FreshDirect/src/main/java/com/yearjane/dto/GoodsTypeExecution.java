package com.yearjane.dto;

import java.util.List;

import com.yearjane.entity.GoodsType;
import com.yearjane.enums.ResultResponseEnum;

public class GoodsTypeExecution extends BaseExecution {
	private GoodsType goodsTpye;
	private List<GoodsType> goodsTypeList;

	public GoodsType getGoodsTpye() {
		return goodsTpye;
	}

	public void setGoodsTpye(GoodsType goodsTpye) {
		this.goodsTpye = goodsTpye;
	}

	public List<GoodsType> getGoodsTypeList() {
		return goodsTypeList;
	}

	public void setGoodsTypeList(List<GoodsType> goodsTypeList) {
		this.goodsTypeList = goodsTypeList;
	}
	/**
	 * 只返回结果和状态的构造器
	 * @param responseEnum
	 * @param status
	 */
	public GoodsTypeExecution (ResultResponseEnum responseEnum,Boolean status) {
		super(responseEnum,status);
	}
	/**
	 * 操作单个
	 * @param responseEnum
	 * @param goodsTpye
	 * @param status
	 */
	public GoodsTypeExecution(ResultResponseEnum responseEnum,GoodsType goodsTpye,Boolean status) {
		super(responseEnum,status);
		this.goodsTpye=goodsTpye;
	}
	/**
	 * 批量操作
	 * @param responseEnum
	 * @param goodsTypeList
	 * @param status
	 */
	public GoodsTypeExecution(ResultResponseEnum responseEnum,List<GoodsType> goodsTypeList,Boolean status) {
		super(responseEnum,status);
		this.goodsTypeList = goodsTypeList;
	}
	public GoodsTypeExecution () {

	}
}
