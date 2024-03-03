package com.dailyalgo.codeExecutor.controller;

import com.dailyalgo.codeExecutor.adapter.controller.CodeController;
import com.dailyalgo.codeExecutor.application.code.dto.RunCodeRequestDto;
import com.dailyalgo.codeExecutor.application.code.dto.RunCodeResponseDto;
import java.util.Objects;
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
		String code = """
			def solution():
				return 94
			""";
		String language = "python";
		ResponseEntity<RunCodeResponseDto> response = codeController.runCode(new RunCodeRequestDto("python_run_test",  code, language, ""));
		System.out.println("Result : " + Objects.requireNonNull(response.getBody()).getResult()); // "Result : 94\n
	}

	@Test
	public void java_run_test() {
		String code = """
			class Solution {
				String solution() {
					return "15";
				}
			}""";
		String language = "java";
		ResponseEntity<RunCodeResponseDto> response = codeController.runCode(new RunCodeRequestDto("java_run_test", code, language, "String"));
		System.out.println("Result : " + Objects.requireNonNull(response.getBody()).getResult()); // "Result : 15\n
	}

	@Test
	public void java_int_run_test() {
		String code = """
			class Solution {
				int solution() {
			    	return 25;
				}
			}""";
		String language = "java";
		ResponseEntity<RunCodeResponseDto> response = codeController.runCode(new RunCodeRequestDto("java_int_run_test", code, language, "int"));
		System.out.println("Result : " + Objects.requireNonNull(response.getBody()).getResult()); // "Result : 25\n
	}

	@Test
	public void java_list_run_test() {
		String code = """
			import java.util.ArrayList;
			import java.util.List;
			
			class Solution {
				List solution() {
					List<Integer> list = new ArrayList<>();
					list.add(5);
					list.add(10);
					return list;
				}
			}""";
		String language = "java";
		ResponseEntity<RunCodeResponseDto> response = codeController.runCode(new RunCodeRequestDto("java_list_run_test", code, language, "List"));
		System.out.println("Result : " + Objects.requireNonNull(response.getBody()).getResult()); // "Result : 15\n
	}

}
