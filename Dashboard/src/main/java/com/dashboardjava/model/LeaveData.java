package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class LeaveData {
	/*@Id
	String  CB;
	String LAST_ACCURED;
	
	String Eligibilitylimit;
	String LAST_ACCURED_ON;
	String lt_leave_description;
	String Utililizationlimit;
	public String getCB() {
		return CB;
	}
	public void setCB(String cB) {
		CB = cB;
	}
	public String getLAST_ACCURED() {
		return LAST_ACCURED;
	}
	public void setLAST_ACCURED(String lAST_ACCURED) {
		LAST_ACCURED = lAST_ACCURED;
	}
	public String getEligibilitylimit() {
		return Eligibilitylimit;
	}
	public void setEligibilitylimit(String eligibilitylimit) {
		Eligibilitylimit = eligibilitylimit;
	}
	public String getLAST_ACCURED_ON() {
		return LAST_ACCURED_ON;
	}
	public void setLAST_ACCURED_ON(String lAST_ACCURED_ON) {
		LAST_ACCURED_ON = lAST_ACCURED_ON;
	}
	public String getLt_leave_description() {
		return lt_leave_description;
	}
	public void setLt_leave_description(String lt_leave_description) {
		this.lt_leave_description = lt_leave_description;
	}
	public String getUtililizationlimit() {
		return Utililizationlimit;
	}
	public void setUtililizationlimit(String utililizationlimit) {
		Utililizationlimit = utililizationlimit;
	}
	
	
	
	
}*/
	
	
	int CB;
	@Transient
	int LAST_ACCURED;
	@Transient
	int Eligibilitylimit;
	@Transient
	String LAST_ACCURED_ON;
	@Id
	String lt_leave_description;
	@Transient
	int Utililizationlimit;
	@Transient
	int Availed;
	
	public int getCB() {
		return CB;
	}
	public void setCB(int cB) {
		CB = cB;
	}
	public int getLAST_ACCURED() {
		return LAST_ACCURED;
	}
	public void setLAST_ACCURED(int lAST_ACCURED) {
		LAST_ACCURED = lAST_ACCURED;
	}
	public int getEligibilitylimit() {
		return Eligibilitylimit;
	}
	public void setEligibilitylimit(int eligibilitylimit) {
		Eligibilitylimit = eligibilitylimit;
	}
	public String getLAST_ACCURED_ON() {
		return LAST_ACCURED_ON;
	}
	public void setLAST_ACCURED_ON(String lAST_ACCURED_ON) {
		LAST_ACCURED_ON = lAST_ACCURED_ON;
	}
	public String getLt_leave_description() {
		return lt_leave_description;
	}
	public void setLt_leave_description(String lt_leave_description) {
		this.lt_leave_description = lt_leave_description;
	}
	public int getUtililizationlimit() {
		return Utililizationlimit;
	}
	public void setUtililizationlimit(int utililizationlimit) {
		Utililizationlimit = utililizationlimit;
	}
	public int getAvailed() {
		return Availed;
	}
	public void setAvailed(int availed) {
		Availed = availed;
	}
	
}
