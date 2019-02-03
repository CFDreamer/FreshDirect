package com.yearjane.controller.member.user;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yearjane.dto.ErrorMessageExecution;
import com.yearjane.dto.FileParams;
import com.yearjane.dto.UserInfoExecution;
import com.yearjane.dto.UserInfoSearch;
import com.yearjane.entity.UserInfo;
import com.yearjane.entity.UserType;
import com.yearjane.enums.ResultResponseEnum;
import com.yearjane.global.GlobalParams;
import com.yearjane.service.UserInfoService;
import com.yearjane.util.DateFormatUtil;
import com.yearjane.util.UserValidationUtil;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService uService;

	/**
	 * 3.1用户注册
	 * 
	 * @param username
	 * @param phone
	 * @param sex
	 * @param password
	 * @param birthday
	 * @param userImage
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/register")
	@ResponseBody
	public Map<String, Object> register(@RequestParam("username") String username, @RequestParam("phone") String phone,
			@RequestParam("sex") String sex, @RequestParam("password") String password,
			@RequestParam("birthday") String birthday,
			@RequestParam(value = "imagePath", required = false) MultipartFile userImage) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		FileParams params = null;
		if (null != userImage) {
			params = new FileParams();
			params.setFileName(userImage.getOriginalFilename());

			params.setInputStream(userImage.getInputStream());
		}
		UserInfo userInfo = new UserInfo();
		try {
			userInfo.setBirthday(DateFormatUtil.formatStringDate(birthday));
		} catch (ParseException e) {
			map.put(GlobalParams.RESULT_MESSAGE, new ErrorMessageExecution(ResultResponseEnum.BIRTHDAY_ERROR, false));
			e.printStackTrace();
			return map;
		}
		userInfo.setPassword(password);
		userInfo.setPhone(phone);
		userInfo.setSex(sex);
		userInfo.setUsername(username);
		UserInfoExecution execution = uService.insertUser(userInfo, params);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}

	/**
	 * 3.2用户登录
	 * 
	 * @param loginName:登录名（手机号或者用户名）
	 * @param password：密码
	 * @param loginType：登录的方式
	 * @param captcha：验证码
	 * @param request
	 * @return
	 */
	@GetMapping("/login")
	@ResponseBody
	public Map<String, Object> loginUser(@RequestParam(value = "loginname", required = false) String loginName,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "logintype") Integer loginType,
			@RequestParam(value = "phonenumber", required = false) String phoneNumber,
			@RequestParam(value="usagetype", required = false) Integer usagetype,
			@RequestParam(value = "captcha", required = false) String captcha, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (0 == loginType) {
			// 通过用户名和密码进行匹配
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername(loginName);
			userInfo.setPassword(password);
			UserType type=new UserType();
			type.setUsagetype(usagetype);
			userInfo.setUsagetype(type);
			UserInfoExecution execution = uService.loginUser(userInfo, phoneNumber, loginType);
			// 将用户信息存入Session
			if (execution.getStatus()) {
				request.getSession().setAttribute("userInfo", execution.getUserInfo());
			}
			map.put(GlobalParams.RESULT_MESSAGE, execution);
			// 通过手机号进行匹配
			if (!execution.getStatus()) {
				userInfo.setUsername(null);
				userInfo.setPhone(loginName);
				userInfo.setPassword(password);
				execution = uService.loginUser(userInfo, phoneNumber, loginType);
				map.put(GlobalParams.RESULT_MESSAGE, execution);
				// 将用户信息存入Session
				if (execution.getStatus()) {
					request.getSession().setAttribute("userInfo", execution.getUserInfo());
				}
				return map;
			}
			return map;
		}
		if (1 == loginType) {
			System.out.println(request.getSession().getAttribute(phoneNumber));
			System.out.println(captcha);
			if (captcha.equals(request.getSession().getAttribute(phoneNumber))) {
				UserInfoExecution execution = uService.loginUser(null, phoneNumber, 1);
				map.put(GlobalParams.RESULT_MESSAGE, execution);
				// 将用户信息存入Session
				request.getSession().setAttribute("userInfo", execution.getUserInfo());
				return map;
			} else {
				map.put(GlobalParams.RESULT_MESSAGE, new ErrorMessageExecution(ResultResponseEnum.PHONE_CAPTCHA_INPUT_ERROR, false));
			}
		}
		return map;
	}
	
	/**
	 * 3.4：用户信息的修改
	 * @param id
	 * @param sex
	 * @param password
	 * @param userImage
	 * @param birthday
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/update")
	@ResponseBody
	public Map<String, Object> updateUserInfo(
			@RequestParam(value="id") Integer id,
			@RequestParam(value="sex",required=false) String sex,
			@RequestParam(value="password",required=false) String password,
			@RequestParam(value="imagepath",required=false)  MultipartFile userImage,
			@RequestParam(value="birthday",required=false) String birthday,
			HttpServletRequest request
			) throws IOException {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		viaMap=UserValidationUtil.userValidat(request, id);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		UserInfo userInfo=new UserInfo();
		userInfo.setId(id);
		userInfo.setSex(sex);
		userInfo.setPassword(password);
		if(null!=birthday) {
		try {
			
			userInfo.setBirthday(DateFormatUtil.formatStringDate(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			map.put(GlobalParams.RESULT_MESSAGE, new ErrorMessageExecution(ResultResponseEnum.BIRTHDAY_ERROR, false));
			return map;
		}
		}
		FileParams params=null;
		if(null!=userImage) {
			params=new FileParams();
			params.setFileName(userImage.getOriginalFilename());
			params.setInputStream(userImage.getInputStream());
		}
		UserInfoExecution execution=uService.updateUserInfo(userInfo, params);
		//如果更新成功，则为session中userInfo重新赋值
		if(execution.getStatus()) {
			request.getSession().setAttribute("userInfo", execution.getUserInfo());
		}
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
	}
	
	/**
	 *3.3 用户信息的查询，单条记录
	 * @return
	 */
	@GetMapping("/queryuserinfo/{userid}")
	@ResponseBody
	public Map<String,Object> queryUserInfo(@PathVariable Integer userid,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		
		//验证用户的合法性
		Map<String, Object> viaMap = new HashMap<String, Object>();
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		UserInfo userInfo=new UserInfo();
		userInfo.setId(userid);
		UserInfoExecution execution=uService.queryUserInfo(userInfo);
		map.put(GlobalParams.RESULT_MESSAGE, execution);
		return map;
				
	}
	
	/**
	 *3.5 更新绑定的手机号
	 * @param userid
	 * @param userInfo
	 * @param request
	 * @return
	 */
	@PutMapping("/updatephone/{userid}")
	@ResponseBody
	public Map<String,Object> updatePhoneNumber(
			@PathVariable Integer userid,
			@RequestBody UserInfoSearch userInfo,
			HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String, Object> viaMap = new HashMap<String, Object>();
		viaMap=UserValidationUtil.userValidat(request, userid);
		if(viaMap.size()!=0) {
			return viaMap;
		}
		if (userInfo.getCaptcha().equals(request.getSession().getAttribute(userInfo.getPhone()))) {
			userInfo.setId(userid);
			UserInfoExecution execution = uService.updateUserInfo(userInfo, null);
			map.put(GlobalParams.RESULT_MESSAGE, execution);
			// 将用户信息存入Session
			request.getSession().setAttribute("userInfo", execution.getUserInfo());
			return map;
		} else {
			map.put(GlobalParams.RESULT_MESSAGE, new ErrorMessageExecution(ResultResponseEnum.PHONE_CAPTCHA_INPUT_ERROR, false));
		}
		return map;
	}
	/**
	 * 3.6用户的注销
	 * @param request
	 * @return
	 */
	@GetMapping("/logout")
	@ResponseBody
	public Map<String,Object> logout(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		request.getSession().invalidate();
		map.put(GlobalParams.RESULT_MESSAGE, new ErrorMessageExecution(ResultResponseEnum.RESULTOK, true));
		return map;
	}
}

