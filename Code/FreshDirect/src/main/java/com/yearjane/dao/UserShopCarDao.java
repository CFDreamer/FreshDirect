package com.yearjane.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yearjane.entity.UserShopCar;

public interface UserShopCarDao {
  
	/**
	 * 添加商品到用户购物车
	 * @param car
	 * @return
	 */
  public  Integer addUserShopCar(@Param("car") UserShopCar car);
  
  /**
   * 查询用户购物车
   * @param car
   * @return
   */
  public List<UserShopCar> getUserShopCar(@Param("car") UserShopCar car);
  
  /**
   * 更新用户购物车
   * @param car
   * @return
   */
  public Integer updateUserShopCar(@Param("car") UserShopCar car);
  
  /**
   * 删除用户的购物车，支持批量删除
   * @param ids
   * @param uid
   * @return
   */
  public Integer deleteUserShopCar(@Param("ids") List<Integer> ids);
  
}
