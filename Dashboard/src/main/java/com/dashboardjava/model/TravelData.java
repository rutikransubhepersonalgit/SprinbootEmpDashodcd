package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TravelData {
	@Id
	int Request_id;
	int Status_Id;
	String Status_Description;
	String pending_with;
	
	
	public int getRequest_id() {
		return Request_id;
	}
	public void setRequest_id(int request_id) {
		Request_id = request_id;
	}
	public int getStatus_Id() {
		return Status_Id;
	}
	public void setStatus_Id(int status_Id) {
		Status_Id = status_Id;
	}
	public String getStatus_Description() {
		return Status_Description;
	}
	public void setStatus_Description(String status_Description) {
		Status_Description = status_Description;
	}
	public String getPending_with() {
		return pending_with;
	}
	public void setPending_with(String pending_with) {
		this.pending_with = pending_with;
	}

}
