package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StepSummary {
	
	@Id
	//String Opera_OverAllSmiley;
	String OperationalElements;
	//String Value_OverAllSmiley;
	String ValueCreation;
	//String Accom_OverAllSmiley;
	String OverallAccomplishmentSummaryPerformance;
	
	
	public String getOperationalElements() {
		return OperationalElements;
	}
	public void setOperationalElements(String operationalElements) {
		OperationalElements = operationalElements;
	}
	public String getValueCreation() {
		return ValueCreation;
	}
	public void setValueCreation(String valueCreation) {
		ValueCreation = valueCreation;
	}
	public String getOverallAccomplishmentSummaryPerformance() {
		return OverallAccomplishmentSummaryPerformance;
	}
	public void setOverallAccomplishmentSummaryPerformance(String overallAccomplishmentSummaryPerformance) {
		OverallAccomplishmentSummaryPerformance = overallAccomplishmentSummaryPerformance;
	}
	
	
	

}
