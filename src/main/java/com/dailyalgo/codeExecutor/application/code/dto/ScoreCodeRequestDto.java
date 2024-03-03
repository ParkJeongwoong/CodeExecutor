package com.dailyalgo.codeExecutor.application.code.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class ScoreCodeRequestDto {

	private final String id;
	private final String code;
	private final String language;
	private final List<List<String>> input;
	private final List<String> output;
	private final List<String> inputType;
	private final String outputType;

	public ScoreCodeRequestDto(String id, String code, String language, List<List<String>> input, List<String> output, List<String> inputType, String outputType) {
		this.id = id;
		this.code = code;
		this.language = language;
		this.input = input;
		this.output = output;
		this.inputType = inputType;
		this.outputType = outputType;
	}

}