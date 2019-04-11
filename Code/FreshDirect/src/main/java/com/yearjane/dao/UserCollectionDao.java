package com.yearjane.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yearjane.entity.UserCollections;

public interface UserCollectionDao {
    /**
     * 查询商品收藏列表
     * @param userCollections
     * @return
     */
	public List<UserCollections> getUserCollections(@Param("userCollections") UserCollections userCollections);
	
	/**
	 * 添加用户收藏
	 * @param userCollections
	 * @return
	 */
	public int addUserCollections(@Param("userCollections") UserCollections userCollections);
	
	/**
	 * 取消收藏
	 * @param userCollections
	 * @return
	 */
	public int deletedUserCollections(@Param("userCollections") UserCollections userCollections);
}
