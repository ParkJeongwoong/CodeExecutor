package com.dailyalgo.codeExecutor.application.code.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScoreCodeResponseDto {

	private final String id;
	private boolean isCorrect;
	private String message;
	private final List<Boolean> resultList;

	public void addResult(Boolean result) {
		this.resultList.add(result);
	}

}
