package com.yearjane.entity;

/**
 * 
 * @author 
 * 用户的类型
 */
public class UserType extends Base{
	
	private static final long serialVersionUID = 2814251762897991527L;
	//主键，自增
	private Integer id;
	//用户的类型id（0：会员；1：管理员：2：超级管理员）
	private Integer usagetype;
	//用户名称
	private String typename;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUsagetype() {
		return usagetype;
	}
	public void setUsagetype(Integer usagetype) {
		this.usagetype = usagetype;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	
}
