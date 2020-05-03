package com.xllu0214.programmer.entity;

import java.sql.Date;

/**
 * 住宿实体
 * @author XLLU
 *
 */
public class Live {
	private int id;
	private int studentId;//学生编号
	private int dormitoryId;//宿舍编号
	private Date liveDate;//入住时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getDormitoryId() {
		return dormitoryId;
	}
	public void setDormitoryId(int dormitoryId) {
		this.dormitoryId = dormitoryId;
	}
	public Date getLiveDate() {
		return liveDate;
	}
	public void setLiveDate(Date liveDate) {
		this.liveDate = liveDate;
	}
}
