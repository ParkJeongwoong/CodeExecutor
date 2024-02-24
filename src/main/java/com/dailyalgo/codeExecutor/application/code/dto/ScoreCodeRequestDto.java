package com.dailyalgo.codeExecutor.application.code.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class ScoreCodeRequestDto {

	private final String code;
	private final String language;
	private final List<List> input;
	private final List output;
	private final List inputType;
	private final String outputType;

	public ScoreCodeRequestDto(String code, String language, List<List> input, List output, List inputType, String outputType) {
		this.code = code;
		this.language = language;
		this.input = input;
		this.output = output;
		this.inputType = inputType;
		this.outputType = outputType;
	}

}