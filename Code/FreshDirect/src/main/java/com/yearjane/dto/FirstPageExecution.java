package com.yearjane.dto;

import java.util.List;

import com.yearjane.entity.GoodsInfo;
import com.yearjane.enums.ResultResponseEnum;

/**
 * 首页的Execution
 * @author 陈小锋
 *
 */
public class FirstPageExecution extends BaseExecution{
	
	private List<GoodsInfo> disCountList;
	private List<GoodsInfo> hotList;
	private List<GoodsInfo> newList;
	
	public FirstPageExecution() {
		
	}
	/**
	 * 只返回结果和状态的构造器
	 * @param responseEnum
	 * @param status
	 */
	public FirstPageExecution (ResultResponseEnum responseEnum,Boolean status) {
		super(responseEnum,status);
	}

	public List<GoodsInfo> getDisCountList() {
		return disCountList;
	}

	public void setDisCountList(List<GoodsInfo> disCountList) {
		this.disCountList = disCountList;
	}

	public List<GoodsInfo> getHotList() {
		return hotList;
	}

	public void setHotList(List<GoodsInfo> hotList) {
		this.hotList = hotList;
	}

	public List<GoodsInfo> getNewList() {
		return newList;
	}

	public void setNewList(List<GoodsInfo> newList) {
		this.newList = newList;
	}
	
	public FirstPageExecution (ResultResponseEnum responseEnum, List<GoodsInfo> disCount, List<GoodsInfo> hot,List<GoodsInfo> newGoods,Boolean status) {
		super(responseEnum,status);
		this.disCountList=disCount;
		this.hotList=hot;
		this.newList=newGoods;
	}
	
}
