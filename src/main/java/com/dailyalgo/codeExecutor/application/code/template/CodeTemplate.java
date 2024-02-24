package com.dailyalgo.codeExecutor.application.code.template;

import java.util.List;

public class CodeTemplate {

	protected String code;
	protected List inputType;
	protected String outputType;

	protected final StringBuilder stringBuilder = new StringBuilder();

	public CodeTemplate(String code, List inputType, String outputType) {
		this.code = code;
		this.inputType = inputType;
		this.outputType = outputType;
	}

	public String getTemplate() {
		return this.code;
	}

	public String getFileType() {
		return ".txt";
	}

	public ProcessBuilder getProcessBuilder() {
		return new ProcessBuilder();
	}

	public void compile() {
		// do nothing
	}

}
