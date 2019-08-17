package com.tedu.pojo;

public class Goods {
	private Integer id;
	private String gName;
	private Double gPrice;

	public Goods() {
		super();
	}

	public Goods(Integer id, String gName, Double gPrice) {
		super();
		this.id = id;
		this.gName = gName;
		this.gPrice = gPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public Double getgPrice() {
		return gPrice;
	}

	public void setgPrice(Double gPrice) {
		this.gPrice = gPrice;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", gName=" + gName + ", gPrice=" + gPrice + "]";
	}

}
