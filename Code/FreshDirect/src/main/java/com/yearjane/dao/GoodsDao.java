package com.yearjane.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yearjane.entity.GoodsType;

/**
 * 
 * 商品的Dao
 * @author 陈小锋
 *
 */
public interface GoodsDao {
	/**
	 * 批量添加商品类型
	 * @param goodsTypeList
	 * @return
	 */
	public int addGoodsType(@Param("goodsTypeList") List<GoodsType> goodsTypeList) ;
	
	/**
	 * 查询商品类型
	 * @param goodsType
	 * @return
	 */
	public List<GoodsType> queryGoodsTypeList(@Param("goodsType") GoodsType goodsType);
	
	/**
	 * 根据id查询Goodstype
	 * @param typeid
	 * @return
	 */
	public GoodsType queryGoodsType(@Param("typeid") Integer typeid) ;
	
	/**
	 * 根据typename查询Goodstype
	 * @param typename
	 * @return
	 */
	public GoodsType queryGoodsTypeByTypename(@Param("typename") String typename) ;
	
	
	/**
	 * 修改GoodsType
	 * @param goodsType
	 * @return
	 */
	public int updateGoodsType(@Param("goodsType") GoodsType goodsType);

	
}
