package com.boilerplate.springboot.adapter.controller;

import com.boilerplate.springboot.application.example.dto.HelloExampleResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "예제 API", description = "간단한 참고용 API")
@Slf4j
@RestController
@RequestMapping("/example")
public class ExampleController {

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

}
