package com.dailyalgo.codeExecutor.application.code.template;

import java.util.ArrayList;
import java.util.List;

public interface ScoreTemplate {

	List<List<String>> input = new ArrayList<>();
	List<String> output = new ArrayList<>();

	String getCode();
	String getTemplate();
	String getFileName();
	void compile(String path);
	ProcessBuilder getProcessBuilder();

}
