package com.dashboardjava.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dashboardjava.config.TokenProvider;
import com.dashboardjava.model.Award;
import com.dashboardjava.model.CommonBean;
import com.dashboardjava.model.Commonuser;
import com.dashboardjava.model.DashboardModel;
import com.dashboardjava.model.Learningbean;
import com.dashboardjava.model.LeaveData;
import com.dashboardjava.model.Stepcommonbean;
import com.dashboardjava.model.awardbean;
import com.dashboardjava.service.DashboardService;
import com.dashboardjava.service.UserService;


@CrossOrigin(origins = "*", maxAge = 400000)
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	private DashboardService dashboardService;
	
	  @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private TokenProvider jwtTokenUtil;

	    @Autowired
	    private UserService userService;

	
	@RequestMapping(value="/getEmployeeHeadcount", method = RequestMethod.POST)
	public  ResponseEntity<Object> getEmployeeHeadcount(@RequestBody Commonuser commonuser){
		System.out.println("Inside getEmpHeadcount Controller:"+commonuser.getEmpid());
				return dashboardService.getEmployeeHeadcount(commonuser);
		
	}
	
	
	@RequestMapping(value="/getmyEmployeeHeadcount", method = RequestMethod.GET)
	public  ResponseEntity<Object> getmyEmployeeHeadcount(){
	
		return dashboardService.getmyEmployeeHeadcount();
		
	}
	
	@RequestMapping(value="/gethrmsdata", method = RequestMethod.POST)
	public  ResponseEntity<Object> gethrmsdata(@RequestBody Commonuser commonuser){
		System.out.println("Inside gethrmsdata Controller:"+commonuser.getEmpid());
		//System.out.println("Inside getEmpHeadcount Controller:"+Empid);
		return dashboardService.gethrmsdata(commonuser);
		//@RequestBody DashboardModel dashboard
	}
	
	
	@RequestMapping(value="/getleavedata", method = RequestMethod.POST)
	public  ResponseEntity<Object> getleavedata(@RequestBody CommonBean commonbean){
		System.out.println("Inside getleavedata Controller"+commonbean.getUserid());
		
		return dashboardService.getleavedata(commonbean);
	}
	
	
	@RequestMapping(value="/getodcvisadetails", method = RequestMethod.POST)
	public  ResponseEntity<Object> getodcvisadetails(@RequestBody CommonBean commonbean){
		System.out.println("Inside getodcvisadetails Controller"+commonbean.getUserid());
		
		return dashboardService.getodcvisadetails(commonbean);
	}
	
	@RequestMapping(value="/getleavestatus", method = RequestMethod.POST)
	public  ResponseEntity<Object> getleavestatus(@RequestBody CommonBean commonbean){
		System.out.println("Inside getleavestatus Controller"+commonbean.getUserid());
		return dashboardService.getleavestatus(commonbean);
	}

	@RequestMapping(value="/gettraveldata", method = RequestMethod.POST)
	public  ResponseEntity<Object> gettraveldata(@RequestBody CommonBean commonbean){
		System.out.println("Inside gettraveldata Controller"+commonbean.getUserid());
		return dashboardService.gettraveldata(commonbean);
	}
	
	@RequestMapping(value="/getprevprojectdetails", method = RequestMethod.POST)
	public  ResponseEntity<Object> getprevprojectdetails(@RequestBody Commonuser commonuser){
		System.out.println("Inside getprevprojectdetails Controller"+commonuser.getUserid());
		return dashboardService.getprevprojectdetails(commonuser);
	}
	
	@RequestMapping(value="/getupcomingprojectdetails", method = RequestMethod.POST)
	public  ResponseEntity<Object> getupcomingprojectdetails(@RequestBody Commonuser commonuser){
		System.out.println("Inside getupcomingprojectdetails Controller"+commonuser.getUserid());
		return dashboardService.getupcomingprojectdetails(commonuser);
	}
	
	@RequestMapping(value="/getuserroles", method = RequestMethod.POST)
	public  ResponseEntity<Object> getuserroles(@RequestBody Commonuser commonuser){
		System.out.println("Inside getprevprojectdetails Controller"+commonuser.getUserid());
		return dashboardService.getuserroles(commonuser);
	}
	
	@RequestMapping(value="/getreporteelist", method = RequestMethod.GET)
	public  ResponseEntity<Object> getreporteelist(){
		System.out.println("Inside getreporteelist Controller");
		return dashboardService.getreporteelist();
	}
	
	@RequestMapping(value="/getaward", method = RequestMethod.POST)
	public  ResponseEntity<Object> getaward(@RequestBody  awardbean awardbean){
		System.out.println("Inside getaward Controller"+awardbean.getUserid());
		return dashboardService.getaward(awardbean);
	}
	
	
	@RequestMapping(value="/getstepexesummary", method = RequestMethod.POST)
	public  ResponseEntity<Object> getstepexesummary(@RequestBody Stepcommonbean stepcommonbean){
		System.out.println("Inside getaward Controller"+stepcommonbean.getUserid());
		return dashboardService.getstepexesummary(stepcommonbean);
	}
	
	@RequestMapping(value="/getdiscussiondata", method = RequestMethod.POST)
	public  ResponseEntity<Object> getdiscussiondata(@RequestBody Stepcommonbean stepcommonbean){
		System.out.println("Inside getaward Controller"+stepcommonbean.getUserid());
		return dashboardService.getdiscussiondata(stepcommonbean);
	}
	
	
	@RequestMapping(value="/getstrengthdata", method = RequestMethod.POST)
	public  ResponseEntity<Object> getstrengthdata(@RequestBody Stepcommonbean stepcommonbean){
		System.out.println("Inside getstrengthdata Controller"+stepcommonbean.getUserid());
		return dashboardService.getstrengthdata(stepcommonbean);
	}
	
	
	
	@RequestMapping(value="/getagiledata", method = RequestMethod.POST)
	public  ResponseEntity<Object> getagiledata(@RequestBody Stepcommonbean stepcommonbean){
		System.out.println("Inside getaward Controller"+stepcommonbean.getUserid());
		return dashboardService.getagiledata(stepcommonbean);
	}
	
	
	@RequestMapping(value="/getLearningdetails", method = RequestMethod.POST)
	public  ResponseEntity<Object> getLearningdetails(@RequestBody Learningbean learningbean){
		System.out.println("Inside getaward Controller"+learningbean.getUserid());
		return dashboardService.getLearningdetails(learningbean);
	}
	
	@RequestMapping(value="/getupcommingassessment", method = RequestMethod.POST)
	public  ResponseEntity<Object> getupcommingassessment(@RequestBody Stepcommonbean stepcommonbean){
		System.out.println("Inside getupcommingassessment Controller"+stepcommonbean.getUserid());
		return dashboardService.getupcommingassessment(stepcommonbean);
	}
	
	@RequestMapping(value="/getknowlegeassessment", method = RequestMethod.POST)
	public  ResponseEntity<Object> getknowlegeassessment(@RequestBody Stepcommonbean stepcommonbean){
		System.out.println("Inside getupcommingassessment Controller"+stepcommonbean.getUserid());
		return dashboardService.getknowlegeassessment(stepcommonbean);
	}
	
//	@RequestMapping(value="/getknowlegeassessmentgiven", method = RequestMethod.POST)
//	public  ResponseEntity<Object> getknowlegeassessmentgiven(@RequestBody Stepcommonbean stepcommonbean){
//		System.out.println("Inside getupcommingassessment Controller"+stepcommonbean.getUserid());
//		return dashboardService.getknowlegeassessmentgiven(stepcommonbean);
//	}
	
	
	@RequestMapping(value="/getcertifiedknowlege", method = RequestMethod.POST)
	public  ResponseEntity<Object> getcertifiedknowlege(@RequestBody Stepcommonbean stepcommonbean){
		System.out.println("Inside getupcommingassessment Controller"+stepcommonbean.getUserid());
		return dashboardService.getcertifiedknowlege(stepcommonbean);
	}
	
	@RequestMapping(value="/getcertifiedskillcount", method = RequestMethod.POST)
	public  ResponseEntity<Object> getcertifiedskillcount(@RequestBody Stepcommonbean stepcommonbean){
		System.out.println("Inside getcertifiedskillcount Controller"+stepcommonbean.getUserid());
		return dashboardService.getcertifiedskillcount(stepcommonbean);
	}
	
	
	
	@RequestMapping(value="/gettopskills", method = RequestMethod.POST)
	public  ResponseEntity<Object> gettopskills(@RequestBody Stepcommonbean stepcommonbean){
		System.out.println("Inside gettopskills Controller"+stepcommonbean.getUserid());
		return dashboardService.gettopskills(stepcommonbean);
	}
	
	@RequestMapping(value="/gettopknowledgeareas", method = RequestMethod.POST)
	public  ResponseEntity<Object> gettopknowledgeareas(@RequestBody Stepcommonbean stepcommonbean){
		System.out.println("Inside gettopknowledgeareas Controller"+stepcommonbean.getUserid());
		return dashboardService.gettopknowledgeareas(stepcommonbean);
	}
	
	
//	@RequestMapping(value="/getsamlresponse", method = RequestMethod.POST)
//	public  ResponseEntity<Object> getsamlresponse(@RequestBody Stepcommonbean stepcommonbean){
//		System.out.println("Inside getsamlresponse Controller"+stepcommonbean.getUserid());
//		return dashboardService.getsamlresponse(stepcommonbean);
//	}
	
	
	/*@RequestMapping(value = "/getindiaemployees/{das_id}", method = RequestMethod.GET)
	public ResponseEntity getindiaemployees (@PathVariable String das_id) {

		//logger.info("Inside getdetails das_id : " + das_id);
System.out.println("inside controller");
		return  liferayService.getindiaemployees(das_id);
	}*/
	
}