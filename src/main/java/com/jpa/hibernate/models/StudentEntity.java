package com.jpa.hibernate.models;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.logging.log4j.core.util.DummyNanoClock;

@Entity
@Table(name = "students")
public class StudentEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "student_name")
	private String name;
	@Column(name = "student_roll")
	private int roll;
	@Column(name = "student_course")
	private String course;
	@Column(name = "student_address")
	private String address;
	@Column(name = "student_age")
	private int age;
	
	/*public StudentEntity() {
	}*/

	public StudentEntity(String name, int rolll, String course, String address, int age) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", roll=" + roll + ", course=" + course + ", address=" + address
				+ ", age=" + age + "]";
	}

}
