package com.tedu.pojo;

/*
 * 实体类(pojo类)
 */
public class User {
	private String name;
	private Integer age;
	private UserInfo info;

	public User() {
		super();
	}

	public User(String name, Integer age, UserInfo info) {
		super();
		this.name = name;
		this.age = age;
		this.info = info;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", info=" + info + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
	}

}
