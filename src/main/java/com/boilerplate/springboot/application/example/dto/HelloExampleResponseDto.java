package com.boilerplate.springboot.application.example.dto;

import lombok.Getter;

@Getter
public class HelloExampleResponseDto {

	private final String name;
	private final int amount;

	public HelloExampleResponseDto(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}

}
