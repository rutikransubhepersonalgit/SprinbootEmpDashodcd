package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Award {
	
	String award_type;
	String type;
	String Value;
	String name;
	String	VERTICAL_DESCR;
	String CITATION;
	String NOMINATEDPERSON;
	String Award_Year;
	int Quarter_ID;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	
	public String getAward_Year() {
		return Award_Year;
	}
	public void setAward_Year(String award_Year) {
		Award_Year = award_Year;
	}
	public int getQuarter_ID() {
		return Quarter_ID;
	}
	public void setQuarter_ID(int quarter_ID) {
		Quarter_ID = quarter_ID;
	}
	public String getAward_type() {
	return award_type;
	}
public void setAward_type(String award_type) {
		this.award_type = award_type;
	}
	public String getCITATION() {
		return CITATION;
	}
	/*public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVERTICAL_DESCR() {
		return VERTICAL_DESCR;
	}
	public void setVERTICAL_DESCR(String vERTICAL_DESCR) {
		VERTICAL_DESCR = vERTICAL_DESCR;
	}
	public String AwardData() {
		return CITATION;
	}
	public void setCITATION(String cITATION) {
		CITATION = cITATION;
	}
	public String getNOMINATEDPERSON() {
		return NOMINATEDPERSON;
	}
	public void setNOMINATEDPERSON(String nOMINATEDPERSON) {
		NOMINATEDPERSON = nOMINATEDPERSON;
	}
	

}
