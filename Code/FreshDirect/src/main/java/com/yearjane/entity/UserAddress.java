package com.yearjane.entity;

/**
 * 
 * @author 
 * 用户的收货地址
 */
public class UserAddress extends Base{

	private static final long serialVersionUID = 3521902081772226790L;
	//主键id，自增
	private Integer id;
	//属于哪个人的收货地址
	private Integer uid;
	//收货人的姓名
	private String name;
	//收货人的电话
	private String phone;
	//收货人的地址
	private String address;
	//是否为默认地址（0：非默认；1：默认）
	private Integer isdefaul;
	//地址使用的次数
	private Integer useCount;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getIsdefaul() {
		return isdefaul;
	}
	public void setIsdefaul(Integer isdefaul) {
		this.isdefaul = isdefaul;
	}
	public Integer getUseCount() {
		return useCount;
	}
	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}
	
}
