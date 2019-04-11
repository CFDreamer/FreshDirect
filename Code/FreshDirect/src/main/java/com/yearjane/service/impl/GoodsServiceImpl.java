package com.yearjane.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yearjane.dao.GoodsDao;
import com.yearjane.dto.FirstPageExecution;
import com.yearjane.dto.GoodsExecution;
import com.yearjane.dto.GoodsInfoSearch;
import com.yearjane.dto.GoodsSearch;
import com.yearjane.dto.GoodsTypeExecution;
import com.yearjane.dto.Page;
import com.yearjane.entity.GoodsInfo;
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
	
	@Transactional
	@Override
	public GoodsExecution addGoodsInfo(GoodsInfo goodsInfo) {
		GoodsExecution execution=new GoodsExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		
		/**
		 * 验证商品名称是否已经存在
		 */
		GoodsInfo exist=null;
		exist=dao.searchGoodsnameExist(goodsInfo);
		if(null!=exist) {
			execution=new GoodsExecution(ResultResponseEnum.GOODS_NAME_EXIST,false);
			return execution;
		}
		goodsInfo.setCreateTime(new Date());
		goodsInfo.setUpdateTime(new Date());
		int effect=0;
		try {
			effect=dao.addGoodsInfo(goodsInfo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			execution=new GoodsExecution(ResultResponseEnum.RESULT_FAIL,false);
			return execution;
		}
		
		if(effect<=0) {
			throw new RuntimeException("添加失败");
		}
		execution=new GoodsExecution(ResultResponseEnum.RESULTSUCCESS,true);
		return execution;
	}
	
	@Transactional
	@Override
	public GoodsExecution updateGoodsInfo(GoodsInfo goodsInfo) {
		GoodsExecution execution=new GoodsExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		/**
		 * 验证商品名称是否已经存在
		 */
		GoodsInfo exist=null;
		exist=dao.searchGoodsnameExist(goodsInfo);
		if(null!=exist) {
			execution=new GoodsExecution(ResultResponseEnum.GOODS_NAME_EXIST,false);
			return execution;
		}
		goodsInfo.setUpdateTime(new Date());
		int effect=0;
		try {
			effect=dao.updateGoodsInfo(goodsInfo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			execution=new GoodsExecution(ResultResponseEnum.RESULT_FAIL,false);
			return execution;
		}
		
		if(effect<=0) {
			throw new RuntimeException("更新失败");
		}
		execution=new GoodsExecution(ResultResponseEnum.RESULTSUCCESS,true);
		return execution;
	}
	
	@Transactional
	@Override
	public GoodsExecution getGoodsInfo(GoodsInfo goodsInfo) {
		GoodsExecution execution=new GoodsExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		GoodsInfo g=dao.getGoodsInfo(goodsInfo);
		//商品浏览次数+1
		GoodsInfo update=new GoodsInfo();
		update.setId(goodsInfo.getId());
		update.setClickCout(g.getClickCout()+1);
		dao.updateGoodsInfo(update);
		execution=new  GoodsExecution(ResultResponseEnum.RESULTSUCCESS,g,true);
		return execution;
	}
	
	
	@Transactional
	@Override
	public GoodsExecution deletedGoodsInfo(List<Integer> goodInfoIds) {
		// TODO Auto-generated method stub
		GoodsExecution execution=new GoodsExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		dao.deleteGoodsInfo(goodInfoIds);
		execution=new GoodsExecution(ResultResponseEnum.RESULTSUCCESS,true);
		return execution;
	}

	@Override
	public GoodsExecution getdGoodsInfos(GoodsInfo goodsInfo, GoodsInfoSearch search, Integer pageNo,Integer pageSize) {
		GoodsExecution execution=new GoodsExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		
		if(null==pageSize) {
			pageSize=10;
		}
		//查询总的记录数
		int totalCount=dao.getGoodsInfoCount(goodsInfo, search);
		//计算总页数
		int totalPage=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize)+1;
		//如果当前页大于总页数则为第一页
		pageNo=pageNo>totalPage?1:pageNo;
		//计算起始索引
		int star=(pageNo-1)*pageSize;
		List<GoodsInfo> list=new ArrayList<GoodsInfo>();
		list=dao.getGoodsInfos(goodsInfo, search, star, pageSize);
		Page page=new Page();
		page.setGoodList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage(totalPage);
		execution=new GoodsExecution(ResultResponseEnum.RESULTOK,page,true);
		return execution;
	}

	@Override
	public FirstPageExecution getFirstPageInfo() {
		FirstPageExecution execution=new FirstPageExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		GoodsInfoSearch info=new GoodsInfoSearch();
		//获取折扣商品
		info.setIsDiscount(1);
		List<GoodsInfo> disCount=dao.getFirstPageGoodsInfos(info);
		
		//获取热门商品
		info=null;
		info=new GoodsInfoSearch();
		info.setIsHot(1);
		List<GoodsInfo> hot=dao.getFirstPageGoodsInfos(info);
		
		//获取热门商品
		info=null;
		info=new GoodsInfoSearch();
		info.setIsNewGoods(1);;
		List<GoodsInfo> newGoods=dao.getFirstPageGoodsInfos(info);
		
		execution=new FirstPageExecution(ResultResponseEnum.RESULTOK, disCount, hot, newGoods, true);
		
		
		
		return execution;
	}

	@Override
	public GoodsExecution getSimilarGoods(GoodsInfo goodsInfo) {
		GoodsExecution execution=new GoodsExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
		List<GoodsInfo> list=dao.searchSimilarGoods(goodsInfo);
		execution=new GoodsExecution(ResultResponseEnum.RESULTOK, list, true);
		return execution;
	}



}
