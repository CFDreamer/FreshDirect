package com.yearjane.dto;

import com.yearjane.entity.UserInfo;
import com.yearjane.enums.ResultResponseEnum;

/**
 * 
 * @author 
 * UserInfoExecution
 */
public class UserInfoExecution extends BaseExecution{

	private UserInfo userInfo;
	/**
	 * 操作失败的构造器
	 * 注册成功的构造器
	 * @param responseEnum
	 */
	public UserInfoExecution(ResultResponseEnum responseEnum,Boolean status) {
		super(responseEnum,status);

	}

	/**
	 * 操作成功的构造器
	 * 
	 * @param responseEnum
	 * @param userInfo
	 */
	public UserInfoExecution(ResultResponseEnum responseEnum, UserInfo userInfo,Boolean status) {
		super(responseEnum,status);
		this.userInfo = userInfo;


	}
	public UserInfoExecution() {

	}
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}


}
