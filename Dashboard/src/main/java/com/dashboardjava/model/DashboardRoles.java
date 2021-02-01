package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DashboardRoles {
	@Id
	
	
//	int role_id;
//	String role;
//	
	String Name;
	String userid;
	int empid;
	String DOJ;
	String delivery_director;
	String Grade;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public String getDelivery_director() {
		return delivery_director;
	}
	public void setDelivery_director(String delivery_director) {
		this.delivery_director = delivery_director;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
//	public int getRole_id() {
//		return role_id;
//	}
//	public void setRole_id(int role_id) {
//		this.role_id = role_id;
//	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
	


}
