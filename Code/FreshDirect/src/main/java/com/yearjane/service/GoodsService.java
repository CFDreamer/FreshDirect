package com.yearjane.service;

import java.util.List;

import com.yearjane.dto.FirstPageExecution;
import com.yearjane.dto.GoodsExecution;
import com.yearjane.dto.GoodsInfoSearch;
import com.yearjane.dto.GoodsTypeExecution;
import com.yearjane.dto.SearchPage;
import com.yearjane.entity.GoodsInfo;
import com.yearjane.entity.GoodsType;

/**
 * 商品的Service
 * @author 陈小锋
 *
 */
public interface GoodsService {
	/**
	 * 批量插入商品类型
	 * @param goodsTypeList
	 * @return
	 */
	public GoodsTypeExecution addGoodsType(List<GoodsType> goodsTypeList) ;
	
	/**
	 * 更新商品类型
	 * @param goodsType
	 * @return
	 */
	public GoodsTypeExecution updateGoodsType(GoodsType goodsType);
	/**
	 * 查询商品类型
	 * @param goodsType
	 * @return
	 */
	public GoodsTypeExecution queryGoodsType(GoodsType goodsType);
	
	/**
	 * 删除商品类型
	 * @param goodsTypeList
	 * @return
	 */
	public GoodsTypeExecution deleteGoodsType(List<Integer> goodsTypeIdList);
	
	/**
	 * 商品的新增
	 * @param goodsInfo
	 * @return
	 */
	public GoodsExecution addGoodsInfo(GoodsInfo goodsInfo);
	
	/**
	 * 商品的修改
	 * @param goodsInfo
	 * @return
	 */
	public GoodsExecution updateGoodsInfo(GoodsInfo goodsInfo);
	
	/**
	 * 商品的详细信息查询
	 * @param goodsInfo
	 * @return
	 */
	public GoodsExecution getGoodsInfo(GoodsInfo goodsInfo);
	
	/**
	 * 商品的删除
	 * @param goodInfoIds
	 * @return
	 */
	public GoodsExecution deletedGoodsInfo(List<Integer> goodInfoIds);
	
	/**
	 * 商品的分页查询
	 * @param goodsInfo
	 * @param search
	 * @return
	 */
	public GoodsExecution getdGoodsInfos(GoodsInfo goodsInfo,GoodsInfoSearch search,Integer pageNo,Integer pageSize);
	
	/**
	 * 获取首页三种类型的接口
	 * @return
	 */
	public FirstPageExecution getFirstPageInfo();
	
	/**
	 * 查询类似商品
	 * @param goodsInfo
	 * @return
	 */
	public GoodsExecution  getSimilarGoods(GoodsInfo goodsInfo);
	
	public GoodsExecution getSearchPageGoods(SearchPage searchPage);
	
}
