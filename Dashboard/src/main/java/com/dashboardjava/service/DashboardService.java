package com.dashboardjava.service;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.dashboardjava.model.*;

public interface DashboardService {
	ResponseEntity<Object> getEmployeeHeadcount(Commonuser commonuser);
	ResponseEntity<Object> getmyEmployeeHeadcount();
	ResponseEntity<Object> gethrmsdata(Commonuser commonuser);
	ResponseEntity<Object> getleavedata(CommonBean commonbean);
	ResponseEntity<Object> gettraveldata( CommonBean commonbean);
	ResponseEntity<Object> getprevprojectdetails(Commonuser commonuser);
	ResponseEntity<Object> getupcomingprojectdetails (Commonuser commonuser);
	ResponseEntity<Object> getleavestatus(CommonBean commonbean);
	ResponseEntity<Object> getuserroles (Commonuser commonuser);
	ResponseEntity<Object> getaward (awardbean awardbean);
	ResponseEntity<Object> getLearningdetails (Learningbean learningbean);
	
	ResponseEntity<Object> getodcvisadetails (CommonBean commonbean);
	
	ResponseEntity<Object>getstepexesummary(Stepcommonbean stepcommonbean);
	ResponseEntity<Object> getdiscussiondata(Stepcommonbean stepcommonbean);
	ResponseEntity<Object> getagiledata(Stepcommonbean stepcommonbean);
	ResponseEntity<Object> getstrengthdata(Stepcommonbean stepcommonbean);
	
	ResponseEntity<Object> getupcommingassessment(Stepcommonbean stepcommonbean);
	ResponseEntity<Object> getknowlegeassessment (Stepcommonbean stepcommonbean);
	ResponseEntity<Object> getcertifiedknowlege (Stepcommonbean stepcommonbean);
	ResponseEntity<Object> getcertifiedskillcount (Stepcommonbean stepcommonbean);
	ResponseEntity<Object> gettopskills (Stepcommonbean stepcommonbean);
	ResponseEntity<Object> gettopknowledgeareas (Stepcommonbean stepcommonbean);

	ResponseEntity<Object> getreporteelist ();
}
