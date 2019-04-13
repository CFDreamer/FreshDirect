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
import org.springframework.web.bind.annotation.ResponseBody;

import com.yearjane.dto.Order;
import com.yearjane.dto.OrderDetailExecution;
import com.yearjane.dto.OrderInfoExecution;
import com.yearjane.dto.UserAddressExecution;
import com.yearjane.dto.UserShopCarExecution;
import com.yearjane.entity.OrderDetail;
import com.yearjane.entity.OrderInfo;
import com.yearjane.entity.UserAddress;
import com.yearjane.global.GlobalParams;
import com.yearjane.service.OrderService;
import com.yearjane.util.UserValidationUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/user/operation")
public class OrderController {
   @Autowired
   private OrderService service;
   
   /**
    * 获取结算页面的商品信息
    * @param userid
    * @param carsid
    * @param request
    * @return
    */
   @PostMapping("/getaccountpage/{userid}")
   @ResponseBody
   public Map<String,Object> getAccountPage(@PathVariable("userid") Integer userid,
		   @RequestBody List<Integer> carsid,HttpServletRequest request){
	   UserShopCarExecution execution=new UserShopCarExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		execution=service.createAccountPage(carsid);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
   }
   /**
    * 获取用户收货地址
    * @param userid
    * @param request
    * @param address
    * @return
    */
   @PostMapping("/getuseraddress/{userid}")
   @ResponseBody
   public Map<String,Object> getUserAddress(@PathVariable("userid") Integer userid,
		   HttpServletRequest request,@RequestBody UserAddress address
		   ){
	   UserAddressExecution execution=new UserAddressExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		execution=service.getUserAddress(address);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
   }
   
   
   /**
    * 订单的创建
    * @param userid
    * @param request
    * @param address
    * @param order
    * @return
    */
   @PostMapping("/createorder/{userid}")
   @ResponseBody
   public Map<String,Object> createOrder(@PathVariable("userid") Integer userid,
		   HttpServletRequest request,@RequestBody Order order){
	   OrderInfoExecution execution=new OrderInfoExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		execution=service.creteOrder(userid, order);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
   }
   
   /**
    * 订单的查询
    * @param userid
    * @param request
    * @param orderInfo
    * @return
    */
   @PostMapping("/getorder/{userid}")
   @ResponseBody
   public Map<String,Object> getOrder(@PathVariable("userid") Integer userid,
		   HttpServletRequest request,@RequestBody OrderInfo orderInfo){
	   OrderInfoExecution execution=new OrderInfoExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		execution=service.getOrderInfos(orderInfo);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
   }
   
   /**
    *获取订单详情
    * @param userid
    * @param request
    * @param orderInfo
    * @param ono
    * @return
    */
   @PostMapping("/getorderdetail/{userid}/{ono}")
   @ResponseBody
   public Map<String,Object> getOrderDetail(@PathVariable("userid") Integer userid,
		   HttpServletRequest request,@PathVariable("ono") String ono){
	   OrderDetailExecution execution=new OrderDetailExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		OrderDetail detail=new OrderDetail();
		detail.setOno(ono);
		execution=service.getDetaInfos(detail);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
   }
   
   /**
    * 订单状态的修改，也就是付款成功。
    * @param userid
    * @param request
    * @param orderInfo
    * @param ono
    * @return
    */
   @PostMapping("/updateorderstate/{userid}/{ono}")
   @ResponseBody
   public Map<String,Object> updateOrderState(@PathVariable("userid") Integer userid,
		   HttpServletRequest request,@PathVariable("ono") String ono){
	   OrderInfoExecution execution=new OrderInfoExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		execution=service.updateOrder(ono);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
   }
   
   /**
    * 订单的删除，单个删除
    * @param userid
    * @param request
    * @param orderInfo
    * @param ono
    * @return
    */
   @GetMapping("/deleteorder/{userid}/{ono}")
   @ResponseBody
   public Map<String,Object> deleteOrder(@PathVariable("userid") Integer userid,
		   HttpServletRequest request,@PathVariable("ono") String ono){
	   OrderInfoExecution execution=new OrderInfoExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		execution=service.deleteOrder(ono);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
   }
   /**
    * 新增收货地址
    * @param userid
    * @param request
    * @param address
    * @return
    */
   @PostMapping("/adduseraddress/{userid}")
   @ResponseBody
   public Map<String,Object> addUserAddress(@PathVariable("userid") Integer userid,
		   HttpServletRequest request,@RequestBody UserAddress address){
	   UserAddressExecution execution=new UserAddressExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		execution=service.addUserAddress(address);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
   }
   
   /**
    * 更新收货地址
    * @param userid
    * @param request
    * @param address
    * @return
    */
   @PostMapping("/updateuseraddress/{userid}")
   @ResponseBody
   public Map<String,Object> updateUserAddress(@PathVariable("userid") Integer userid,
		   HttpServletRequest request,@RequestBody UserAddress address){
	   UserAddressExecution execution=new UserAddressExecution();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		//验证用户的合法性
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		execution=service.updateUserAddress(address);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
   }
   
}
