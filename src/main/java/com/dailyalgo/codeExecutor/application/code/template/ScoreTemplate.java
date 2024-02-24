package com.dailyalgo.codeExecutor.application.code.template;

import java.util.ArrayList;
import java.util.List;

public interface ScoreTemplate {

	List<List> input = new ArrayList();
	List output = new ArrayList();

	String getTemplate();
	String getFileType();
	void compile();
	ProcessBuilder getProcessBuilder();

}
