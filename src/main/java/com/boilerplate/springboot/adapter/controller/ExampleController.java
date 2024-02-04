package com.boilerplate.springboot.adapter.controller;

import com.boilerplate.springboot.application.example.dto.HelloExampleResponseDto;
import com.boilerplate.springboot.application.example.service.AOPService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "예제 API", description = "간단한 참고용 API")
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/example")
public class ExampleController {

	private final AOPService aopService;

	@Operation(summary = "테스트", description = "test를 반환하는 API")
	@GetMapping("/test")
	public String test() {
		System.out.println("test");
		log.info("test");
		log.debug("test");
		log.error("test");
		return "test";
	}

	@Operation(summary = "Dto 테스트", description = "이름과 금액을 입력받아 HelloExampleResponseDto를 반환하는 API")
	@GetMapping("/hello")
	public ResponseEntity<HelloExampleResponseDto> hello(@RequestParam("name") String name, @RequestParam("amount") int amount) {
		return ResponseEntity.ok(new HelloExampleResponseDto(name, amount));
	}

	@Operation(summary = "예외 테스트", description = "예외를 발생시키는 API")
	@GetMapping("/exception")
	public void exception() {
		throw new RuntimeException("예외 발생");
	}

	@Operation(summary = "AOP 테스트", description = "AOP를 테스트하는 API")
	@GetMapping("/aop")
	public void aopTest() {
		aopService.aopMethod();
	}

}
