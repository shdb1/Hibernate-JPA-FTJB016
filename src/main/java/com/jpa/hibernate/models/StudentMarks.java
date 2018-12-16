package com.jpa.hibernate.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "studentmarks")
public class StudentMarks {

	@Id
	@GeneratedValue
	@Column(name = "studentmarks_id")
	private int id;
	@Column(name = "studentmarks_roll")
	private int studentRoll;
	@Column(name = "studentmarks_name",length=20,nullable=false)
	private String studentname;
	@Column(name = "studentmarks_course")
	private String studentCourse;
	@Column(name = "studentmarks_date")
	@Temporal(TemporalType.DATE)
	private Date resultDate;
	@Column(name = "studentmarks_marks")
	private double studentMarks;


	@Override
	public String toString() {
		return "StudentMarks [id=" + id + ", studentRoll=" + studentRoll + ", studentname=" + studentname
				+ ", studentCourse=" + studentCourse + ", resultDate=" + resultDate + ", studentMarks=" + studentMarks
				+ "]";
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(int studentRoll) {
		this.studentRoll = studentRoll;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public Date getResultDate() {
		return resultDate;
	}

	public void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}

	public double getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(double studentMarks) {
		this.studentMarks = studentMarks;
	}

	



}
