package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Atoscredentials {

	@Id
	
	String userid;
	String das_id;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDas_id() {
		return das_id;
	}
	public void setDas_id(String das_id) {
		this.das_id = das_id;
	}
	
	
	
	
}
