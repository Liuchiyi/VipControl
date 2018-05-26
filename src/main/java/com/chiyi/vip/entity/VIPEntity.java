package com.chiyi.vip.entity;

public class VIPEntity {
	
	
	private String id;
	/**vip编号*/
	private String code;
	/**姓名*/
	private String name;
	/**性别*/
	private boolean sex;
	/**年龄*/
	private int age;
	/**qq*/
	private String qq;
	/**email*/
	private String email;
	/**邮寄地址*/
	private String address;
	/**邮政编码*/
	private String zip;
	/**备注*/
	private String remark;
	/**vip等级*/
	private int rank;
	/**当前消费金额(分)*/
	private int amount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMale() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "VipEntity [id=" + id + ", code=" + code + ", name=" + name + ", sex=" + sex + ", age=" + age + ", qq="
				+ qq + ", email=" + email + ", address=" + address + ", zip=" + zip + ", remark=" + remark + ", rank="
				+ rank + ", amount=" + amount + "]";
	}
}
