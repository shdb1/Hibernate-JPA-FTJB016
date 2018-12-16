package com.jpa.hibernate.models.caching;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table
@NamedQueries({@NamedQuery(name="findStudent",query="from Student")})
@Cache(region="mychache",usage=CacheConcurrencyStrategy.READ_WRITE)
public class Student {

	@Id
	@GeneratedValue
	@Column(name="student_roll")
	int studentRoll;
	@Column(name="student_name")
	String studentName;
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
	@Override
	public String toString() {
		return "Student [studentRoll=" + studentRoll + ", studentName=" + studentName + "]";
	}
	
}
