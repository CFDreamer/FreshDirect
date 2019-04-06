package com.yearjane.dto;

import java.util.List;

import com.yearjane.entity.GoodsInfo;

/**
 * 分页类
 * 
 * @author 陈小锋
 *
 */
public class Page {
	private Integer totalCount;
	private Integer totalPage;
	private List<GoodsInfo> goodList;


	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<GoodsInfo> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<GoodsInfo> goodList) {
		this.goodList = goodList;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
}
