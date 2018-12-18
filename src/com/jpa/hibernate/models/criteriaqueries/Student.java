package com.jpa.hibernate.models.criteriaqueries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="student_roll")
	int studentRoll;
	@Column(name="student_name")
	String studentName;
	@Column(name="student_address")
	String studentAddress;
	@Column(name="student_course")
	String studentCourse;
	@Column(name="student_marks")
	int studentMarks;
	@ManyToOne
	@JoinColumn(name="college_student_mapper")
	College college;
	public int getStudentRoll() {
		return studentRoll;
	}
	public void setStudentRoll(int studentRoll) {
		this.studentRoll = studentRoll;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentCourse() {
		return studentCourse;
	}
	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	
	
	@Override
	public String toString() {
		return "Student [studentRoll=" + studentRoll + ", studentName=" + studentName + ", studentAddress="
				+ studentAddress + ", studentCourse=" + studentCourse + ", college=" + college+" , studentMarks "+studentMarks+" ]";
	}
	public int getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}
	

}
