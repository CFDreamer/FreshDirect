package com.yearjane.dto;

/**
 * 搜索页的辅助类
 * 
 * @author 陈小锋
 *
 */
public class SearchPage {
	// 搜索的关键字
	private String keyWord;
	// 商品类型
	private Integer typeid;
	
	//查询商品的种类 0：折扣 1：热卖 2：最新
	private Integer searchId;
	
	//当前页
	private Integer pageNo;
	
	//每页显示的数量	
	private Integer pageSize;
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	@Override
	public String toString() {
		return "SearchPage [keyWord=" + keyWord + ", typeid=" + typeid + ", searchId=" + searchId + ", pageNo=" + pageNo
				+ ", pageSize=" + pageSize + "]";
	}

	
	
}
