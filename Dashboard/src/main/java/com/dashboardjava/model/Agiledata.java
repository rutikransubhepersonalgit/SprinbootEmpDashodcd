package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Agiledata {
	
	@Id
	
	String Adaptive;
	String Global;
	String Imaginative;
	String Leadership;
	String Entrepreneurial;
	String Overall_Potentials;
	
	public String getAdaptive() {
		return Adaptive;
	}
	public void setAdaptive(String adaptive) {
		Adaptive = adaptive;
	}
	public String getGlobal() {
		return Global;
	}
	public void setGlobal(String global) {
		Global = global;
	}
	public String getImaginative() {
		return Imaginative;
	}
	public void setImaginative(String imaginative) {
		Imaginative = imaginative;
	}
	public String getLeadership() {
		return Leadership;
	}
	public void setLeadership(String leadership) {
		Leadership = leadership;
	}
	public String getEntrepreneurial() {
		return Entrepreneurial;
	}
	public void setEntrepreneurial(String entrepreneurial) {
		Entrepreneurial = entrepreneurial;
	}
	public String getOverall_Potentials() {
		return Overall_Potentials;
	}
	public void setOverall_Potentials(String overall_Potentials) {
		Overall_Potentials = overall_Potentials;
	}
	
	

}
