package com.yearjane.dto;

import java.util.List;

import com.yearjane.entity.UserCollections;
import com.yearjane.enums.ResultResponseEnum;

public class UserCollectionExecution extends BaseExecution {
	private UserCollections userCollections;
	private List<UserCollections> listUserCollections;

	public UserCollections getUserCollections() {
		return userCollections;
	}

	public void setUserCollections(UserCollections userCollections) {
		this.userCollections = userCollections;
	}

	public List<UserCollections> getListUserCollections() {
		return listUserCollections;
	}

	public void setListUserCollections(List<UserCollections> listUserCollections) {
		this.listUserCollections = listUserCollections;
	}
	/**
	 * 只返回结果和状态的构造器
	 * @param responseEnum
	 * @param status
	 */
	public UserCollectionExecution (ResultResponseEnum responseEnum,Boolean status) {
		super(responseEnum,status);
	}
	/**
	 * 操作单个
	 * @param responseEnum
	 * @param userCollections
	 * @param status
	 */
	public UserCollectionExecution(ResultResponseEnum responseEnum,UserCollections userCollections,Boolean status) {
		super(responseEnum,status);
		this.userCollections=userCollections;
	}
	
	/**
	 * 批量操作
	 */
	
	public UserCollectionExecution(ResultResponseEnum responseEnum,List<UserCollections> listUserCollections,Boolean status) {
		super(responseEnum,status);
		this.listUserCollections=listUserCollections;
	}
	
	public UserCollectionExecution() {
		
	}
}
