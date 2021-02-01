package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Learningdetails {
	@Id
	
	String course_name;
	String completion_date;
	String completion_status;
	int high_score;
	double expected_duration;
	double actual_duration;
	
	
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCompletion_date() {
		return completion_date;
	}
	public void setCompletion_date(String completion_date) {
		this.completion_date = completion_date;
	}
	public String getCompletion_status() {
		return completion_status;
	}
	public void setCompletion_status(String completion_status) {
		this.completion_status = completion_status;
	}
	public int getHigh_score() {
		return high_score;
	}
	public void setHigh_score(int high_score) {
		this.high_score = high_score;
	}
	public double getExpected_duration() {
		return expected_duration;
	}
	public void setExpected_duration(double expected_duration) {
		this.expected_duration = expected_duration;
	}
	public double getActual_duration() {
		return actual_duration;
	}
	public void setActual_duration(double actual_duration) {
		this.actual_duration = actual_duration;
	}

	
	
	
	

}
