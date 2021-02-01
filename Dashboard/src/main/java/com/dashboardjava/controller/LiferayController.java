package com.dashboardjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dashboardjava.service.DashboardService;

public class LiferayController {
	
	@Autowired
	private DashboardService dashboardService;
	
	
	@RequestMapping(value="/getmyEmployeeHeadcount", method = RequestMethod.GET)
	public  ResponseEntity<Object> getmyEmployeeHeadcount(){
	//	System.out.println("Inside getEmpHeadcount Controller:"+commonuser.getEmpid());
		//System.out.println("Inside getEmpHeadcount Controller:"+Empid);
		return dashboardService.getmyEmployeeHeadcount();
		//@RequestBody DashboardModel dashboard
	}
	

}
