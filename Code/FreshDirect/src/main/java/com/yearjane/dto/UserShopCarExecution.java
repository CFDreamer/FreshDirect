package com.yearjane.dto;

import java.util.List;

import com.yearjane.entity.UserShopCar;
import com.yearjane.enums.ResultResponseEnum;

/**
 * 购物车的Execution
 * @author 陈小锋
 *
 */
public class UserShopCarExecution extends BaseExecution {
	private UserShopCar userShopCar;
	private List<UserShopCar> listUserShopCar;

	public UserShopCar getUserShopCar() {
		return userShopCar;
	}

	public void setUserShopCar(UserShopCar userShopCar) {
		this.userShopCar = userShopCar;
	}

	public List<UserShopCar> getListUserShopCar() {
		return listUserShopCar;
	}

	public void setListUserShopCar(List<UserShopCar> listUserShopCar) {
		this.listUserShopCar = listUserShopCar;
	}

	/**
	 * 只返回结果和状态的构造器
	 * 
	 * @param responseEnum
	 * @param status
	 */
	public UserShopCarExecution(ResultResponseEnum responseEnum, Boolean status) {
		super(responseEnum, status);
	}

	/**
	 * 
	 * @param responseEnum
	 * @param userShopCar
	 * @param status
	 */
	public UserShopCarExecution(ResultResponseEnum responseEnum, UserShopCar userShopCar, Boolean status) {
		super(responseEnum, status);
		this.userShopCar = userShopCar;
	}

	/**
	 * 
	 * @param responseEnum
	 * @param listUserShopCar
	 * @param status
	 */
	public UserShopCarExecution(ResultResponseEnum responseEnum, List<UserShopCar> listUserShopCar, Boolean status) {
		super(responseEnum, status);
		this.listUserShopCar = listUserShopCar;
	}

	public UserShopCarExecution() {

	}
}
