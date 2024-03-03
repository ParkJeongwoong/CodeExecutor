package com.dailyalgo.codeExecutor.application.code.template;

import java.util.List;

public class CodeTemplate {

	protected String code;
	protected List<String> inputType;
	protected String outputType;

	protected final StringBuilder stringBuilder = new StringBuilder();

	public CodeTemplate(String code, List<String> inputType, String outputType) {
		this.code = code;
		this.inputType = inputType;
		this.outputType = outputType;
	}

	public String getCode() {
		return this.code;
	}

	public String getTemplate() {
		return this.code;
	}

	public String getFileName() {
		return "code.txt";
	}

	public ProcessBuilder getProcessBuilder() {
		return new ProcessBuilder();
	}

	public void compile(String path) {
		// do nothing
	}

}
