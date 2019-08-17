package com.tedu.pojo;

public class Teacher {
	private Integer tid;
	private String tname;
	private String tgender;

	public Teacher() {
		super();
	}

	public Teacher(Integer tid, String tname, String tgender) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tgender = tgender;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tgender=" + tgender + "]";
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTgender() {
		return tgender;
	}

	public void setTgender(String tgender) {
		this.tgender = tgender;
	}

}
