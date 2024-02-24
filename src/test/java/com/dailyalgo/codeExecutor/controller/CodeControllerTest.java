package com.dailyalgo.codeExecutor.controller;

import com.dailyalgo.codeExecutor.adapter.controller.CodeController;
import com.dailyalgo.codeExecutor.application.code.dto.RunCodeRequestDto;
import com.dailyalgo.codeExecutor.application.code.dto.RunCodeResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class CodeControllerTest {

	@Autowired
	CodeController codeController;

	@Test
	public void python_run_test() {
		String code = "def solution():\n    return 94";
		String language = "python";
		ResponseEntity<RunCodeResponseDto> response = codeController.runCode(new RunCodeRequestDto(code, language, ""));
		System.out.println("Result : " + response.getBody().getResult()); // "Result : 94\n
	}

	@Test
	public void java_run_test() {
		String code = "String solution() {\n    return \"15\";\n}";
		String language = "java";
		ResponseEntity<RunCodeResponseDto> response = codeController.runCode(new RunCodeRequestDto(code, language, "String"));
		System.out.println("Result : " + response.getBody().getResult()); // "Result : 15\n
	}

	@Test
	public void java_int_run_test() {
		String code = "int solution() {\n    return 25;\n}";
		String language = "java";
		ResponseEntity<RunCodeResponseDto> response = codeController.runCode(new RunCodeRequestDto(code, language, "int"));
		System.out.println("Result : " + response.getBody().getResult()); // "Result : 25\n
	}

	@Test
	public void java_list_run_test() {
		String code = "List solution() {"
				+ "\n    List<Integer> list = new ArrayList<>();"
				+ "\n    list.add(5);"
				+ "\n    list.add(10);"
				+ "\n    return list;"
				+ "\n}";
		String language = "java";
		ResponseEntity<RunCodeResponseDto> response = codeController.runCode(new RunCodeRequestDto(code, language, "List"));
		System.out.println("Result : " + response.getBody().getResult()); // "Result : 15\n
	}

}
