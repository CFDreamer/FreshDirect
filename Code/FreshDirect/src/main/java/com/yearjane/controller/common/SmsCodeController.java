package com.yearjane.controller.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yearjane.dto.ErrorMessageExecution;
import com.yearjane.enums.ResultResponseEnum;
import com.yearjane.global.GlobalParams;
import com.yearjane.service.UserInfoService;
import com.yearjane.util.SmsSendUtil;

/**
 * 手机验证码
 * 
 * @author 陈小锋
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/sms")
public class SmsCodeController {
	@Autowired
	private UserInfoService service;

	/**
	 * 
	 * @param phoneNumber:手机号码
	 * @param codeType：验证码的类型
	 * @param flag:是否是注册，不为null代表注册
	 * @param length:验证码的长度
	 * @param request
	 */
	@PostMapping("/sendcode")
	@ResponseBody
	public Map<String, Object> sendCode(@RequestParam("phonenumber") String phoneNumber,
			@RequestParam("captchatype") String captchaType,
			@RequestParam(value = "flag", required = false) String flag,
			@RequestParam(value="length",required=false) Integer length,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 如果flag为空，则需要验证手机换号是否存在
		if (null != flag) {
			if (service.checkPhoneExist(phoneNumber)) {
				map.put(GlobalParams.RESULT_MESSAGE,
						new ErrorMessageExecution(ResultResponseEnum.PHONE_REGISTERED, false));
				return map;

			}

		} else {
			if (!service.checkPhoneExist(phoneNumber)) {
				map.put(GlobalParams.RESULT_MESSAGE,
						new ErrorMessageExecution(ResultResponseEnum.PHONE_NOTREGISTER, false));
				return map;
			}

		}
		String captcha = SmsSendUtil.sendMsg(phoneNumber, Integer.valueOf(captchaType),length);
		request.getSession().setAttribute(phoneNumber, captcha);
		map.put(GlobalParams.RESULT_MESSAGE, new ErrorMessageExecution(ResultResponseEnum.CODE_SEND_SUCCESS, true));
		return map;

	}
}
