package com.dailyalgo.codeExecutor.application.code.template;

public interface ScoreTemplate {

	String getCode();
	String getTemplate();
	String getFileName();
	void compile(String path);
	ProcessBuilder getProcessBuilder();

}
