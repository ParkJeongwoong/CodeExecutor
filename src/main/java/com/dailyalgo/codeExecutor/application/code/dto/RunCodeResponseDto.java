package com.dailyalgo.codeExecutor.application.code.dto;

import lombok.Getter;

@Getter
public class RunCodeResponseDto {

	private final String result;

	public RunCodeResponseDto(String result) {
		this.result = result;
	}

}
