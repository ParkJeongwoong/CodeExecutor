package com.dailyalgo.codeExecutor.application.code.template;

import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CppTemplate extends CodeTemplate {

	public CppTemplate(String code, List<String> inputType, String outputType) {
		super(code, inputType, outputType);
	}

	@Override
	public String getTemplate() {
		return stringBuilder
			.append(code).append(System.lineSeparator())
			.append("int main() {").append(System.lineSeparator())
			.append("    solution();").append(System.lineSeparator())
			.append("    return 0;").append(System.lineSeparator())
			.append("}")
			.toString();
	}

	@Override
	public String getFileName() {
		return "Run.cpp";
	}

	@Override
	public ProcessBuilder getProcessBuilder() {
//		return new ProcessBuilder("g++", "Run.cpp", "-o", "Run", "&&", "./Run");
		return new ProcessBuilder("./Run");
	}

	@Override
	public void compile(String path) {
		ProcessBuilder compileProcessBuilder = new ProcessBuilder("g++", "Run.cpp", "-o", "Run");
		compileProcessBuilder.directory(new File(path));
		try {
			Process process = compileProcessBuilder.start();
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			log.error("Error occurred while compiling", e);
		}
	}

}
