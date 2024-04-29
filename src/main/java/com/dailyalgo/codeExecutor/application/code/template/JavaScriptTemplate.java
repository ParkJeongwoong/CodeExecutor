package com.dailyalgo.codeExecutor.application.code.template;

import java.util.List;

public class JavaScriptTemplate extends CodeTemplate {

	public JavaScriptTemplate(String code, List<String> inputType, String outputType) {
		super(code, inputType, outputType);
	}

	@Override
	public String getTemplate() {
		code = code.replaceAll("console.log\\(.*\\)", "")
			.replaceAll("prompt\\(.*\\)", "")
			.replaceAll("alert\\(.*\\)", "")
			.replaceAll("confirm\\(.*\\)", "");

		return stringBuilder
			.append(code).append(System.lineSeparator())
			.append("print(solution())")
			.toString();
	}

	@Override
	public String getFileName() {
		return "Run.js";
	}

	@Override
	public ProcessBuilder getProcessBuilder() {
		return new ProcessBuilder("node", "Run.js");
	}

}
