package com.yearjane.enums;

/**
 * 短信模板
 * @author 陈小锋
 *
 */
public enum SmsTextModelEnum {
	FINDPASSWORD(5001,"【鲜直达】尊敬的用户，您的验证码为:"),
	//注册短信模板
	REGISTERMODEL(5002,"【鲜直达】尊敬的用户，欢迎使用鲜直达平台，您的验证码为:"),
	//登录短信模板
	LOGINMODEL(5003,"【鲜直达】尊敬的用户，您的临时登录密码为:");
	//找回密码的短信模板
	
    private Integer modelCode;
	private String modelText;
	private SmsTextModelEnum(Integer modelCode,String modelText) {
		this.modelCode=modelCode;
		this.modelText=modelText;
	}
	public Integer getModelCode() {
		return modelCode;
	}
	public String getModelText() {
		return modelText;
	} 
	/**
	 * 根据modelCode获取text
	 * @param modelCode
	 * @return
	 */
	public static String getModelTextByCode(Integer modelCode) {
		String text="";
		for(SmsTextModelEnum modelEnum:SmsTextModelEnum.values()) {
			if(modelCode.equals(modelEnum.getModelCode())) {
				text=modelEnum.getModelText();
			}
		}
		return text;
	}
	
}
