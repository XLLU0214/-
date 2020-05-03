package com.xllu0214.programmer.entity;

/**
 * 宿管实体
 * @author XLLU
 *
 */
public class DormitoryManager {
	private int id;
	private String sn;//楼管编号
	private String name;//楼管姓名
	private String password;//楼管密码
	private String sex;//楼管性别
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
