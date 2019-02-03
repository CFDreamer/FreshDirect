package com.yearjane.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yearjane.util.CustomDateYMDHDSSerialize;
import com.yearjane.util.CustomDateYMDSerialize;

/**
 * 
 * @author
 * 用户类
 */
public class UserInfo extends Base{
	private static final long serialVersionUID = -3988184031168467116L;
	//主键id
	private Integer id;
	//用户名
	private String username;
	//用户手机号
	private String phone;
	//用户性别
	private String sex;
	//用户的密码
	private String password;
	//用户的类型
	private UserType usagetype;
	//用户的头像地址
	private String imagePath;
	//用户的生日
	private Date birthday;
	//用户的注册时间
	private Date signTime;
	//最后更新时间
	private Date updateTime;
	//账号是否可用（0：不可用；1：可用）
	private Integer isenable;
	//备注
	private String remarks;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getUsagetype() {
		return usagetype;
	}
	public void setUsagetype(UserType usagetype) {
		this.usagetype = usagetype;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@JsonSerialize(using=CustomDateYMDSerialize.class)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@JsonSerialize(using=CustomDateYMDHDSSerialize.class)
	public Date getSignTime() {
		return signTime;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	@JsonSerialize(using=CustomDateYMDHDSSerialize.class)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getIsenable() {
		return isenable;
	}
	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", phone=" + phone + ", sex=" + sex + ", password="
				+ password + ", usagetype=" + usagetype + ", imagePath=" + imagePath + ", birthday=" + birthday
				+ ", signTime=" + signTime + ", updateTime=" + updateTime + ", isenable=" + isenable + ", remarks="
				+ remarks + "]";
	}
	

}
