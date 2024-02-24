package com.dailyalgo.codeExecutor.application.code.template;

import java.util.List;

public class PythonTemplate extends CodeTemplate {

	public PythonTemplate(String code, List inputType, String outputType) {
		super(code, inputType, outputType);
	}

	@Override
	public String getTemplate() {
		code = super.code.replaceAll("print\\(.*\\)", "");

		return stringBuilder
			.append(code).append(System.lineSeparator())
			.append("if __name__ == \"__main__\":").append(System.lineSeparator())
			.append("    result = solution()").append(System.lineSeparator())
			.append("    print(result)")
			.toString();
	}

	@Override
	public String getFileType() {
		return ".py";
	}

	@Override
	public ProcessBuilder getProcessBuilder() {
		return new ProcessBuilder("python", "run.py");
	}

}
