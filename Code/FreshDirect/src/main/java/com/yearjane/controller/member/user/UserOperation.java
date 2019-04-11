package com.yearjane.controller.member.user;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yearjane.dto.UserCollectionExecution;
import com.yearjane.dto.UserShopCarExecution;
import com.yearjane.entity.GoodsInfo;
import com.yearjane.entity.UserCollections;
import com.yearjane.entity.UserShopCar;
import com.yearjane.enums.ResultResponseEnum;
import com.yearjane.global.GlobalParams;
import com.yearjane.service.UserCollectionService;
import com.yearjane.service.UserShopCarService;
import com.yearjane.util.UserValidationUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/user/operation")
public class UserOperation {
  @Autowired
  private UserCollectionService service;
  
  @Autowired
  private UserShopCarService cService;
  
  /**
   * 添加收藏
   * @param userid
   * @param goodsid
   * @param request
   * @return
   */
  @PostMapping("/addcollection/{userid}/{goodsid}")
  @ResponseBody
  public Map<String,Object> addUserCollection(
		  @PathVariable("userid") Integer userid,
		  @PathVariable("goodsid") Integer goodsid,
		  HttpServletRequest request
		  ){
	  UserCollectionExecution execution=new UserCollectionExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		UserCollections userCollections=new UserCollections();
		GoodsInfo g=new GoodsInfo();
		g.setId(goodsid);
		userCollections.setGid(g);
		userCollections.setUid(userid);
		execution=service.getUserCollections(userCollections);
		if(1==execution.getListUserCollections().size()) {
			map.put(GlobalParams.RESULT_MESSAGE, new UserCollectionExecution(ResultResponseEnum.COLLECTION_EXIST,false));
			return map;
		}
		execution=service.addCollection(userCollections);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
    }
  
  /**
   * 获取用户收藏列表
   * @param userid
   * @param request
   * @return
   */
  @GetMapping("/getcollections/{userid}")
  @ResponseBody
  public Map<String,Object> getCollections(
		  @PathVariable("userid") Integer userid,
		  HttpServletRequest request){
	  UserCollectionExecution execution=new UserCollectionExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		UserCollections userCollections=new UserCollections();
		userCollections.setUid(userid);
		execution=service.getUserCollections(userCollections);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
  }
  
  /**
   * 判断是否收藏
   * @param userid
   * @param goodsid
   * @param request
   * @return
   */
  @GetMapping("/iscollection/{userid}/{goodsid}")
  @ResponseBody
  public Map<String,Object> isCollection(
		  @PathVariable("userid") Integer userid,
		  @PathVariable("goodsid") Integer goodsid,
		  HttpServletRequest request){
	  UserCollectionExecution execution=new UserCollectionExecution();
	    Boolean flag=false;
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		UserCollections userCollections=new UserCollections();
		GoodsInfo g=new GoodsInfo();
		g.setId(goodsid);
		userCollections.setGid(g);
		userCollections.setUid(userid);
		execution=service.getUserCollections(userCollections);
		if(0==execution.getListUserCollections().size()) {
			flag=false;
		}
		if(1==execution.getListUserCollections().size()) {
			flag=true;
		}
		map.put("flag", flag);
		map.put("status", true);
		return map;
  }
  
  /**
   * 删除收藏
   * @param userid
   * @param goodsid
   * @param request
   * @return
   */
  @GetMapping("/deletecollection/{userid}/{goodsid}")
  @ResponseBody
  public Map<String,Object> deleteCollection(
		  @PathVariable("userid") Integer userid,
		  @PathVariable("goodsid") Integer goodsid,
		  HttpServletRequest request){
	  UserCollectionExecution execution=new UserCollectionExecution();
	    Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		UserCollections userCollections=new UserCollections();
		GoodsInfo g=new GoodsInfo();
		g.setId(goodsid);
		userCollections.setGid(g);
		userCollections.setUid(userid);
		execution=service.deleteUserCollections(userCollections);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
  }
  
  @PostMapping("/addshopcar/{userid}/{goodsid}")
  @ResponseBody
  public Map<String,Object> addShopCar( @PathVariable("userid") Integer userid,
		  @PathVariable("goodsid") Integer goodsid,
		  HttpServletRequest request){
	  UserShopCarExecution execution=new UserShopCarExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
	    Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
	  GoodsInfo info=new GoodsInfo();
	  info.setId(goodsid);
	  UserShopCar car=new UserShopCar();
	  car.setUid(userid);
	  car.setGoodsInfo(info);
	  execution=cService.addShopCar(car);
	  map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
  }
  @PostMapping("/updateshopcar/{userid}/{goodsid}")
  @ResponseBody
  public Map<String,Object> updateShopCar( @PathVariable("userid") Integer userid,
		  @PathVariable("goodsid") Integer goodsid,
		  HttpServletRequest request,
		  @RequestParam("count") Integer count){
	  UserShopCarExecution execution=new UserShopCarExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
	    Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		  GoodsInfo info=new GoodsInfo();
		  info.setId(goodsid);
		  UserShopCar car=new UserShopCar();
		  car.setCount(count);
		  car.setUid(userid);
		  car.setGoodsInfo(info);
		  execution=cService.updateShopCar(car);
		  map.put(GlobalParams.RESULT_MESSAGE, execution);
			return map;
  }
  
  @GetMapping("/getshopcar/{userid}")
  @ResponseBody
  public Map<String,Object> updateShopCar( @PathVariable("userid") Integer userid,
		  HttpServletRequest request){
	   Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
	  UserShopCarExecution execution=new UserShopCarExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
	  UserShopCar car=new UserShopCar();
	  car.setUid(userid);
	  execution=cService.getShopCar(car);
	  map.put(GlobalParams.RESULT_MESSAGE, execution);
	return map;
	  
  }
  
  @PostMapping("/deleteshopcar/{userid}")
  @ResponseBody
  public Map<String,Object> deleteShopCar(@RequestBody List<Integer> ids,
		  HttpServletRequest request, @PathVariable("userid") Integer userid){
	  Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
	  UserShopCarExecution execution=new UserShopCarExecution(ResultResponseEnum.SYSTEM_INNER_ERROR,false);
	  execution=cService.deleteShopCar(ids);
	  map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	  
  }
  
  
}
