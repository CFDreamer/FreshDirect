package com.yearjane.service;

import java.util.List;

import com.yearjane.dto.UserShopCarExecution;
import com.yearjane.entity.UserShopCar;

public interface UserShopCarService {
	
	/**
	 * 添加购物车
	 * @param car
	 * @return
	 */
	public UserShopCarExecution addShopCar (UserShopCar car);
	/**
	 * 修改购物车
	 * @param car
	 * @return
	 */
	 public UserShopCarExecution updateShopCar(UserShopCar car);
	 
	 /**
	  * 获取购物车列表
	  * @param car
	  * @return
	  */
	 public UserShopCarExecution getShopCar(UserShopCar car);
	 
	 /**
	  * 删除购物车
	  * @param ids
	  * @return
	  */
	 public UserShopCarExecution deleteShopCar(List<Integer> ids );
}
