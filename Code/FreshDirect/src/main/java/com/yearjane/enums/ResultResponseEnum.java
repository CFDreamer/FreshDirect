package com.yearjane.enums;

public enum ResultResponseEnum {
	//成功返回
	RESULTSUCCESS(0, "成功!"),
	RESULTOK(200, "操作成功!"),
	USER_INSERT_ERROR(1001,"注册失败！"),
	USERNAME_EXIT(1002,"用户名已经存在！"),
	LOGIN_SUCCESS(1003,"登录成功！"),
	LOGIN_FAIL(1004,"登录失败！"),
	PHONE_NOTREGISTER(1005,"手机号未注册"),
	PHONE_REGISTERED(1006,"手机号已经被注册"),
	CODE_SEND_SUCCESS(1007,"验证码发送成功"),
	NO_POWER(1008,"没有操作权限"),
	RESULT_FAIL(1009,"操作失败"),
	USER_NOLOGIN(10010,"用户尚未登录"),
	USER_UPDATE_FAIL(1011,"更新失败"),
	USER_UPDATE_SUCCESS(1012,"更新成功"),
	BIRTHDAY_ERROR(1013,"生日格式错误"),
	PHONE_CAPTCHA_INPUT_ERROR(1014,"手机验证码输入错误"),
	PICTURE_CAPTCHA_INPUT_ERROR(1015,"图片验证码输入错误"),
	GOODSTYPE_ADD_FAIL(1016,"商品类型添加失败"),
	GOODSTYPE_ADD_SUCCESS(1017,"商品类型添加成功"),
	GOODSTYPE_UPDATE_FAIL(1018,"商品类型更新失败"),
	GOODSTYPE_UPDATE_SUCCESS(1019,"商品类型更新成功"),
	GOODSTYPE_TYPENAME_EXITED(1020,"商品类型已经存在"),
	SYSTEM_INNER_ERROR(-1001,"系统内部错误！");
	
	private Integer resultCode;
	private String resultMessge;

	private ResultResponseEnum(Integer resultCode, String resultMessge) {
		this.resultCode = resultCode;
		this.resultMessge = resultMessge;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public String getResultMessge() {
		return resultMessge;
	}
	/**
	 * 根据返回的状态码，获取返回值
	 * @param resultCode
	 * @return
	 */
	public static String getResultMessageByCode(Integer resultCode) {
		String messge=null;
		for(ResultResponseEnum responseEnum:ResultResponseEnum.values()) {
			if(resultCode.equals(responseEnum.getResultCode())) {
				messge=responseEnum.getResultMessge();
			}
		}
		return messge;
	}

}
