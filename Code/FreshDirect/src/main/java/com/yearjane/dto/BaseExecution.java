package com.yearjane.dto;

import com.yearjane.enums.ResultResponseEnum;

public class BaseExecution {
	//返回的状态码
	private Integer code;
	//返回的信息
	private String message;
	//成功与否的状态
	private Boolean status;
	public BaseExecution() {
		
	}
	/**
	 * 只返回消息和状态的构造器
	 * @param responseEnum
	 * @param status
	 */
	public BaseExecution(ResultResponseEnum responseEnum,Boolean status) {
		this.code = responseEnum.getResultCode();
		this.message = responseEnum.getResultMessge();
		this.status=status;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
