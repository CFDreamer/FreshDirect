package com.yearjane.dto;


import java.util.List;

import com.yearjane.entity.GoodsInfo;
import com.yearjane.enums.ResultResponseEnum;

/**
 * 商品的Execution
 * @author 陈小锋
 *
 */
public class GoodsExecution extends BaseExecution {
	private List<GoodsInfo> list;
	private GoodsInfo goodsInfo;
	private Page page;
	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public List<GoodsInfo> getList() {
		return list;
	}
	public void setList(List<GoodsInfo> list) {
		this.list = list;
	}
	/**
	 * 只返回结果和状态的构造器
	 * @param responseEnum
	 * @param status
	 */
	public GoodsExecution (ResultResponseEnum responseEnum,Boolean status) {
		super(responseEnum,status);
	}
	/**
	 * 操作单个
	 * @param responseEnum
	 * @param goodsTpye
	 * @param status
	 */
	public GoodsExecution(ResultResponseEnum responseEnum,GoodsInfo goodsInfo,Boolean status) {
		super(responseEnum,status);
		this.goodsInfo=goodsInfo;
	}
	
	/**
	 * 批量操作
	 * @param responseEnum
	 * @param goodsTypeList
	 * @param status
	 */
	public GoodsExecution(ResultResponseEnum responseEnum,List<GoodsInfo> list,Boolean status) {
		super(responseEnum,status);
		this.list = list;
	}
	public GoodsExecution(ResultResponseEnum responseEnum,Page page,Boolean status) {
		super(responseEnum,status);
		this.page = page;
	}
	public GoodsExecution () {

	}
	
}
