package com.xllu0214.programmer.entity;

/**
 * �޹�ʵ��
 * @author XLLU
 *
 */
public class DormitoryManager {
	private int id;
	private String sn;//¥�ܱ��
	private String name;//¥������
	private String password;//¥������
	private String sex;//¥���Ա�
	
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
