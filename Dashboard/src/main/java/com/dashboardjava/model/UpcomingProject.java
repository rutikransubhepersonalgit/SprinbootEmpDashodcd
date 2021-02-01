package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UpcomingProject {
	@Id
	String project_Name;
	String Project_Start_Date;
	int project_Id;
	String Project_End_Date;
	String Reporting_Manager_Id;
	String Reporting_Manager_Name;
	int Duration_In_Months;
	
	public String getProject_Name() {
		return project_Name;
	}
	public void setProject_Name(String project_Name) {
		this.project_Name = project_Name;
	}
	public String getProject_Start_Date() {
		return Project_Start_Date;
	}
	public void setProject_Start_Date(String project_Start_Date) {
		Project_Start_Date = project_Start_Date;
	}
	public int getProject_Id() {
		return project_Id;
	}
	public void setProject_Id(int project_Id) {
		this.project_Id = project_Id;
	}
	public String getProject_End_Date() {
		return Project_End_Date;
	}
	public void setProject_End_Date(String project_End_Date) {
		Project_End_Date = project_End_Date;
	}
	public String getReporting_Manager_Id() {
		return Reporting_Manager_Id;
	}
	public void setReporting_Manager_Id(String reporting_Manager_Id) {
		Reporting_Manager_Id = reporting_Manager_Id;
	}
	public String getReporting_Manager_Name() {
		return Reporting_Manager_Name;
	}
	public void setReporting_Manager_Name(String reporting_Manager_Name) {
		Reporting_Manager_Name = reporting_Manager_Name;
	}
	public int getDuration_In_Months() {
		return Duration_In_Months;
	}
	public void setDuration_In_Months(int duration_In_Months) {
		Duration_In_Months = duration_In_Months;
	}
	

}
