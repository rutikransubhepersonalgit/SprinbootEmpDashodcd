package com.dashboardjava.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dashboardjava.model.Agiledata;
import com.dashboardjava.model.Award;
import com.dashboardjava.model.CommonBean;
import com.dashboardjava.model.Commonuser;
import com.dashboardjava.model.DashboardModel;
import com.dashboardjava.model.DashboardRoles;
import com.dashboardjava.model.Discussiondata;
import com.dashboardjava.model.Financedata;
import com.dashboardjava.model.Hrmsdata;
import com.dashboardjava.model.Learningbean;
import com.dashboardjava.model.Learningdetails;
import com.dashboardjava.model.LeaveData;
import com.dashboardjava.model.Leavestatus;
import com.dashboardjava.model.StepSummary;
import com.dashboardjava.model.Stepcommonbean;
import com.dashboardjava.model.Strengthdata;
import com.dashboardjava.model.TravelData;
import com.dashboardjava.model.UpcomingAssessmentdata;
import com.dashboardjava.model.UpcomingProject;
import com.dashboardjava.model.awardbean;
import com.dashboardjava.model.preprojectdata;

import io.jsonwebtoken.lang.Collections;



@Repository("dashboardDao")
@Transactional
public class DashboardDaoImpl implements DashboardDao{
	@Autowired
	@Qualifier("hrmsTemplate")
	JdbcTemplate jdbcTemplateHrms; 
	
@Autowired
	@Qualifier("x0Template")
	JdbcTemplate jdbcTemplatex0; 


@Autowired
@Qualifier("spring.datasource")
JdbcTemplate jdbcTemplatesyntranet; 

@Autowired
@Qualifier("financeTemplate")
JdbcTemplate jdbcTemplatefinance; 



/*@Autowired
@Qualifier("firstDataSource")
JdbcTemplate jdbcTemplatesyntranet;*/
	
/*int employeeID=0;*/

	static final Logger logger = LoggerFactory.getLogger(DashboardDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public ResponseEntity<Object> getEmployeeHeadcount(Commonuser commonuser) {
		Session session = entityManager.unwrap(Session.class);		
		//int employeeID=0;
		try{
			
			int employeeID=getempid(commonuser.getUserid());
						
			Query empTemplatedoc = session.createNativeQuery("exec [synprod].[EmployeeDashboardPersonalInfo] ?").setParameter(1,employeeID).addEntity(DashboardModel.class);					
					
			List empTemplatedocList=empTemplatedoc.list();	
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(empTemplatedocList);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}
		
	}

	
	@Override
	public ResponseEntity<Object> getmyEmployeeHeadcount() {
		Session session = entityManager.unwrap(Session.class);		
		//int employeeID=0;
		try{
			
			int employeeID=5037151;
						
			Query empTemplatedoc = session.createNativeQuery("exec [synprod].[EmployeeDashboardPersonalInfo] ?").setParameter(1,employeeID).addEntity(DashboardModel.class);				
					
			List empTemplatedocList=empTemplatedoc.list();	
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(empTemplatedocList);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}
		
	}

	@Override
	public ResponseEntity<Object> gethrmsdata(Commonuser commonuser) {
		Session session = entityManager.unwrap(Session.class);		
		int employeeID=0;
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	//rmsdata hrmsdata =null;
	
		List<Hrmsdata> hrmsData =null;
		hrmsData = new ArrayList<Hrmsdata>();
	//	HashMap<String, String> resultData=new HashMap();
		try{
			hrmsData = new ArrayList<Hrmsdata>();
			System.out.println(hrmsData);
			System.out.println(jdbcTemplateHrms.getDataSource().getConnection());
			employeeID=getempid(commonuser.getUserid());
			con = jdbcTemplateHrms.getDataSource().getConnection();
			 pstmt = con.prepareStatement("SELECT [TOTAL EXP] AS TOTALEXP, [PREVIOUS EXP] AS PREVIOUSEXP,BLOOD_TYPE,DEPENDENT_BENEF,EDUCATIONAL_QUALIFICATION,NAME FROM [dbo].[PS_SY_EMPL_DASHBRD]  where EMPLID=?");
			pstmt.setInt(1, employeeID );
			rs = pstmt.executeQuery();
			while(rs.next()) {
			
				Hrmsdata hrmsdata  = new Hrmsdata();
				hrmsdata.setNAME(rs.getString("NAME"));
				hrmsdata.setDEPENDENT_BENEF(rs.getString("DEPENDENT_BENEF"));
				hrmsdata.setEDUCATIONAL_QUALIFICATION(rs.getString("EDUCATIONAL_QUALIFICATION"));
				hrmsdata.setTOTALEXP(rs.getString("TOTALEXP"));
				hrmsdata.setBLOOD_TYPE(rs.getString("BLOOD_TYPE"));
				hrmsdata.setPREVIOUSEXP(rs.getString("PREVIOUSEXP"));
				
				hrmsData.add(hrmsdata);
			}
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			/*Query empTemplatedoc = session
					.createNativeQuery("select * from [dbo].[PS_SY_EMPL_DASHBRD] where EMPLID=?").setParameter(1,employeeID).addEntity(Hrmsdata.class);	;				
						;				*/
			//List empTemplatedocList=empTemplatedoc.list();	
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(hrmsData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	@Override
	public ResponseEntity<Object> getodcvisadetails(CommonBean commonbean) {
		Session session = entityManager.unwrap(Session.class);		
		int employeeID=0;
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Financedata financedata =  null;
		List<Financedata> financeData =null;
		
		try{
			financeData = new ArrayList<Financedata>();
			System.out.println(financeData);
			System.out.println(jdbcTemplatefinance.getDataSource().getConnection());
			employeeID=getempid(commonbean.getUserid());
			con = jdbcTemplatefinance.getDataSource().getConnection();
			 pstmt = con.prepareStatement("{call EmpDashboard_ODC_Visa_Details (?)}");
			pstmt.setInt(1, employeeID );
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				financedata  = new Financedata();
				financedata.setEXPIRATION_DT(rs.getString("EXPIRATION_DT"));
				financedata.setOPRDEFNDESC(rs.getString("OPRDEFNDESC"));
				financedata.setSY_SOAP_NUMBER(rs.getString("SY_SOAP_NUMBER"));
			financedata.setSY_SOAP_STATUS(rs.getString("SY_SOAP_STATUS"));
			financedata.setSY_VISA_TYPE(rs.getString("SY_VISA_TYPE"));
				
				financeData.add(financedata);
			}
			
			
				
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(financeData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
/*	@Override
	public ResponseEntity<Object> getupcommingassessment(Stepcommonbean stepcommonbean) {
		Session session = entityManager.unwrap(Session.class);
		

		try{
			List<UpcomingAssessmentdata> UpcomingAssessmentdataList=null;
			HashMap<String, String> resultData=new HashMap();

			System.out.println("Empid in getleavedata daoimpl "+stepcommonbean.getUserid());
			int employeeID=getempid(stepcommonbean.getUserid());
			//int employeeID=getempid(commonuser.getUserid());
			Query empTemplatedoc = session.createNativeQuery("select * from [VW_XO_Liferay_Dashboard where Emp_id=?").setParameter(1,employeeID).addEntity(UpcomingAssessmentdata.class);				
			empTemplatedoc.executeUpdate();
			System.out.println("Query"+empTemplatedoc);
			UpcomingAssessmentdataList=empTemplatedoc.getResultList();
			System.out.println("empTemplatedocList length"+UpcomingAssessmentdataList.size());

			for(UpcomingAssessmentdata UpcomingAssessmentdata:UpcomingAssessmentdataList) {			
				String Competency_Type="";
				Competency_Type=	"";
				System.out.println("LeaveData.getFutureSubscription(): "+UpcomingAssessmentdata.getFutureSubscription());
//				System.out.println("LeaveData.getCB(): "+leaveData.getCB());
				switch (Competency_Type)
				{
				case "Skill 1":
					resultData.put(Competency_Type, UpcomingAssessmentdata.getFutureSubscription());
					break;
				case "Skill 2":
					resultData.put(Competency_Type,  UpcomingAssessmentdata.getFutureSubscription());
					break;
				case "Knowledge 1":
					resultData.put(Competency_Type,  UpcomingAssessmentdata.getFutureSubscription());
					break;
				case "Knowledge 2":
					resultData.put(Competency_Type,  UpcomingAssessmentdata.getFutureSubscription());
					break;
				
				}
				
			}


			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(resultData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}

	}*/
	
	
	@Override
	public ResponseEntity<Object> getupcommingassessment(Stepcommonbean stepcommonbean) {
		Session session = entityManager.unwrap(Session.class);		
		int employeeID=0;
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UpcomingAssessmentdata upcomingassessmentdata =  null;
		List<UpcomingAssessmentdata> upcomingassessmentData =null;
		HashMap<String, String> resultData=new HashMap();
		
		try{
			upcomingassessmentData = new ArrayList<UpcomingAssessmentdata>();
			System.out.println(upcomingassessmentData);
			System.out.println(jdbcTemplatex0.getDataSource().getConnection());
			employeeID=getempid(stepcommonbean.getUserid());
			System.out.println("empid"+employeeID);
			con = jdbcTemplatex0.getDataSource().getConnection();
			 pstmt = con.prepareStatement("select * from [synprod].[VW_XO_Liferay_Dashboard] where Emp_id=? order by Assessment_Score Desc");
			pstmt.setInt(1, employeeID );
			
			//upcomingassessmentData=pstmt.getResultList();
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				upcomingassessmentdata =new UpcomingAssessmentdata();
				//stepsummary.setAccom_OverAllSmiley(rs.getString("accom_OverAllSmiley"));
				
				upcomingassessmentdata.setFutureSubscription(rs.getString("Future_subscription"));
				upcomingassessmentdata.setCompetency_Type(rs.getString("Competency_Type"));
				upcomingassessmentdata.setCompetency(rs.getString("Competency"));
				upcomingassessmentdata.setNo_Off_Attempts_given(rs.getInt("No_Off_Attempts_given"));
				upcomingassessmentdata.setAssessment_type(rs.getString("Assessment_type"));
				upcomingassessmentdata.setAssessment_Score(rs.getInt("assessment_Score"));
				
							
				upcomingassessmentData.add(upcomingassessmentdata);
				
				
			}
			
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(upcomingassessmentData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	@Override
	public ResponseEntity<Object> getcertifiedknowlege(Stepcommonbean stepcommonbean) {
		Session session = entityManager.unwrap(Session.class);		
		int employeeID=0;
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UpcomingAssessmentdata upcomingassessmentdata =  null;
		List<UpcomingAssessmentdata> upcomingassessmentData =null;
		HashMap<String, String> resultData=new HashMap();
		
		try{
			upcomingassessmentData = new ArrayList<UpcomingAssessmentdata>();
			System.out.println(upcomingassessmentData);
			System.out.println(jdbcTemplatex0.getDataSource().getConnection());
			employeeID=getempid(stepcommonbean.getUserid());
			System.out.println("empid"+employeeID);
			con = jdbcTemplatex0.getDataSource().getConnection();
			 pstmt = con.prepareStatement("select count(Assessment_Status)as Kcerticount from [synprod].[VW_XO_Liferay_Dashboard] where Emp_id=? and Assessment_Status='Certified' and Assessment_type='Knowledge'");
			pstmt.setInt(1, employeeID );
			
			//upcomingassessmentData=pstmt.getResultList();
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				upcomingassessmentdata =new UpcomingAssessmentdata();
				//stepsummary.setAccom_OverAllSmiley(rs.getString("accom_OverAllSmiley"));
				
				upcomingassessmentdata.setKcerticount(rs.getInt("kcerticount"));
				
				/*upcomingassessmentdata.setFutureSubscription(rs.getString("Future_subscription"));
				upcomingassessmentdata.setCompetency_Type(rs.getString("Competency_Type"));
				upcomingassessmentdata.setCompetency(rs.getString("Competency"));
				upcomingassessmentdata.setNo_Off_Attempts_given(rs.getInt("No_Off_Attempts_given"));
				upcomingassessmentdata.setAssessment_type(rs.getString("Assessment_type"));
				upcomingassessmentdata.setAssessment_Score(rs.getInt("assessment_Score"));*/
				
							
				upcomingassessmentData.add(upcomingassessmentdata);
				
				
			}
			
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(upcomingassessmentData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
       
	@Override
	public ResponseEntity<Object> getcertifiedskillcount(Stepcommonbean stepcommonbean) {
		Session session = entityManager.unwrap(Session.class);		
		int employeeID=0;
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UpcomingAssessmentdata upcomingassessmentdata =  null;
		List<UpcomingAssessmentdata> upcomingassessmentData =null;
		HashMap<String, String> resultData=new HashMap();
		
		try{
			upcomingassessmentData = new ArrayList<UpcomingAssessmentdata>();
			System.out.println(upcomingassessmentData);
			System.out.println(jdbcTemplatex0.getDataSource().getConnection());
			employeeID=getempid(stepcommonbean.getUserid());
			System.out.println("empid"+employeeID);
			con = jdbcTemplatex0.getDataSource().getConnection();
			 pstmt = con.prepareStatement("select count(Assessment_Status) as Kcerticount from [synprod].[VW_XO_Liferay_Dashboard] where Emp_id=? and Assessment_Status='Certified' and Assessment_type='Skill'");
			pstmt.setInt(1, employeeID );
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				upcomingassessmentdata =new UpcomingAssessmentdata();
				
				
				upcomingassessmentdata.setKcerticount(rs.getInt("kcerticount"));
				
				
							
				upcomingassessmentData.add(upcomingassessmentdata);
				
				
			}
			
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(upcomingassessmentData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	@Override
	public ResponseEntity<Object> gettopskills(Stepcommonbean stepcommonbean) {
		Session session = entityManager.unwrap(Session.class);		
		int employeeID=0;
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UpcomingAssessmentdata upcomingassessmentdata =  null;
		List<UpcomingAssessmentdata> upcomingassessmentData =null;
		HashMap<String, String> resultData=new HashMap();
		
		try{
			upcomingassessmentData = new ArrayList<UpcomingAssessmentdata>();
			System.out.println(upcomingassessmentData);
			System.out.println(jdbcTemplatex0.getDataSource().getConnection());
			employeeID=getempid(stepcommonbean.getUserid());
			System.out.println("empid"+employeeID);
			con = jdbcTemplatex0.getDataSource().getConnection();
			 pstmt = con.prepareStatement("select Competency,Proficiency_Level,Assessment_Score,Credit_Points from [synprod].[VW_XO_Liferay_Dashboard] where Emp_id=? and Assessment_type='Skill' order by Assessment_Score,Credit_Points Desc");
			pstmt.setInt(1, employeeID );
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				upcomingassessmentdata =new UpcomingAssessmentdata();
				
				
				upcomingassessmentdata.setCompetency(rs.getString("competency"));
				upcomingassessmentdata.setProficiency_Level(rs.getString("proficiency_Level"));
				upcomingassessmentdata.setAssessment_Score(rs.getInt("assessment_Score"));
				upcomingassessmentdata.setCredit_Points(rs.getInt("credit_Points"));
				
							
				upcomingassessmentData.add(upcomingassessmentdata);
				
				
			}
			
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(upcomingassessmentData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	@Override
	public ResponseEntity<Object> gettopknowledgeareas(Stepcommonbean stepcommonbean) {
		Session session = entityManager.unwrap(Session.class);		
		int employeeID=0;
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UpcomingAssessmentdata upcomingassessmentdata =  null;
		List<UpcomingAssessmentdata> upcomingassessmentData =null;
		HashMap<String, String> resultData=new HashMap();
		
		try{
			upcomingassessmentData = new ArrayList<UpcomingAssessmentdata>();
			System.out.println(upcomingassessmentData);
			System.out.println(jdbcTemplatex0.getDataSource().getConnection());
			employeeID=getempid(stepcommonbean.getUserid());
			System.out.println("empid"+employeeID);
			con = jdbcTemplatex0.getDataSource().getConnection();
			 pstmt = con.prepareStatement("select Competency,Proficiency_Level,Assessment_Score,Credit_Points from [synprod].[VW_XO_Liferay_Dashboard] where Emp_id=? and Assessment_type='Knowledge' order by Assessment_Score,Credit_Points Desc");
			pstmt.setInt(1, employeeID );
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				upcomingassessmentdata =new UpcomingAssessmentdata();
				
				
				upcomingassessmentdata.setCompetency(rs.getString("competency"));
				upcomingassessmentdata.setProficiency_Level(rs.getString("proficiency_Level"));
				upcomingassessmentdata.setAssessment_Score(rs.getInt("assessment_Score"));
				upcomingassessmentdata.setCredit_Points(rs.getInt("credit_Points"));
				
							
				upcomingassessmentData.add(upcomingassessmentdata);
				
				
			}
			
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(upcomingassessmentData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	@Override
	public ResponseEntity<Object> getknowlegeassessment(Stepcommonbean stepcommonbean) {
		Session session = entityManager.unwrap(Session.class);		
		int employeeID=0;
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		UpcomingAssessmentdata upcomingassessmentdata =  null;
		List<UpcomingAssessmentdata> upcomingassessmentData =null;
		HashMap<String, String> resultData=new HashMap();
		
		try{
			upcomingassessmentData = new ArrayList<UpcomingAssessmentdata>();
			System.out.println(upcomingassessmentData);
			System.out.println(jdbcTemplatex0.getDataSource().getConnection());
			employeeID=getempid(stepcommonbean.getUserid());
			System.out.println("empid"+employeeID);
			con = jdbcTemplatex0.getDataSource().getConnection();
			 pstmt = con.prepareStatement("select * from [synprod].[VW_XO_Liferay_Dashboard] where Emp_id=?  order by Assessment_Score Desc");
			pstmt.setInt(1, employeeID );
			
			//upcomingassessmentData=pstmt.getResultList();
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				upcomingassessmentdata =new UpcomingAssessmentdata();
				//stepsummary.setAccom_OverAllSmiley(rs.getString("accom_OverAllSmiley"));
				
				upcomingassessmentdata.setFutureSubscription(rs.getString("Future_subscription"));
				upcomingassessmentdata.setCompetency_Type(rs.getString("Competency_Type"));
							
				upcomingassessmentData.add(upcomingassessmentdata);
				
			}
			
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(upcomingassessmentData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	private int getempid(String userid) {
		Session session = entityManager.unwrap(Session.class);
		List<CommonBean> empidList=null;
		int employeeID=0;
		
		try{
			
		
			Query empTemplatedoc1 = session.createNativeQuery("select userid,empid from [synprod].[EmpInformationWithContractEmployees] where userid=?").setParameter(1,userid).addEntity(CommonBean.class);
			
			empidList=empTemplatedoc1.list();
		
			for(CommonBean e:empidList) {				
				employeeID=e.getEmpid();
			}
			
			return employeeID;
							
		}
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<Object> getleavedata(CommonBean commonbean) {
		Session session = entityManager.unwrap(Session.class);
		try{
			
			HashMap<String, Double> resultData=new HashMap();

			System.out.println("Empid in getleavedata daoimpl "+commonbean.getUserid());

	//		Query empTemplatedoc = session.createNativeQuery("exec [synprod].[SP_TAAS_LeaveView_employee] ?").setParameter(1,commonbean.getUserid()).addEntity(LeaveData.class);
			
			StoredProcedureQuery empTemplatedoc = session.createStoredProcedureQuery("SP_TAAS_LeaveView_employee", LeaveData.class);
			empTemplatedoc .registerStoredProcedureParameter(1, String.class,ParameterMode.IN).setParameter(1, commonbean.getUserid());
//			 StoredProcedureQuery department = s.createStoredProcedureQuery("findEmployeeByDepartment", Employee.class);
//		        department.registerStoredProcedureParameter("emp_department", String.class, ParameterMode.IN);
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			LeaveData leavedata =  null;
			List<LeaveData> leaveData =null;
			leaveData = new ArrayList<LeaveData>();
			con = jdbcTemplatesyntranet.getDataSource().getConnection();
			pstmt = con.prepareStatement("SELECT 2 AS lt_leave_description,CB FROM [synprod].[SP_TAAS_LeaveView_employee] where userid=?");
			pstmt.setString(1,"NK5037151");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LeaveData leavedata  = new LeaveData();
				leavedata.getCB();
				leavedata.getLt_leave_description();
				leaveData.add(leavedata);
			}
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(leaveData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			
			while(rs.next()) {
				leavedata  = new Leavedata();
				hrmsdata.setNAME(rs.getString("NAME"));
				hrmsdata.setDEPENDENT_BENEF(rs.getString("DEPENDENT_BENEF"));
				hrmsdata.setEDUCATIONAL_QUALIFICATION(rs.getString("EDUCATIONAL_QUALIFICATION"));
				hrmsdata.setTOTALEXP(rs.getString("EEXP"));
				hrmsData.add(hrmsdata);
			}
			List<LeaveData> empTemplatedocList=empTemplatedoc.getResultList();
			System.out.println(empTemplatedocList.size());
			System.out.println(empTemplatedocList.toArray().toString());*/
			/*for() {
				LeaveData LeaveData= new LeaveData();
				LeaveData = rs.get(i);
				String leave_description=LeaveData.getLt_leave_description();					

				switch (leave_description)
				{
				case "CEL":
					resultData.put(leave_description, Double.parseDouble(LeaveData.getCB().toString()));
					break;
				case "Coff":
					resultData.put(leave_description,  Double.parseDouble(LeaveData.getCB().toString()));
					break;
				case "ML":
					resultData.put(leave_description,  Double.parseDouble(LeaveData.getCB().toString()));
					break;
				case "LWP":
					resultData.put(leave_description, Double.parseDouble(LeaveData.getCB().toString()));
					break;
				case "PL":
					resultData.put(leave_description,  Double.parseDouble(LeaveData.getCB().toString()));
					break;
				}

			}


			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(resultData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}

	
	}*/

	
	@Override
	public ResponseEntity<Object> getleavedata(CommonBean commonbean) {
		Session session = entityManager.unwrap(Session.class);
		try{
			List<LeaveData> empTemplatedocList=null;
			HashMap<String, Double> resultData=new HashMap();

			System.out.println("Empid in getleavedata daoimpl "+commonbean.getUserid());

			Query empTemplatedoc = session.createNativeQuery("exec [synprod].[SP_TAAS_LeaveView_employee] ?").setParameter(1,commonbean.getUserid()).addEntity(LeaveData.class);				
			System.out.println("Query"+empTemplatedoc);
			empTemplatedocList=empTemplatedoc.getResultList();
			System.out.println("empTemplatedocList length"+empTemplatedocList.size());

			for(LeaveData leaveData:empTemplatedocList) {			
				String leave_description="";
				leave_description=leaveData.getLt_leave_description();	
				System.out.println("LeaveData.getLt_leave_description(): "+leaveData.getLt_leave_description());
//				System.out.println("LeaveData.getCB(): "+leaveData.getCB());
				switch (leave_description)
				{
				case "CEL":
					resultData.put(leave_description, (double) leaveData.getCB());
					break;
				case "Coff":
					resultData.put(leave_description, (double) leaveData.getCB());
					break;
				case "ML":
					resultData.put(leave_description, (double) leaveData.getCB());
					break;
				case "LWP":
					resultData.put(leave_description, (double) leaveData.getCB());
					break;
				case "PL":
					resultData.put(leave_description, (double) leaveData.getCB());
					break;
				}
				
			}


			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(resultData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}

	}
	
//	@Override
//	public ResponseEntity<Object> gettraveldata(Commonuser commonuser) {
//		Session session = entityManager.unwrap(Session.class);
//		try{
//			
//			//session.beginTransaction();
//			System.out.println("Empid in getEmployeeHeadcount daoimpl "+commonuser.getUserid());
//			
//			Query empTemplatedoc = session
//					.createNativeQuery("exec [synprod].[Trav_User_Status_Master] ?").setParameter(1, commonuser.getUserid()).addEntity(TravelData.class);				
//					
//			List empTemplatedocList=empTemplatedoc.list();
//		
//		
//			  
//			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(empTemplatedocList);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
//		}
//		
//	}
	
	
	@Override
	public ResponseEntity<Object> gettraveldata(CommonBean commonbean) {
		
		
		Session session = entityManager.unwrap(Session.class);		
		//String employeeID=null;
		String type="";
		Connection con = null;
		PreparedStatement pstmt=null;
		//prepareCall pstmt=null;
		ResultSet rs=null;
		TravelData travelstatus =  new TravelData();
		ArrayList<TravelData> travelData =  null;
		List<TravelData> traveldataData =null;
		try{
			travelData = new ArrayList<TravelData>();
			System.out.println(travelData);
			System.out.println(jdbcTemplatesyntranet.getDataSource().getConnection());
			
			con = jdbcTemplatesyntranet.getDataSource().getConnection();
			 pstmt = con.prepareStatement("{call [synprod].[Trav_User_Status_Master](?)} ");
			pstmt.setString(1, commonbean.getUserid() );
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				
				travelstatus = new TravelData();
				travelstatus.setRequest_id(rs.getInt("request_id"));
				travelstatus.setStatus_Description(rs.getString("status_Description"));
				travelstatus.setPending_with(rs.getString("pending_with"));
									
				travelData.add(travelstatus);
			}
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(travelData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	@Override
	public ResponseEntity<Object> getprevprojectdetails(Commonuser commonuser) {
		Session session = entityManager.unwrap(Session.class);
		try{
			
			//session.beginTransaction();
			System.out.println("Empid in getprevprojectdetails daoimpl "+commonuser.getUserid());
			
			Query empTemplatedoc = session
					.createNativeQuery("exec [synprod].[Sp_Get_Project_History] ?").setParameter(1, commonuser.getUserid()).addEntity(preprojectdata.class);				
					
			List empTemplatedocList=empTemplatedoc.list();
		
		
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(empTemplatedocList);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}
		
	}
	
	
	
	@Override
	public ResponseEntity<Object> getupcomingprojectdetails(Commonuser commonuser) {
		Session session = entityManager.unwrap(Session.class);		
		//String employeeID=null;
		String type="";
		Connection con = null;
		PreparedStatement pstmt=null;
		//prepareCall pstmt=null;
		ResultSet rs=null;
		UpcomingProject upcomingproject =  new UpcomingProject();
		ArrayList<UpcomingProject> upcomingprojectData =  null;
		List<UpcomingProject> upcomingprojectDataData =null;
		try{
			upcomingprojectData = new ArrayList<UpcomingProject>();
			System.out.println(upcomingprojectData);
			System.out.println(jdbcTemplatesyntranet.getDataSource().getConnection());
			
			con = jdbcTemplatesyntranet.getDataSource().getConnection();
			 pstmt = con.prepareStatement("{call [synprod].[SP_EmployeeDashboardUpcomingProjectDetails](?)} ");
			pstmt.setString(1, commonuser.getUserid() );
			rs = pstmt.executeQuery();
			while(rs.next()) {
				upcomingproject  = new UpcomingProject();
				upcomingproject.setProject_Name(rs.getString("project_Name"));
				upcomingproject.setDuration_In_Months(rs.getInt("duration_In_Months"));
				upcomingproject.setProject_End_Date(rs.getString("project_End_Date"));
				upcomingproject.setProject_Id(rs.getInt("project_Id"));
				upcomingproject.setProject_Start_Date(rs.getString("project_Start_Date"));
				upcomingproject.setReporting_Manager_Id(rs.getString("reporting_Manager_Id"));
				upcomingproject.setReporting_Manager_Name(rs.getString("reporting_Manager_Name"));
				
				upcomingprojectData.add(upcomingproject);
			}
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(upcomingprojectData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
//	@Override
//	public ResponseEntity<Object> getleavestatus(CommonBean commonbean) {
//		Session session = entityManager.unwrap(Session.class);
//		try{
//			
//			//session.beginTransaction();
//			System.out.println("Empid in getleavestatus daoimpl "+commonbean.getUserid());
//			
//			Query empTemplatedoc = session
//					.createNativeQuery("exec [synprod].[Sp_TaAS_Get_Passbook_details] ?").setParameter(1, commonbean.getUserid()).addEntity(Leavestatus.class);				
//					
//			List empTemplatedocList=empTemplatedoc.list();
//			
//		
//		
//			  
//			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(empTemplatedocList);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
//		}
//		
//	}
//	
	
	@Override
	public ResponseEntity<Object> getleavestatus(CommonBean commonbean) {
		
		Session session = entityManager.unwrap(Session.class);		
		//String employeeID=null;
		String type="";
		Connection con = null;
		PreparedStatement pstmt=null;
		//prepareCall pstmt=null;
		ResultSet rs=null;
		Leavestatus leavestatus =  new Leavestatus();
		ArrayList<Leavestatus> leavestatusData =  null;
		List<Leavestatus> leavestatusdataData =null;
		try{
			leavestatusData = new ArrayList<Leavestatus>();
			System.out.println(leavestatusData);
			System.out.println(jdbcTemplatesyntranet.getDataSource().getConnection());
			
			con = jdbcTemplatesyntranet.getDataSource().getConnection();
			 pstmt = con.prepareStatement("{call [synprod].[Sp_TaAS_Get_Passbook_details](?)} ");
			pstmt.setString(1, commonbean.getUserid() );
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				leavestatus  = new Leavestatus();
				leavestatus.setLeave(rs.getString("leave"));
				leavestatus.setFromdate(rs.getString("fromdate"));
				leavestatus.setTodate(rs.getString("todate"));
				leavestatus.setStatus(rs.getString("status"));
				leavestatus.setApprover(rs.getString("approver"));
				
						
				leavestatusData.add(leavestatus);
			}
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(leavestatusData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public ResponseEntity<Object> getuserroles(Commonuser commonuser) {
		Session session = entityManager.unwrap(Session.class);
		try{
			List<DashboardRoles> empTemplatedocList1=null;
			HashMap<String,Integer> resultData=new HashMap();
			//session.beginTransaction();
			System.out.println("Empid in getuserroles daoimpl "+commonuser.getUserid());
			
			Query empTemplatedoc = session.createNativeQuery("select * from synprod.getempinformation where  reporting_manager_id = ?").setParameter(1, commonuser.getUserid()).addEntity(DashboardRoles.class);
			
//			Query empTemplatedoc = session
//					.createNativeQuery("exec [synprod].[EmpDashboardRoleManagement] ?").setParameter(1, commonuser.getUserid()).addEntity(DashboardRoles.class);				
					
			 empTemplatedocList1=empTemplatedoc.list();
		/* System.out.println("1");
		for(DashboardRoles DashboardRoles:empTemplatedocList1) {			
			String role=DashboardRoles.getRole()	;	
			 System.out.println("Roles : " +role);
			 System.out.println("2");
			switch (role)
			{
		
			case "Reporting Manager":
				resultData.put(role, DashboardRoles.getRole_id());
				break;
			
			}

			}*/
//			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(empTemplatedocList1);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}
		
	}
	
	
	@Override
	public ResponseEntity<Object> getreporteelist() {
		Session session = entityManager.unwrap(Session.class);
		try{
			int employeeID=getempid(null);
			List<DashboardRoles> empTemplatedocList1=null;
			HashMap<String,Integer> resultData=new HashMap();
			//session.beginTransaction();
			System.out.println("Empid in getreporteelist daoimpl ");
			
			Query empTemplatedoc = session.createNativeQuery("select * from synprod.getempinformation where  reporting_manager_id = ?").setParameter(1,employeeID).addEntity(DashboardModel.class);				
			
//			Query empTemplatedoc = session
//					.createNativeQuery("exec [synprod].[EmpDashboardRoleManagement] ?").setParameter(1, commonuser.getUserid()).addEntity(DashboardRoles.class);				
					
			List empTemplatedocList=empTemplatedoc.list();	
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(empTemplatedocList);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}
		
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<Object> getaward(awardbean awardbean) {
		Session session = entityManager.unwrap(Session.class);		
		//String employeeID=null;
		String type="";
		Connection con = null;
		PreparedStatement pstmt=null;
		//prepareCall pstmt=null;
		ResultSet rs=null;
		
		//List<Award> awardData =null;
		
		/*try {
			awardData = new ArrayList<Award>();
			//System.out.println(awardData);
			System.out.println(jdbcTemplatex0.getDataSource().getConnection());
		
			con = jdbcTemplatex0.getDataSource().getConnection();
//			 pstmt = con.ex("{call synprod.USP_XOA_RnR_Award_Details_History (?,?)}");
			 // new SimpleJdbcCall(jdbcTemplate).withSchemaName("synprod")				.withProcedureName("USP_DMS_EmpNameByProjectID").execute(parameter);

				StoredProcedureQuery q = entityManager.createStoredProcedureQuery("SYNPROD.USP_XOA_RnR_Award_Details_History");
				
				q.registerStoredProcedureParameter(1, String.class, ParameterMode.IN).setParameter(1, "NK5037151");
				q.registerStoredProcedureParameter(2, String.class, ParameterMode.IN).setParameter(2, "spot");
				//			q.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN).setParameter(1, locationtype);
//				log.info("excute the query");
				List<Object[]> locationObjectList = q.getResultList();
//				return locationObjectList;
				System.out.println("Result set :::::::" +locationObjectList);
//			 
//			 pstmt.setString(1,commonuser.getUserid() );
//			pstmt.setString(2,award.getAward_type() );
//			rs = pstmt.executeQuery();
//			System.out.println("rs:"+rs.toString());
//			while(rs.next()) {
//				System.out.println(rs.getString("Award_Type"));
//				awarddata  = new Award();
//				awarddata.setAward_type(rs.getString("Award_Type"));
//				awarddata.setCITATION(rs.getString("CITATION"));
//				awarddata.setName(rs.getString("Name"));
//				awarddata.setNOMINATEDPERSON(rs.getString("NominatedPerson"));
//				//awardData.add(awarddata);
//			}
//			if(rs != null) {
//				rs.close();
//				rs=null;
//			}
//			if(pstmt != null) {
//				pstmt.close();
//				pstmt=null;
//			}
//			
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(awarddata);
		}
*/
	
		
		try{
			
			ArrayList<Award>awardData = new ArrayList<Award>();
			System.out.println(awardData);
			System.out.println(jdbcTemplatex0.getDataSource().getConnection());
	
			con = jdbcTemplatex0.getDataSource().getConnection();
			
			 pstmt = con.prepareStatement("{call [synprod].[USP_XOA_RnR_Award_Details_History](?,?)} ");
				
			pstmt.setString(1,awardbean.getUserid());
			pstmt.setString(2,awardbean.getType());
			/*pstmt.setString(1,"SP5034765");
			pstmt.setString(2,"Spot");*/
			
			rs = pstmt.executeQuery();
			System.out.println("rs size"+ rs.getFetchSize());
			//if(awardbean.getType()!=null) {
				type=awardbean.getType().toString();
				//System.out.println();
		//	}
					while(rs.next()){
						
						Award awarddata =  new Award();
						
						   if (type.equals("SPOT"))
				             {
				            	 awarddata.setAward_type(rs.getString("award_type"));
				            	 awarddata.setCITATION(rs.getString("citation"));
				 				 awarddata.setName(rs.getString("name"));
				 				 awarddata.setNOMINATEDPERSON(rs.getString("nominatedperson"));
				 				 
				 				awardData.add(awarddata);
				             }
				             else 
				             {
				            	 awarddata.setValue(rs.getString("Value"));
				            	 awarddata.setCITATION(rs.getString("CITATION"));
				            	 awarddata.setAward_Year(rs.getString("Award_Year"));
				            	 awarddata.setQuarter_ID(rs.getInt("Quarter_ID")); 
				           
				            	 System.out.println("value"+rs.getString("Value"));
				            	 
				            	 awardData.add(awarddata);
				             }
						
					}
          
		
			/*while(rs.Award) {
				awarddata  = new Award();
				awarddata.setAward_type(rs.getString("Award_Type"));
				awarddata.setCITATION(rs.getString("CITATION"));
				awarddata.setName(rs.getString("Name"));
				awarddata.setNOMINATEDPERSON(rs.getString("NominatedPerson"));
				awardData.add(awarddata);
				
	
			}*/
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
				
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(awardData);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
@Override
	public ResponseEntity<Object> getstepexesummary(Stepcommonbean stepcommonbean) {
	Session session = entityManager.unwrap(Session.class);		
	//String employeeID=null;
	String type="";
	Connection con = null;
	PreparedStatement pstmt=null;
	//prepareCall pstmt=null;
	ResultSet rs=null;
	StepSummary stepsummary =  new StepSummary();
	
		try{
		
		ArrayList<StepSummary>stepsummary1 = new ArrayList<StepSummary>();
		System.out.println(stepsummary1);
		System.out.println(jdbcTemplatex0.getDataSource().getConnection());

		con = jdbcTemplatex0.getDataSource().getConnection();
		
		 pstmt = con.prepareStatement("{call [synprod].[USP_XPO_ORG_Dashboard_GetData](?,?)} ");
	
		 pstmt.setString(1,stepcommonbean.getUserid());
		 pstmt.setInt(2,stepcommonbean.getResultset());
		 
		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stepsummary =new StepSummary();
				//stepsummary.setAccom_OverAllSmiley(rs.getString("accom_OverAllSmiley"));
				
				stepsummary.setOperationalElements(rs.getString("Smiley1"));
				stepsummary.setValueCreation(rs.getString("Smiley2"));
				stepsummary.setOverallAccomplishmentSummaryPerformance(rs.getString("Smiley3"));
								
				stepsummary1.add(stepsummary);
			}
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			/*Query empTemplatedoc = session
					.createNativeQuery("select * from [dbo].[PS_SY_EMPL_DASHBRD] where EMPLID=?").setParameter(1,employeeID).addEntity(Hrmsdata.class);	;				
						;				*/
			//List empTemplatedocList=empTemplatedoc.list();	
			  
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(stepsummary1);
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
		}finally {
			
			try {
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				if(con != null) {
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
		

@Override
public ResponseEntity<Object> getstrengthdata(Stepcommonbean stepcommonbean) {
Session session = entityManager.unwrap(Session.class);		
//String employeeID=null;
String type="";
Connection con = null;
PreparedStatement pstmt=null;
//prepareCall pstmt=null;
ResultSet rs=null;
Strengthdata strengthdata =  new Strengthdata();

	try{
	
	ArrayList<Strengthdata>strengthdata1 = new ArrayList<Strengthdata>();
	System.out.println(strengthdata1);
	System.out.println(jdbcTemplatex0.getDataSource().getConnection());

	con = jdbcTemplatex0.getDataSource().getConnection();
	
	 pstmt = con.prepareStatement("{call [synprod].[USP_XPO_ORG_Dashboard_GetData](?,?)} ");

	 pstmt.setString(1,stepcommonbean.getUserid());
	 pstmt.setInt(2,stepcommonbean.getResultset());
	 
	
		rs = pstmt.executeQuery();
		while(rs.next()) {
			strengthdata =new Strengthdata();
			//stepsummary.setAccom_OverAllSmiley(rs.getString("accom_OverAllSmiley"));
			strengthdata.setEmp_Strength(rs.getString("emp_Strength"));
			strengthdata.setEmp_Improvement_Area(rs.getString("emp_Improvement_Area"));
			
							
			strengthdata1.add(strengthdata);
		}
		if(rs != null) {
			rs.close();
			rs=null;
		}
		if(pstmt != null) {
			pstmt.close();
			pstmt=null;
		}
				  
		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(strengthdata1);
	}
	catch(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
	}finally {
		
		try {
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			if(con != null) {
				con.close();
				con=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

@Override
public ResponseEntity<Object> getdiscussiondata(Stepcommonbean stepcommonbean) {
Session session = entityManager.unwrap(Session.class);		
//String employeeID=null;

Connection con = null;
PreparedStatement pstmt=null;
//prepareCall pstmt=null;
ResultSet rs=null;
Discussiondata discussiondata =  new Discussiondata();

	try{
	
	ArrayList<Discussiondata>discussiondata1 = new ArrayList<Discussiondata>();
	System.out.println(discussiondata1);
	System.out.println(jdbcTemplatex0.getDataSource().getConnection());

	con = jdbcTemplatex0.getDataSource().getConnection();
	
	 pstmt = con.prepareStatement("{call [synprod].[USP_XPO_ORG_Dashboard_GetData](?,?)} ");

	 pstmt.setString(1,stepcommonbean.getUserid());
	 pstmt.setInt(2,stepcommonbean.getResultset());
	 
	
		rs = pstmt.executeQuery();
		while(rs.next()) {
			discussiondata =new Discussiondata();
			discussiondata.setData(rs.getString("Data"));
			discussiondata.setDiscussion(rs.getString("discussion"));
			
			discussiondata1.add(discussiondata);
		}
		if(rs != null) {
			rs.close();
			rs=null;
		}
		if(pstmt != null) {
			pstmt.close();
			pstmt=null;
		}
		/*Query empTemplatedoc = session
				.createNativeQuery("select * from [dbo].[PS_SY_EMPL_DASHBRD] where EMPLID=?").setParameter(1,employeeID).addEntity(Hrmsdata.class);	;				
					;				*/
		//List empTemplatedocList=empTemplatedoc.list();	
		  
		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(discussiondata1);
	}
	catch(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
	}finally {
		
		try {
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			if(con != null) {
				con.close();
				con=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	 
	
	
@Override
public ResponseEntity<Object> getagiledata(Stepcommonbean stepcommonbean) {
Session session = entityManager.unwrap(Session.class);		
//String employeeID=null;

Connection con = null;
PreparedStatement pstmt=null;
//prepareCall pstmt=null;
ResultSet rs=null;
Agiledata Agiledata =  new Agiledata();

	try{
	
	ArrayList<Agiledata>Agiledata1 = new ArrayList<Agiledata>();
	System.out.println(Agiledata1);
	System.out.println(jdbcTemplatex0.getDataSource().getConnection());

	con = jdbcTemplatex0.getDataSource().getConnection();
	
	 pstmt = con.prepareStatement("{call [synprod].[USP_XPO_ORG_Dashboard_GetData](?,?)} ");

	 pstmt.setString(1,stepcommonbean.getUserid());
	 pstmt.setInt(2,stepcommonbean.getResultset());
	 
	
		rs = pstmt.executeQuery();
		while(rs.next()) {
			
			Agiledata =new Agiledata();
			Agiledata.setAdaptive(rs.getString("Smiley1"));
			Agiledata.setGlobal(rs.getString("Smiley2"));
			Agiledata.setImaginative(rs.getString("Smiley3"));
			Agiledata.setLeadership(rs.getString("Smiley4"));
			Agiledata.setEntrepreneurial(rs.getString("Smiley5"));
			Agiledata.setOverall_Potentials(rs.getString("Smiley"));
			
			
			Agiledata1.add(Agiledata);
		}
		if(rs != null) {
			rs.close();
			rs=null;
		}
		if(pstmt != null) {
			pstmt.close();
			pstmt=null;
		}
		/*Query empTemplatedoc = session
				.createNativeQuery("select * from [dbo].[PS_SY_EMPL_DASHBRD] where EMPLID=?").setParameter(1,employeeID).addEntity(Hrmsdata.class);	;				
					;				*/
		//List empTemplatedocList=empTemplatedoc.list();	
		  
		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(Agiledata1);
	}
	catch(Exception e){
		e.printStackTrace();
		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
	}finally {
		
		try {
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt=null;
			}
			if(con != null) {
				con.close();
				con=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	 
	
	
	@Override
	public ResponseEntity<Object> getLearningdetails(Learningbean learningbean) {
		Session session = entityManager.unwrap(Session.class);		
		//String employeeID=null;
		String type="";
		Connection con = null;
		PreparedStatement pstmt=null;
		//prepareCall pstmt=null;
		ResultSet rs=null;
		Learningdetails learningdata =  new Learningdetails();
		
			try{
			
			ArrayList<Learningdetails>learningdata1 = new ArrayList<Learningdetails>();
			System.out.println(learningdata1);
			System.out.println(jdbcTemplatex0.getDataSource().getConnection());
	
			con = jdbcTemplatex0.getDataSource().getConnection();
			
			 pstmt = con.prepareStatement("select * from [synprod].[XPO_LMS_Emp_Learning_Activity_Prev_Month] where User_Id= ?");
		
			 pstmt.setString(1,learningbean.getUserid());
			 
			
				rs = pstmt.executeQuery();
				while(rs.next()) {
					learningdata  = new Learningdetails();
					learningdata.setCourse_name(rs.getString("Course_name"));
					learningdata.setCompletion_status(rs.getString("Completion_status"));
					learningdata.setCompletion_date(rs.getString("Completion_date"));
					learningdata.setActual_duration(rs.getInt("Actual_duration"));
					learningdata.setExpected_duration(rs.getInt("Expected_duration"));
					learningdata.setHigh_score(rs.getInt("High_score"));
					
					
					learningdata1.add(learningdata);
				}
				if(rs != null) {
					rs.close();
					rs=null;
				}
				if(pstmt != null) {
					pstmt.close();
					pstmt=null;
				}
				/*Query empTemplatedoc = session
						.createNativeQuery("select * from [dbo].[PS_SY_EMPL_DASHBRD] where EMPLID=?").setParameter(1,employeeID).addEntity(Hrmsdata.class);	;				
							;				*/
				//List empTemplatedocList=empTemplatedoc.list();	
				  
				return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(learningdata1);
			}
			catch(Exception e){
				e.printStackTrace();
				return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("No record Found");
			}finally {
				
				try {
					if(rs != null) {
						rs.close();
						rs=null;
					}
					if(pstmt != null) {
						pstmt.close();
						pstmt=null;
					}
					if(con != null) {
						con.close();
						con=null;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 
	
						
			
		
	}
	
	

}
