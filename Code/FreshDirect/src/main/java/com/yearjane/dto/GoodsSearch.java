package com.yearjane.dto;

/**
 * goods的查询条件
 * 
 * @author 陈小锋
 *
 */
public class GoodsSearch {
	// 当前页
	private Integer currentPage;
	// 每页条数
	private Integer pageSize;
	// 查询的是哪类商品（0：最新上架；1：折扣商品：2：热卖商品）
	private Integer searchId;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

}
