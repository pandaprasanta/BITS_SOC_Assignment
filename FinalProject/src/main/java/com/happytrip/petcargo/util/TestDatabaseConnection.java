package com.happytrip.petcargo.util;
import org.junit.*;


import static org.junit.Assert.*;
public class TestDatabaseConnection {

	
	@Test
	public void testConnection(){
		System.out.println(DatabaseConnector.getSessionFactory());
		assertNotNull("Error: failure in creating session factory",DatabaseConnector.getSessionFactory());
	}
	
}
