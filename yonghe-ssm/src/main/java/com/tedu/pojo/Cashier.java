package com.tedu.pojo;

public class Cashier {
	private Integer doorId;
	private Integer cId;
	private String cName;
	private String cPwd;

	public Cashier() {
		super();
	}

	public Cashier(Integer doorId, Integer cId, String cName, String cPwd) {
		super();
		this.doorId = doorId;
		this.cId = cId;
		this.cName = cName;
		this.cPwd = cPwd;
	}

	@Override
	public String toString() {
		return "Cashier [doorId=" + doorId + ", cId=" + cId + ", cName=" + cName + ", cPwd=" + cPwd + "]";
	}

	public Integer getDoorId() {
		return doorId;
	}

	public void setDoorId(Integer doorId) {
		this.doorId = doorId;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcPwd() {
		return cPwd;
	}

	public void setcPwd(String cPwd) {
		this.cPwd = cPwd;
	}

}
