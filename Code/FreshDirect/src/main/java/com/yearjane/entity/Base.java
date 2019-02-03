package com.yearjane.entity;

import java.io.Serializable;

/**
 * 
 * @author 
 * 实体类的基类
 */
public class Base implements Serializable{
	private static final long serialVersionUID = -8027803238628306046L;
	//是否被删除（0：未删除；1已删除）
	private Integer isdeleted;
	
	public Integer getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(Integer isdeleted) {
		this.isdeleted = isdeleted;
	}

}
