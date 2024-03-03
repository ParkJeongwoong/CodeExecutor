package com.dailyalgo.codeExecutor.application.code.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class ScoreCodeResponseDto {

	private final String id;
	private boolean isCorrect;
	private String message;
	private final List<Boolean> resultList;

	public ScoreCodeResponseDto(String id, List<Boolean> resultList) {
		this.id = id;
		this.resultList = resultList;
	}

	public void addResult(Boolean result) {
		this.resultList.add(result);
	}

	public ScoreCodeResponseDto setResult(boolean isCorrect, String message) {
		this.isCorrect = isCorrect;
		this.message = message;
		return this;
	}

}
