package com.jpa.hibernate.models.associations.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="computer")
public class Computer {
	
	@Id
	@GeneratedValue
	@Column(name="computer_id")
	int coumputerId;
	@Column(name="computer_name")
	String computerName;
	@Column(name="computer_location")
	String location;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="computer_printer_mapping_table",joinColumns= {@JoinColumn(name="coumputerId")},inverseJoinColumns= {@JoinColumn(name="printerId")})
	List<Printer> printers;
	public int getCoumputerId() {
		return coumputerId;
	}
	public void setCoumputerId(int coumputerId) {
		this.coumputerId = coumputerId;
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Printer> getPrinters() {
		return printers;
	}
	public void setPrinters(List<Printer> printers) {
		this.printers = printers;
	}

}
