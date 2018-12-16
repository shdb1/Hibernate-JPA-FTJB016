package com.jpa.hibernate.models.associations.onetomany;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="college")
public class College {
	
	@Id
	@GeneratedValue
	@Column(name="college_id")
	int collegeId;
	@Column(name="college_name")
	String collegeName;
	@Column(name="college_address")
	String collegeAddress;
	@Column(name="college_rank")
	String collegeRank;
	@Column(name="college_established")
	@Temporal(TemporalType.DATE)
	Date collegeEstablished;
	@OneToMany(mappedBy="college",targetEntity=Student.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	List<Student> students;
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeAddress() {
		return collegeAddress;
	}
	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}
	public String getCollegeRank() {
		return collegeRank;
	}
	public void setCollegeRank(String collegeRank) {
		this.collegeRank = collegeRank;
	}
	public Date getCollegeEstablished() {
		return collegeEstablished;
	}
	public void setCollegeEstablished(Date collegeEstablished) {
		this.collegeEstablished = collegeEstablished;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeAddress=" + collegeAddress
				+ ", collegeRank=" + collegeRank + ", collegeEstablished=" + collegeEstablished;
	}

}
