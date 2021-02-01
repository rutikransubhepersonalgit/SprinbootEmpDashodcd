package com.dashboardjava.dao;

import org.springframework.http.ResponseEntity;

public interface BgvDao {
	
	ResponseEntity<Object> deleteuser(int id);

}
