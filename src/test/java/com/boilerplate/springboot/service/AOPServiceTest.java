package com.boilerplate.springboot.service;

import com.boilerplate.springboot.application.example.service.AOPService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AOPServiceTest {

	@Autowired
	AOPService aopService;

	@Test
	public void aopMethod_test() {
		aopService.aopMethod();
	}

}
