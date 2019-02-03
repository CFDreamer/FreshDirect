package com.yearjane.dto;

import java.util.Map;

import com.yearjane.enums.ResultResponseEnum;

/**
 * 结果返回处理类
 * @author 陈小锋
 *
 */
public class ResultResopnse {
	//返回的状态码
	private Integer resultCode;
	//状态码对应的信息
	private String resultMessage;
	private Boolean status;
	
	//返回的内容
	private Map<String,Object> body;
	public Integer getResultCode() {
		return resultCode;
	}
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
		this.resultMessage=ResultResponseEnum.getResultMessageByCode(resultCode);
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public Map<String, Object> getBody() {
		return body;
	}
	public void setBody(Map<String, Object> body) {
		this.body = body;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
