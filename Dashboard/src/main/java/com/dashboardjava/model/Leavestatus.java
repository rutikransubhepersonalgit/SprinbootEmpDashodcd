package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Leavestatus {
	@Id
	public String Leave;
	public String Status;
	public String Fromdate;
	public String Todate;
	public int Days;
	public int Currentbalance;
	public String Approver;
	public String Approvercomments;
	public String Reason;
	public String Applied_Date;
	
	public String getLeave() {
		return Leave;
	}
	public void setLeave(String leave) {
		Leave = leave;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getFromdate() {
		return Fromdate;
	}
	public void setFromdate(String fromdate) {
		Fromdate = fromdate;
	}
	public String getTodate() {
		return Todate;
	}
	public void setTodate(String todate) {
		Todate = todate;
	}
	public int getDays() {
		return Days;
	}
	public void setDays(int days) {
		Days = days;
	}
	public int getCurrentbalance() {
		return Currentbalance;
	}
	public void setCurrentbalance(int currentbalance) {
		Currentbalance = currentbalance;
	}
	public String getApprover() {
		return Approver;
	}
	public void setApprover(String approver) {
		Approver = approver;
	}
	public String getApprovercomments() {
		return Approvercomments;
	}
	public void setApprovercomment(String approvercomments) {
		Approvercomments = approvercomments;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getApplied_Date() {
		return Applied_Date;
	}
	public void setApplied_Date(String applied_Date) {
		Applied_Date = applied_Date;
	}
	
	
	

}
