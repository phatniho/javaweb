package com.tedu;

public class Emp {
	private int id;
	private String name;
	private String job;
	private double salary;

	public Emp() {
		super();
	}

	public Emp(int id, String name, String job, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + "]";
	}

}
