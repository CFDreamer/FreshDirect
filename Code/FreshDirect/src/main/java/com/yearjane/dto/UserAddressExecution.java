package com.yearjane.dto;

import java.util.List;

import com.yearjane.entity.UserAddress;
import com.yearjane.enums.ResultResponseEnum;

public class UserAddressExecution extends BaseExecution {
	private UserAddress userAddress;
	private List<UserAddress> userAddressList;

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public List<UserAddress> getUserAddressList() {
		return userAddressList;
	}

	public void setUserAddressList(List<UserAddress> userAddressList) {
		this.userAddressList = userAddressList;
	}
	
	/**
	 * 
	 * @param responseEnum
	 * @param status
	 */
	public UserAddressExecution(ResultResponseEnum responseEnum, Boolean status) {
		super(responseEnum, status);
	}
	
	/**
	 * 
	 * @param responseEnum
	 * @param userAddress
	 * @param status
	 */
	public UserAddressExecution(ResultResponseEnum responseEnum, UserAddress userAddress, Boolean status) {
		super(responseEnum, status);
		this.userAddress = userAddress;
	}
	/**
	 * 
	 * @param responseEnum
	 * @param userAddressList
	 * @param status
	 */
	public UserAddressExecution(ResultResponseEnum responseEnum, List<UserAddress> userAddressList, Boolean status) {
		super(responseEnum, status);
		this.userAddressList = userAddressList;
	}

	/**
	 * 
	 */
	public UserAddressExecution() {

	}
}
