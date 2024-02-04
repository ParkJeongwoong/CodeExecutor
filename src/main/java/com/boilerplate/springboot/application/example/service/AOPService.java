package com.boilerplate.springboot.application.example.service;

import com.boilerplate.springboot.aop.annotation.CustomAOP;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AOPService {

	private final AOPService2 aopService2;

	@CustomAOP
	public void aopMethod() {
		System.out.println("This is aopMethod in AOPService.java");
		aopMethod2();
		aopService2.aopMethod_service2();
	}

	@CustomAOP
	public void aopMethod2() {
		System.out.println("This is aopMethod2 in AOPService.java");
	}

}
