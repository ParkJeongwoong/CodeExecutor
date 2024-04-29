package com.dailyalgo.codeExecutor.application.code.template;

import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaTemplate extends CodeTemplate {

	public JavaTemplate(String code, List<String> inputType, String outputType) {
		super(code, inputType, outputType);
	}

	@Override
	public String getTemplate() {
		code = code.replaceAll("System.out.println\\(.*\\)", "")
			.replaceAll("System.out.print\\(.*\\)", "");

		return stringBuilder
			.append("import java.util.*;").append(System.lineSeparator())
			.append("public class Run {").append(System.lineSeparator())
			.append("    public static void main(String[] args) {").append(System.lineSeparator())
			.append("        Solution solution = new Solution();").append(System.lineSeparator())
			.append("        ").append(outputType).append(" result = solution.solution();").append(System.lineSeparator())
			.append("        System.out.println(String.valueOf(result));").append(System.lineSeparator())
			.append("    }").append(System.lineSeparator())
			.append("}").toString();
	}

	@Override
	public String getFileName() {
		return "Run.java";
	}

	@Override
	public ProcessBuilder getProcessBuilder() {
//		return new ProcessBuilder("javac", "Run.java", "&&", "java", "Run");
		return new ProcessBuilder("java", "Run");
	}

	@Override
	public void compile(String path) {
		ProcessBuilder runProcessBuilder = new ProcessBuilder("javac", "Run.java");
		ProcessBuilder SolutionProcessBuilder = new ProcessBuilder("javac", "Solution.java");
		runProcessBuilder.directory(new File(path));
		SolutionProcessBuilder.directory(new File(path));
		try {
			Process processR = runProcessBuilder.start();
			processR.waitFor();
			Process processS = SolutionProcessBuilder.start();
			processS.waitFor();
		} catch (IOException | InterruptedException e) {
			log.error("Error occurred while compiling", e);
		}
	}

}
