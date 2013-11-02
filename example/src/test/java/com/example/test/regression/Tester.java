package com.example.test.regression;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.test.Server;

public class Tester {

	Server s = null;
	
	
	@Before
	public void setUp() throws Exception {
		
		 s = new Server();
		
	}

	@After
	public void tearDown() throws Exception {
		
		s = null;
	}

	@Test
	public void testGetTime() {
		
		Socket s;
		String answer = null;
		
		try {
			s = new Socket("127.0.0.1", 9090);
		
			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream())); 
        
			answer = input.readLine(); 
        
 		} catch (Exception e) {
		
			fail("Connection failed:" + e.getMessage());
		}
        
		assertEquals("Same Time?", new Date().toString(), answer);
	}

}
