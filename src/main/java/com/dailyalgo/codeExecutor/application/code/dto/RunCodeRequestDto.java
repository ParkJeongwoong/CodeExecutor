package com.dailyalgo.codeExecutor.application.code.dto;

import lombok.Getter;

@Getter
public class RunCodeRequestDto {

	private final String code;
	private final String language;
	private final String outputType;

	public RunCodeRequestDto(String code, String language, String outputType) {
		this.code = code;
		this.language = language;
		this.outputType = outputType;
	}

}
