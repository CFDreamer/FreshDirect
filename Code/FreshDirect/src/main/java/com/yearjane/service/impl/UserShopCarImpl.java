package com.yearjane.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yearjane.dao.UserShopCarDao;
import com.yearjane.dto.UserShopCarExecution;
import com.yearjane.entity.GoodsInfo;
import com.yearjane.entity.UserShopCar;
import com.yearjane.enums.ResultResponseEnum;
import com.yearjane.service.UserShopCarService;

@Service
public class UserShopCarImpl implements UserShopCarService {
	@Autowired
	private UserShopCarDao dao;

	@Override
	public UserShopCarExecution addShopCar(UserShopCar car) {
		UserShopCarExecution execution=new UserShopCarExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		List<UserShopCar> list=new ArrayList<UserShopCar>();
		GoodsInfo info=new GoodsInfo();
		info.setId(car.getGoodsInfo().getId());
		UserShopCar search=new UserShopCar();
		search.setGoodsInfo(info);
		search.setUid(car.getUid());
		list=dao.getUserShopCar(search);
		//如果购物车不存在该商品,则添加
		if(0==list.size()) {
			car.setAddTime(new Date());
			car.setCount(1);
			car.setUpdateTime(new Date());
			int effect=dao.addUserShopCar(car);
			if(0>=effect) {
				execution=new UserShopCarExecution(ResultResponseEnum.RESULT_FAIL,false);
				return execution;
			}
			execution=new UserShopCarExecution(ResultResponseEnum.RESULTOK,true);
			return execution;
		}
		if(1==list.size()) {
			UserShopCar update=new UserShopCar();
			update.setId(list.get(0).getId());
			update.setCount(list.get(0).getCount()+1);
			update.setUpdateTime(new Date());
			int effect=dao.updateUserShopCar(update);
			if(0>=effect) {
				execution=new UserShopCarExecution(ResultResponseEnum.RESULT_FAIL,false);
				return execution;
			}
			execution=new UserShopCarExecution(ResultResponseEnum.RESULTOK,true);
			return execution;
		}
		return execution;
	}

	@Override
	@Transactional
	public UserShopCarExecution updateShopCar(UserShopCar car) {
		UserShopCarExecution execution=new UserShopCarExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		List<UserShopCar> list=new ArrayList<UserShopCar>();
		GoodsInfo info=new GoodsInfo();
		info.setId(car.getGoodsInfo().getId());
		UserShopCar search=new UserShopCar();
		search.setGoodsInfo(info);
		search.setUid(car.getUid());
		list=dao.getUserShopCar(search);
		if(list.size()!=1) {
			return execution;
		}
		UserShopCar update=new UserShopCar();
		update.setId(list.get(0).getId());
		update.setCount(car.getCount());
		update.setUpdateTime(new Date());
		int effect=dao.updateUserShopCar(update);
		if(0>=effect) {
			execution=new UserShopCarExecution(ResultResponseEnum.RESULT_FAIL,false);
			return execution;
		}
		execution=new UserShopCarExecution(ResultResponseEnum.RESULTOK,dao.getUserShopCar(update).get(0),true);
		return execution;
		
	}

	@Override
	public UserShopCarExecution getShopCar(UserShopCar car) {
		UserShopCarExecution execution=new UserShopCarExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		List<UserShopCar> list=dao.getUserShopCar(car);
		execution=new UserShopCarExecution(ResultResponseEnum.RESULTOK,list,true);
		return execution;
	}

	@Override
	public UserShopCarExecution deleteShopCar(List<Integer> ids) {
		UserShopCarExecution execution=new UserShopCarExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		int effect=dao.deleteUserShopCar(ids);
		if(0>=effect) {
			execution=new UserShopCarExecution(ResultResponseEnum.RESULT_FAIL,false);
			return execution;
		}
		execution=new UserShopCarExecution(ResultResponseEnum.RESULTOK,true);
		return execution;
	}
  
}
