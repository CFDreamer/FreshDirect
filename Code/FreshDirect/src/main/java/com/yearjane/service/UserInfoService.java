package com.yearjane.service;

import com.yearjane.dto.FileParams;
import com.yearjane.dto.UserInfoExecution;
import com.yearjane.entity.UserInfo;

/**
 * UserInfo的Service
 * 
 * @author
 *
 */
public interface UserInfoService {
	/**
	 * 用户的注册
	 * 
	 * @param userinfo
	 */
	public UserInfoExecution insertUser(UserInfo userInfo,FileParams file);
	
	/**
	 * 用户的登录
	 * @param userInfo
	 * @return
	 */
	public UserInfoExecution loginUser(UserInfo userInfo,String phoneNumber,Integer loginType);
	
	/**
	 * 检测手机号是否注册
	 * @param phoneNumber
	 * @return
	 */
	public boolean checkPhoneExist(String phoneNumber);
	
	/**
	 * 用户信息的查询
	 * @param userInfo
	 * @return
	 */
	public UserInfoExecution queryUserInfo(UserInfo userInfo);
	
	/**
	 * 用户信息的更新
	 * @param userInfo
	 * @return
	 */
	public UserInfoExecution updateUserInfo(UserInfo userInfo,FileParams file);
}
