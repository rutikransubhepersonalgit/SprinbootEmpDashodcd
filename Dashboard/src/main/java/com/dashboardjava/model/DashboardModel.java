package com.dashboardjava.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class DashboardModel  {
@Id
	
   // @Column(name="Name")
	private String Name;
    
	//@Column(name="Empid")
    private String empid;
	
	//@Column(name="Vertical")
    private String Vertical;
            
//    @Column(name="Location")
	private String Location;
	
	private String Reporting_Manager;
	
	private String DOB;
	
	private String DOJ;
	
	private String Address;
	
	private String MObile_No;
	
	private String SYNTEL_EMAIL;
	
	///////////////////////////////////////
	
	
	


	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getVertical() {
		return Vertical;
	}

	public void setVertical(String vertical) {
		Vertical = vertical;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getReporting_Manager() {
		return Reporting_Manager;
	}

	public void setReporting_Manager(String reporting_Manager) {
		Reporting_Manager = reporting_Manager;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getDOJ() {
		return DOJ;
	}

	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMObile_No() {
		return MObile_No;
	}

	public void setMObile_No(String mObile_No) {
		MObile_No = mObile_No;
	}

	public String getSYNTEL_EMAIL() {
		return SYNTEL_EMAIL;
	}

	public void setSYNTEL_EMAIL(String sYNTEL_EMAIL) {
		SYNTEL_EMAIL = sYNTEL_EMAIL;
	}
    
   
}
