package com.tedu.pojo;

public class Score {
	private Integer sid;
	private Integer student_id;
	private Integer couse_id;
	private Double number;

	public Score() {
		super();
	}

	public Score(Integer sid, Integer student_id, Integer couse_id, Double number) {
		super();
		this.sid = sid;
		this.student_id = student_id;
		this.couse_id = couse_id;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Score [sid=" + sid + ", student_id=" + student_id + ", couse_id=" + couse_id + ", number=" + number
				+ "]";
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getCouse_id() {
		return couse_id;
	}

	public void setCouse_id(Integer couse_id) {
		this.couse_id = couse_id;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

}
