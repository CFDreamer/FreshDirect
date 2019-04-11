package com.yearjane.controller.superadmin.goods;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yearjane.dto.FirstPageExecution;
import com.yearjane.dto.GoodsExecution;
import com.yearjane.dto.GoodsInfoSearch;
import com.yearjane.dto.GoodsTypeExecution;
import com.yearjane.dto.GoodsTypeSearch;
import com.yearjane.entity.GoodsInfo;
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
	
	@PostMapping("/querygoodstype/{userid}")
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
	
	@PostMapping("/addgoodsinfo/{userid}")
	@ResponseBody
	public Map<String,Object> addGoodsInfo(
			@PathVariable("userid") Integer userid,
			HttpServletRequest request,
			@RequestParam("goodsname") String goodsName,
			@RequestParam("imagepath") String imagePath,
			@RequestParam("typeid") Integer typeid,
			@RequestParam("oldprice") Double oldPrice,
			@RequestParam("nowprice") Double nowPrice,
			@RequestParam("stock") Integer stock,
			@RequestParam("introduce") String introduce,
			@RequestParam("isenable") Integer isenable
			){
		GoodsExecution execution=new GoodsExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		GoodsInfo info=new GoodsInfo();
		GoodsType type=new GoodsType();
		type.setTypeid(typeid);
		info.setGoodsname(goodsName);
		info.setGoodstype(type);
		info.setImagePath(imagePath);
		info.setIntroduce(introduce);
		info.setIsenable(isenable);
		info.setNowPrice(nowPrice);
		info.setOldPrice(oldPrice);
		info.setOperatorName(userInfo.getUsername());
		info.setStock(stock);
		
		try {
			execution=service.addGoodsInfo(info);
		} catch (Exception e) {
			execution=new GoodsExecution(ResultResponseEnum.RESULT_FAIL, false);
		}
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
	@PostMapping("/updategoodsinfo/{userid}")
	@ResponseBody
	public Map<String,Object> updateGoodsInfo(
			@PathVariable("userid") Integer userid,
			HttpServletRequest request,
			@RequestParam(value="goodsid",required=false) Integer goodsid,
			@RequestParam(value="goodsname" ,required=false) String goodsName,
			@RequestParam(value="imagepath",required=false) String imagePath,
			@RequestParam(value="typeid",required=false) Integer typeid,
			@RequestParam(value="oldprice",required=false) Double oldPrice,
			@RequestParam(value="nowprice",required=false) Double nowPrice,
			@RequestParam(value="stock",required=false) Integer stock,
			@RequestParam(value="introduce",required=false) String introduce,
			@RequestParam(value="isenable",required=false) Integer isenable
			){
		GoodsExecution execution=new GoodsExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		GoodsInfo info=new GoodsInfo();
		GoodsType type=null;
		if(null!=typeid) {
			type=new GoodsType();
			type.setTypeid(typeid);
		}
		info.setId(goodsid);
		info.setGoodsname(goodsName);
		info.setGoodstype(type);
		info.setImagePath(imagePath);
		info.setIntroduce(introduce);
		info.setIsenable(isenable);
		info.setNowPrice(nowPrice);
		info.setOldPrice(oldPrice);
		info.setOperatorName(userInfo.getUsername());
		info.setStock(stock);
		try {
			execution=service.updateGoodsInfo(info);
		} catch (Exception e) {
			execution=new GoodsExecution(ResultResponseEnum.RESULT_FAIL, false);
		}
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
	
	/**
	 * 查看商品详情
	 * @param userid
	 * @param goodsid
	 * @param request
	 * @return
	 */
	@GetMapping("/getgoodsinfo/{userid}/{goodsid}")
	@ResponseBody
	public Map<String,Object> getGoodsInfo(
			@PathVariable("goodsid") Integer goodsid,
			HttpServletRequest request
			){
		GoodsExecution execution=new GoodsExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		GoodsInfo info=new GoodsInfo();
		info.setId(goodsid);
		execution=service.getGoodsInfo(info);
		
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
	
	@PostMapping("/deletedgoodsinfo/{userid}")
	@ResponseBody
	public Map<String,Object> deletedGoodsInfo(
			@PathVariable("userid") Integer userid,
			HttpServletRequest request,
			@RequestBody List<Integer> goodsids
			){
		GoodsExecution execution=new GoodsExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		execution=service.deletedGoodsInfo(goodsids);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
	
	@PostMapping("/getgoodsinfobypage/{userid}")
	@ResponseBody
	public Map<String,Object> getGoodsInfoByPage(
			@PathVariable("userid") Integer userid,
			HttpServletRequest request,
			@RequestParam("pageno") Integer pageNo,
			@RequestParam(value="typeid",required=false) Integer typeid,
			@RequestParam(value="isenable",required=false) Integer isenable,
			@RequestParam(value="isdiscount",required=false) Integer isDiscount,
			@RequestParam(value="pagesize",required=false) Integer pageSize){
		GoodsExecution execution=new GoodsExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		GoodsInfo info=new GoodsInfo();
		
		GoodsType type=null;
		if(null!=typeid) {
			type=new GoodsType();
			type.setTypeid(typeid);
		}
		info.setGoodstype(type);
		info.setIsenable(isenable);
		GoodsInfoSearch search=new GoodsInfoSearch();
		System.err.println(isDiscount);
		search.setIsDiscount(isDiscount);
		execution=service.getdGoodsInfos(info, search, pageNo, pageSize);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
	
	/**
	 * 获取首页商品接口
	 * @return
	 */
	@GetMapping("/getfirstpageinfo")
	@ResponseBody
	public Map<String,Object> getFirstPageInfo(){
		Map<String,Object> map=new HashMap<String,Object>();
		FirstPageExecution execution=new FirstPageExecution();
		execution=service.getFirstPageInfo();
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
	
	/**
	 * 获取相似商品接口
	 * @param typeid
	 * @return
	 */
	@GetMapping("/getsimilargoods/{typeid}")
	@ResponseBody
	public Map<String,Object> getSimilarGoods(
			@PathVariable("typeid") Integer typeid
			){
		Map<String,Object> map=new HashMap<String,Object>();
		GoodsExecution execution=new GoodsExecution();
		GoodsType type=new GoodsType();
		type.setTypeid(typeid);
		GoodsInfo info=new GoodsInfo();
		info.setGoodstype(type);
		execution=service.getSimilarGoods(info);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
}
