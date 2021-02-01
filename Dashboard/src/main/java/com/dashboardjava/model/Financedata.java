package com.dashboardjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Financedata {
	
	

	String OPRDEFNDESC;
	String SY_SOAP_NUMBER;
	String SY_SOAP_STATUS;
	String SY_VISA_TYPE;
	String EXPIRATION_DT;
	
	

	public String getOPRDEFNDESC() {
		return OPRDEFNDESC;
	}
	public void setOPRDEFNDESC(String oPRDEFNDESC) {
		OPRDEFNDESC = oPRDEFNDESC;
	}
	
	public String getSY_SOAP_NUMBER() {
		return SY_SOAP_NUMBER;
	}
	public void setSY_SOAP_NUMBER(String sY_SOAP_NUMBER) {
		SY_SOAP_NUMBER = sY_SOAP_NUMBER;
	}
	public String getSY_SOAP_STATUS() {
		return SY_SOAP_STATUS;
	}
	public void setSY_SOAP_STATUS(String sY_SOAP_STATUS) {
		SY_SOAP_STATUS = sY_SOAP_STATUS;
	}
	public String getSY_VISA_TYPE() {
		return SY_VISA_TYPE;
	}
	public void setSY_VISA_TYPE(String sY_VISA_TYPE) {
		SY_VISA_TYPE = sY_VISA_TYPE;
	}
	public String getEXPIRATION_DT() {
		return EXPIRATION_DT;
	}
	public void setEXPIRATION_DT(String eXPIRATION_DT) {
		EXPIRATION_DT = eXPIRATION_DT;
	}

	

}
