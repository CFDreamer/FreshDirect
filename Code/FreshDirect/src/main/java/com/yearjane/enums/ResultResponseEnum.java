package com.yearjane.enums;

public enum ResultResponseEnum {
	//成功返回
	RESULTSUCCESS(0, "成功!");
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
