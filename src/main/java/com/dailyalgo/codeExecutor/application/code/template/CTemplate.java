package com.dailyalgo.codeExecutor.application.code.template;

import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CTemplate extends CodeTemplate {

	public CTemplate(String code, List<String> inputType, String outputType) {
		super(code, inputType, outputType);
	}

	@Override
	public String getTemplate() {
		code = code.replaceAll("printf\\(.*\\)", "")
			.replaceAll("wprintf\\(.*\\)", "");

		return stringBuilder
			.append(code).append(System.lineSeparator())
			.append("print(solution())")
			.toString();
	}

	@Override
	public String getFileName() {
		return "Run.c";
	}

	@Override
	public ProcessBuilder getProcessBuilder() {
//		return new ProcessBuilder("gcc", "Run.c", "-o", "Run", "&&", "./Run");
		return new ProcessBuilder("./Run");
	}

	@Override
	public void compile(String path) {
		ProcessBuilder compileProcessBuilder = new ProcessBuilder("gcc", "Run.c", "-o", "Run");
		compileProcessBuilder.directory(new File(path));
		try {
			Process process = compileProcessBuilder.start();
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			log.error("Error occurred while compiling", e);
		}
	}

}
