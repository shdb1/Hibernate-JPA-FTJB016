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
@Table(name="printer")
public class Printer {

	@Id
	@GeneratedValue
	@Column(name="printer_id")
	int printerId;
	@Column(name="printer_name")
	String printername;
	@Column(name="printer_location")
	String printerLocation;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="computer_printer_mapping_table",joinColumns= {@JoinColumn(name="printerId")},inverseJoinColumns= {@JoinColumn(name="coumputerId")})
	List<Computer> computers;
	public int getPrinterId() {
		return printerId;
	}
	public void setPrinterId(int printerId) {
		this.printerId = printerId;
	}
	public String getPrintername() {
		return printername;
	}
	public void setPrintername(String printername) {
		this.printername = printername;
	}
	public String getPrinterLocation() {
		return printerLocation;
	}
	public void setPrinterLocation(String printerLocation) {
		this.printerLocation = printerLocation;
	}
	public List<Computer> getComputers() {
		return computers;
	}
	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}
}
