package com.dashboardjava.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dashboardjava.dao.DashboardDao;
import com.dashboardjava.model.Award;
import com.dashboardjava.model.CommonBean;
import com.dashboardjava.model.Commonuser;
import com.dashboardjava.model.DashboardModel;
import com.dashboardjava.model.Learningbean;
import com.dashboardjava.model.LeaveData;
import com.dashboardjava.model.Stepcommonbean;
import com.dashboardjava.model.awardbean;
import com.dashboardjava.service.DashboardService;




@Service("dashboardService") 
@Transactional(propagation=Propagation.NOT_SUPPORTED) 

public class DashboardServiceImpl implements DashboardService{
	
	@Autowired
	private DashboardDao dashboarddao;
	
	@Override
	public ResponseEntity<Object> getEmployeeHeadcount(Commonuser commonuser) {
		// TODO Auto-generated method stub
		return dashboarddao.getEmployeeHeadcount(commonuser);
	}
	
	@Override
	public ResponseEntity<Object> getmyEmployeeHeadcount() {
		// TODO Auto-generated method stub
		return dashboarddao.getmyEmployeeHeadcount();
	}
	
	@Override
	public ResponseEntity<Object> gethrmsdata(Commonuser commonuser) {
		// TODO Auto-generated method stub
		return dashboarddao.gethrmsdata(commonuser);
	}
	
	
	@Override
	public ResponseEntity<Object> getleavedata(CommonBean commonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.getleavedata( commonbean);
	}


	@Override
	public ResponseEntity<Object> gettraveldata( CommonBean commonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.gettraveldata(commonbean);
	}

	@Override
	public ResponseEntity<Object> getprevprojectdetails(Commonuser commonuser) {
		// TODO Auto-generated method stub
		return dashboarddao.getprevprojectdetails(commonuser);
	}

	@Override
	public ResponseEntity<Object> getupcomingprojectdetails(Commonuser commonuser) {
		// TODO Auto-generated method stub
		return dashboarddao.getupcomingprojectdetails(commonuser);
	}

	
	 
	@Override
	public ResponseEntity<Object> getleavestatus(CommonBean commonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.getleavestatus(commonbean);
	}

	@Override
	public ResponseEntity<Object> getuserroles(Commonuser commonuser) {
	
		return dashboarddao.getuserroles(commonuser);
	}
	 
	
	@Override
	public ResponseEntity<Object> getreporteelist() {
	
		return dashboarddao.getreporteelist();
	}
	 
	
	@Override
	public ResponseEntity<Object> getaward (awardbean awardbean) {
		
	return dashboarddao.getaward (awardbean);

	}

	@Override
	public ResponseEntity<Object> getstepexesummary(Stepcommonbean stepcommonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.getstepexesummary (stepcommonbean);
	}
	
	@Override
	public ResponseEntity<Object> getLearningdetails (Learningbean learningbean) {
		
	return dashboarddao.getLearningdetails (learningbean);

	}
	
	
	@Override
	public ResponseEntity<Object> getstrengthdata(Stepcommonbean stepcommonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.getstrengthdata (stepcommonbean);
	}
	
	
	

	@Override
	public ResponseEntity<Object> getodcvisadetails(CommonBean commonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.getodcvisadetails(commonbean);
	}
	
	@Override
	public ResponseEntity<Object> getdiscussiondata(Stepcommonbean stepcommonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.getdiscussiondata(stepcommonbean);
	}
	
	@Override
	public ResponseEntity<Object> getagiledata(Stepcommonbean stepcommonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.getagiledata(stepcommonbean);
	}
	
	@Override
	public ResponseEntity<Object> getupcommingassessment(Stepcommonbean stepcommonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.getupcommingassessment(stepcommonbean);
	}
	
	@Override
	public ResponseEntity<Object> getknowlegeassessment(Stepcommonbean stepcommonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.getknowlegeassessment(stepcommonbean);
	}
	
	@Override
	public ResponseEntity<Object> getcertifiedknowlege(Stepcommonbean stepcommonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.getcertifiedknowlege(stepcommonbean);
	}
	
	@Override
	public ResponseEntity<Object> getcertifiedskillcount(Stepcommonbean stepcommonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.getcertifiedskillcount(stepcommonbean);
	}
	
	
	@Override
	public ResponseEntity<Object> gettopskills(Stepcommonbean stepcommonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.gettopskills(stepcommonbean);
	}
	
	@Override
	public ResponseEntity<Object> gettopknowledgeareas(Stepcommonbean stepcommonbean) {
		// TODO Auto-generated method stub
		return dashboarddao.gettopknowledgeareas(stepcommonbean);
	}
	
	
	
	
	
	
	
}
