package com.yearjane.dto;

import java.util.List;

/**
 * 分页类
 * 
 * @author 陈小锋
 *
 */
public class Page {
	private Integer totalPage;
	private List<Object> goodList;


	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<Object> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<Object> goodList) {
		this.goodList = goodList;
	}

}
