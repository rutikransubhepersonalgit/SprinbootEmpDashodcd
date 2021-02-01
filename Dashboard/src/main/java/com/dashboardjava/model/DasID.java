package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DasID {
@Id

String das_id;
String userid;
String empid;

public String getEmpid() {
	return empid;
}

public void setEmpid(String empid) {
	this.empid = empid;
}

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
