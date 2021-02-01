package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Discussiondata {
	@Id
	String Discussion;
	String Data;
	
	public String getDiscussion() {
		return Discussion;
	}
	public void setDiscussion(String discussion) {
		Discussion = discussion;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}

}
