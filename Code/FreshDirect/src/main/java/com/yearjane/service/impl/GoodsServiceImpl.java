package com.yearjane.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yearjane.dao.GoodsDao;
import com.yearjane.dto.GoodsTypeExecution;
import com.yearjane.entity.GoodsType;
import com.yearjane.enums.ResultResponseEnum;
import com.yearjane.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao dao;
	@Override
	@Transactional
	public GoodsTypeExecution addGoodsType(List<GoodsType> goodsTypeList) {
		GoodsTypeExecution execution=new GoodsTypeExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		Date date=new Date();
		for (GoodsType goodsType : goodsTypeList) {
			goodsType.setAddTime(date);
			goodsType.setUpdateTime(date);
			GoodsType search=null;
			search=dao.queryGoodsTypeByTypename(goodsType.getTypename());
			if(null!=search) {
				throw new RuntimeException("商品名字已经存在");
			}
		}
		int effectNum=dao.addGoodsType(goodsTypeList);
		if(effectNum<=0) {
			execution=new GoodsTypeExecution(ResultResponseEnum.GOODSTYPE_ADD_FAIL, false);	
		}
		execution=new GoodsTypeExecution(ResultResponseEnum.GOODSTYPE_ADD_SUCCESS, true);
		return execution;
	}

	@Override
	@Transactional
	public GoodsTypeExecution updateGoodsType(GoodsType goodsType) {
		GoodsTypeExecution execution=new GoodsTypeExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		GoodsType search=null;
		search=dao.queryGoodsTypeByTypename(goodsType.getTypename());
		if(null!=search) {
			throw new RuntimeException("商品名字已经存在");
		}
		goodsType.setUpdateTime(new Date());
		int effectNum=dao.updateGoodsType(goodsType);
		if(effectNum<=0) {
			execution=new GoodsTypeExecution(ResultResponseEnum.GOODSTYPE_UPDATE_FAIL, false);	
		}
		execution=new GoodsTypeExecution(ResultResponseEnum.GOODSTYPE_UPDATE_SUCCESS,true);
		return execution;
	}

	@Override
	public GoodsTypeExecution queryGoodsType(GoodsType goodsType) {
		goodsType.setIsdeleted(0);
		GoodsTypeExecution execution=new GoodsTypeExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		try {
		  List<GoodsType> list=dao.queryGoodsTypeList(goodsType);
		  execution=new GoodsTypeExecution(ResultResponseEnum.RESULTOK, list, true);
		}catch(Exception e) {
			return execution;
		}
		return execution;
	}

	@Override
	@Transactional
	public GoodsTypeExecution deleteGoodsType(List<Integer> goodsTypeIdList) {
		GoodsTypeExecution execution=new GoodsTypeExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		for (Integer id : goodsTypeIdList) {
			GoodsType goodsType=new GoodsType();
			goodsType.setTypeid(id);
			goodsType.setUpdateTime(new Date());
			goodsType.setIsdeleted(1);
			int effectNum=dao.updateGoodsType(goodsType);
			if(effectNum<=0) {
				throw new RuntimeException("删除失败");
			}
		}
		execution=new GoodsTypeExecution(ResultResponseEnum.RESULTSUCCESS,true);
		return execution;
	}



}
