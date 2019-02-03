package com.yearjane.dto;

import com.yearjane.entity.UserInfo;


public class UserInfoSearch extends UserInfo{


	private static final long serialVersionUID = 1714363171326649727L;
	//验证码
    private String captcha;
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
    
}
