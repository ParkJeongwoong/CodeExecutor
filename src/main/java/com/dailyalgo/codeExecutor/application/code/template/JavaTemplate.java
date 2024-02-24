package com.dailyalgo.codeExecutor.application.code.template;

import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaTemplate extends CodeTemplate {

	public JavaTemplate(String code, List inputType, String outputType) {
		super(code, inputType, outputType);
	}

	@Override
	public String getTemplate() {
		code = code.replaceAll("System.out.println\\(.*\\)", "")
			.replaceAll("System.out.print\\(.*\\)", "");

		return stringBuilder
			.append("import java.util.*;").append(System.lineSeparator())
			.append("public class Main {").append(System.lineSeparator())
			.append("static class Solution {").append(System.lineSeparator())
			.append("Solution() {}").append(System.lineSeparator())
			.append(super.code).append(System.lineSeparator())
			.append("}").append(System.lineSeparator())
			.append("public static void main(String[] args) {").append(System.lineSeparator())
			.append("    Solution solution = new Solution();").append(System.lineSeparator())
			.append("    ").append(outputType).append(" result = solution.solution();").append(System.lineSeparator())
			.append("    System.out.println(String.valueOf(result));").append(System.lineSeparator())
			.append("}").append(System.lineSeparator())
			.append("}").toString();
	}

	@Override
	public String getFileType() {
		return ".java";
	}

	@Override
	public ProcessBuilder getProcessBuilder() {
		return new ProcessBuilder("java", "run.java");
	}

	@Override
	public void compile() {
		ProcessBuilder processBuilder = new ProcessBuilder("javac", "./code/run.java");
		try {
			Process process = processBuilder.start();
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			log.error("Error occurred while compiling", e);
		}
	}

}
