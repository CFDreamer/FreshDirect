package com.yearjane.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yearjane.dto.GoodsInfoSearch;
import com.yearjane.entity.GoodsInfo;
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
	
	/**
	 * 商品的新增
	 * @param goodsInfo
	 * @return
	 */
	public int addGoodsInfo(@Param("goodsInfo") GoodsInfo goodsInfo) ;
	
	/**
	 * 商品的修改
	 * @param goodsInfo
	 * @return
	 */
	public int updateGoodsInfo(@Param("goodsInfo") GoodsInfo goodsInfo);
	
	/**
	 * 商品的删除
	 * @param goodsIds
	 * @return
	 */
	public int deleteGoodsInfo(@Param("goodsIds") List<Integer> goodsIds);
	
	/**
	 * 查询商品的详细信息（根据id ）
	 * @param goodsInfo
	 * @return
	 */
	public GoodsInfo getGoodsInfo(@Param("goodsInfo") GoodsInfo goodsInfo);
	
	/**
	 * 根据条件批量查询商品信息
	 * @param goodsInfo
	 * @return
	 */
	public List<GoodsInfo>getGoodsInfos(@Param("goodsInfo") GoodsInfo goodsInfo,@Param("goodsInfoSearch") GoodsInfoSearch goodsInfoSearch,@Param("star") Integer star,@Param("end") Integer end);
	
	public int getGoodsInfoCount(@Param("goodsInfo") GoodsInfo goodsInfo,@Param("goodsInfoSearch") GoodsInfoSearch goodsInfoSearch);
	
	/**
	 * 检查该商品名称是否存在
	 */
	public GoodsInfo searchGoodsnameExist(@Param("goodsInfo") GoodsInfo goodsInfo);
	
	
	/**
	 * 获取首页商品信息
	 */
	
	public List<GoodsInfo> getFirstPageGoodsInfos(@Param("goodsInfoSearch") GoodsInfoSearch goodsInfoSearch);
	
	/**
	 * 根据id查询商品的信息，用来辅助分步查询
	 * @param gid
	 * @return
	 */
	public GoodsInfo getGoodsInfoByGid(@Param("gid") Integer gid);
	
	/**
	 * 查询同类商品
	 * @param goodsInfo
	 * @return
	 */
	public List<GoodsInfo> searchSimilarGoods(@Param("goodsInfo") GoodsInfo goodsInfo);
	
}
