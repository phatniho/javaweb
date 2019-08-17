package com.tedu.pojo;

public class Classes {
	private Integer cid;
	private String caption;

	public Classes() {
		super();
	}

	public Classes(Integer cid, String caption) {
		super();
		this.cid = cid;
		this.caption = caption;
	}

	@Override
	public String toString() {
		return "Class [cid=" + cid + ", caption=" + caption + "]";
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

}
