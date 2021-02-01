package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commonuser {
	@Id

	String userid;
	int empid;
	String award_type;
	String type;
	
	
	
	
	
	
	
	int ResultSet;
	int Dashboard_Year;
	
	public int getResultSet() {
		return ResultSet;
	}
	public void setResultSet(int resultSet) {
		ResultSet = resultSet;
	}
	public int getDashboard_Year() {
		return Dashboard_Year;
	}
	public void setDashboard_Year(int dashboard_Year) {
		Dashboard_Year = dashboard_Year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
public String getAward_type() {
		return award_type;
	}
	public void setAward_type(String award_type) {
		this.award_type = award_type;
	}
public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}


}
