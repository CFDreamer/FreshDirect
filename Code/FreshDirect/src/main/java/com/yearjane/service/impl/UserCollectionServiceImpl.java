package com.yearjane.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yearjane.dao.UserCollectionDao;
import com.yearjane.dto.UserCollectionExecution;
import com.yearjane.entity.UserCollections;
import com.yearjane.enums.ResultResponseEnum;
import com.yearjane.service.UserCollectionService;

@Service
public class UserCollectionServiceImpl implements UserCollectionService {
	
	@Autowired
	private UserCollectionDao dao;

	@Override
	public UserCollectionExecution addCollection(UserCollections userCollections) {
		UserCollectionExecution execution=new UserCollectionExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		userCollections.setAddTime(new Date());
		int effect=dao.addUserCollections(userCollections);
		if(effect<=0) {
			execution=new UserCollectionExecution(ResultResponseEnum.RESULT_FAIL,false);
			return execution;
		}
		execution=new UserCollectionExecution(ResultResponseEnum.RESULTOK,true);
		return execution;
	}

	@Override
	public UserCollectionExecution getUserCollections(UserCollections userCollections) {
		// TODO Auto-generated method stub
		List<UserCollections> list=new ArrayList<UserCollections>();
		list=dao.getUserCollections(userCollections);
		UserCollectionExecution execution=new UserCollectionExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		execution=new UserCollectionExecution(ResultResponseEnum.RESULTOK,list,true);
		return execution;
	}

	@Override
	public UserCollectionExecution deleteUserCollections(UserCollections userCollections) {
		// TODO Auto-generated method stub
		UserCollectionExecution execution=new UserCollectionExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		int effect=dao.deletedUserCollections(userCollections);
		if(effect<=0) {
			execution=new UserCollectionExecution(ResultResponseEnum.RESULT_FAIL,false);
			return execution;
		}
		execution=new UserCollectionExecution(ResultResponseEnum.RESULTOK,true);
		return execution;
	}

}
