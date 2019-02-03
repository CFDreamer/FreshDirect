package com.yearjane.service;

import java.util.List;

import com.yearjane.dto.GoodsTypeExecution;
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
	
}
