package com.yearjane.util;

import com.yearjane.enums.SmsTextModelEnum;
import com.yearjane.global.GlobalParams;

/**
 * 短信发送
 * 
 * @author 陈小锋
 *
 */
public class SmsSendUtil {
	// 用户名
	private static String Uid = GlobalParams.SMSUID;
	// 接口安全秘钥
	private static String Key = GlobalParams.SMSKEY;
	// 验证码的长度
	private static Integer defaultLength=GlobalParams.SMSLENGTH;
	public static String sendMsg(String smsMob, Integer modelCode,Integer length) {
		//如果传入的length为null那么就用默认的长度
		if(null==length) {
			length=defaultLength;
		}
		String randomCode=null;
		HttpClientUtil client = HttpClientUtil.getInstance();
		//获取4位随机数
		randomCode=RandomCodeUtil.getSmsCode(length);
		//根据smscode获取发送短信的模板
		String smsText=SmsTextModelEnum.getModelTextByCode(modelCode)+randomCode;
		// UTF发送
		int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
		if(result<=0) {
			randomCode=null;
			return randomCode;
		}
		//返回随机生成的验证码
		return randomCode;
	}
}
