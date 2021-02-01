package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Learningbean {

	@Id


	String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	
}
