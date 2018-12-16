package com.jpa.hibernate.models;

public class Student {
	

	private int id;
	private String name;
	private int roll;
	private String course;
	private String address;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	private int age;





public Student() {}
public Student(String name, int rolll, String course, String address , int age) {
	super();
	this.name = name;
	this.roll = roll;
	this.course = course;
	this.address = address;
	this.age = age;
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
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", roll=" + roll + ", course=" + course + ", address=" + address
				+ ", age=" + age + "]";
	}


	
 
	
}
