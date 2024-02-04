package com.boilerplate.springboot.application.example.service;

import com.boilerplate.springboot.aop.annotation.CustomAOP;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AOPService2 {

	@CustomAOP
	public void aopMethod_service2() {
		System.out.println("This is aopMethod_service2 in AOPService2.java");
		aopMethod2_service2();
	}

	@CustomAOP
	public void aopMethod2_service2() {
		System.out.println("This is aopMethod2_service2 in AOPService2.java");
	}

}
