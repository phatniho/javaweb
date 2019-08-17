package com.tedu.pojo;

public class Student {
	private Integer sid;
	private String sname;
	private String gender;
	private Integer class_id;

	public Student() {
		super();
	}

	public Student(Integer sid, String sname, String gender, Integer class_id) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.class_id = class_id;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", class_id=" + class_id + "]";
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getClass_id() {
		return class_id;
	}

	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}

}
