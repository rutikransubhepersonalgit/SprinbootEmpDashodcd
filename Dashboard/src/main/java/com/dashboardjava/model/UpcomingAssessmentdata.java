package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class UpcomingAssessmentdata implements Comparable <UpcomingAssessmentdata>  {

	
	String Competency_Type;
	
	String Competency;
	String Assessment_type;
	int No_Off_Attempts_given;
	int Assessment_Score;
	int Kcerticount;
	
	String Proficiency_Level;
	
	int Credit_Points;
	
	public int getCredit_Points() {
		return Credit_Points;
	}

	public void setCredit_Points(int credit_Points) {
		Credit_Points = credit_Points;
	}

	public String getProficiency_Level() {
		return Proficiency_Level;
	}

	public void setProficiency_Level(String proficiency_Level) {
		Proficiency_Level = proficiency_Level;
	}

	public int getKcerticount() {
		return Kcerticount;
	}

	public void setKcerticount(int kcerticount) {
		Kcerticount = kcerticount;
	}

	public int getAssessment_Score() {
		return Assessment_Score;
	}

	public void setAssessment_Score(int assessment_Score) {
		Assessment_Score = assessment_Score;
	}

	public String getCompetency() {
		return Competency;
	}

	public void setCompetency(String competency) {
		Competency = competency;
	}

	public String getAssessment_type() {
		return Assessment_type;
	}

	public void setAssessment_type(String assessment_type) {
		Assessment_type = assessment_type;
	}

	public int getNo_Off_Attempts_given() {
		return No_Off_Attempts_given;
	}

	public void setNo_Off_Attempts_given(int no_Off_Attempts_given) {
		No_Off_Attempts_given = no_Off_Attempts_given;
	}

	public String getCompetency_Type() {
		return Competency_Type;
	}

	public void setCompetency_Type(String competency_Type) {
		Competency_Type = competency_Type;
	}

	@Id
	String FutureSubscription;

	public String getFutureSubscription() {
		return FutureSubscription;
	}

	public void setFutureSubscription(String futureSubscription) {
		FutureSubscription = futureSubscription;
	}

	@Override
	public int compareTo(UpcomingAssessmentdata o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
