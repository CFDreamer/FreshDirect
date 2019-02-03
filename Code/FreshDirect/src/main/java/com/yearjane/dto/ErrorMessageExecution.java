package com.yearjane.dto;

import com.yearjane.enums.ResultResponseEnum;

/**
 * 仅仅返回错误信息和状态
 * @author 陈小锋
 *
 */
public class ErrorMessageExecution extends BaseExecution{
	
	public ErrorMessageExecution(ResultResponseEnum responseEnum,Boolean status) {
		super(responseEnum,status);
	}
	public ErrorMessageExecution() {

	}


	
}
