package com.dashboardjava.dao;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dashboardjava.model.User;




@Transactional
@Repository
public class BgvDaoImpl implements BgvDao{
	
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	Session session = null;
	
	@Override
	public ResponseEntity<Object> deleteuser(int id) {
		try
		{
			session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			
			session.beginTransaction();
			User user=new User();
			user.setId(id);
			user.setActivestatus(0);
			session.update(user);
			session.getTransaction().commit();
			session.close();
		
		
		return ResponseEntity.status(200).contentType(MediaType.TEXT_PLAIN).body("Record updated.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
			return ResponseEntity.status(200).contentType(MediaType.TEXT_PLAIN).body("updation failed.");
			
		}
				
	}
	

}
