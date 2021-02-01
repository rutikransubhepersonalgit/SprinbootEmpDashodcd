package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stepcommonbean {
	
	@Id
	String userid;
	int resultset;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getResultset() {
		return resultset;
	}
	public void setResultset(int resultset) {
		this.resultset = resultset;
	}
	

}
