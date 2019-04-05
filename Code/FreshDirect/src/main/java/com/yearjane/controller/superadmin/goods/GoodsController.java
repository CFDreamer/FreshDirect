package com.yearjane.controller.superadmin.goods;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yearjane.dto.GoodsTypeExecution;
import com.yearjane.dto.GoodsTypeSearch;
import com.yearjane.entity.GoodsType;
import com.yearjane.entity.UserInfo;
import com.yearjane.enums.ResultResponseEnum;
import com.yearjane.global.GlobalParams;
import com.yearjane.service.GoodsService;
import com.yearjane.util.UserValidationUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService service;
	
	@PostMapping("/addgoodstype/{userid}")
	@ResponseBody
	public Map<String,Object> addGoodsType(@RequestBody List<GoodsTypeSearch> goodsTypeSearchList,@PathVariable("userid") Integer userid,HttpServletRequest request){
		GoodsTypeExecution execution=new GoodsTypeExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		//获取UserInfo
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
		List<GoodsType> list=new ArrayList<GoodsType>();
		GoodsType goodsType=null;
		for (GoodsTypeSearch goodsTypeSearch : goodsTypeSearchList) {
			 goodsType=new GoodsType();
			//将前台传递的信息写入GoodsType对象中
			goodsType.setTypeid(goodsTypeSearch.getTypeid());
			goodsType.setOperatorName(userInfo.getUsername());
			goodsType.setTypename(goodsTypeSearch.getTypename());
			GoodsType parent=new GoodsType();
			parent.setTypeid(goodsTypeSearch.getParentid());
			if(null!=goodsTypeSearch.getParentid()) {
			  goodsType.setParent(parent);
			}
			list.add(goodsType);
			
		}
		try {
			execution=service.addGoodsType(list);
		} catch (Exception e) {
			execution=new GoodsTypeExecution(ResultResponseEnum.GOODSTYPE_TYPENAME_EXITED, false);
		}
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
	
	
	@PutMapping("/updategoodstype/{userid}")
	@ResponseBody
	public Map<String,Object> updateGoodsType(@RequestBody GoodsTypeSearch goodsTypeSearch,@PathVariable("userid") Integer userid,HttpServletRequest request){
		GoodsTypeExecution execution=new GoodsTypeExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		//获取UserInfo
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
		GoodsType goodsType=new GoodsType();
		//将前台传递的信息写入GoodsType对象中
		goodsType.setTypeid(goodsTypeSearch.getTypeid());
		goodsType.setOperatorName(userInfo.getUsername());
		goodsType.setTypename(goodsTypeSearch.getTypename());
		GoodsType parent=new GoodsType();
		parent.setTypeid(goodsTypeSearch.getParentid());
		if(null!=goodsTypeSearch.getParentid()) {
		goodsType.setParent(parent);
		}
		try {
			execution=service.updateGoodsType(goodsType);
		} catch (Exception e) {
			execution=new GoodsTypeExecution(ResultResponseEnum.GOODSTYPE_TYPENAME_EXITED, false);
		}
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
	
	@GetMapping("/querygoodstype/{userid}")
	@ResponseBody
	public Map<String,Object> querygoodsType(@RequestBody GoodsTypeSearch goodsTypeSearch,@PathVariable("userid") Integer userid,HttpServletRequest request){
		GoodsTypeExecution execution=new GoodsTypeExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		GoodsType goodsType=new GoodsType();
		GoodsType parent=new GoodsType();
		parent.setTypeid(goodsTypeSearch.getParentid());
		if(null!=goodsTypeSearch.getParentid()) {
			goodsType.setParent(parent);
		}
		System.out.println(goodsTypeSearch.getParentid());
		execution=service.queryGoodsType(goodsType);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
	
	@PostMapping("/deletegoodstype/{userid}")
	@ResponseBody
	public Map<String,Object> deleteGoodType(@RequestBody List<Integer> goodstypeidlist,@PathVariable("userid") Integer userid,HttpServletRequest request){
		System.out.println(goodstypeidlist);
		GoodsTypeExecution execution=new GoodsTypeExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		try {
			execution=service.deleteGoodsType(goodstypeidlist);
		} catch (Exception e) {
			execution=new GoodsTypeExecution(ResultResponseEnum.RESULT_FAIL, false);
		}
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
}
