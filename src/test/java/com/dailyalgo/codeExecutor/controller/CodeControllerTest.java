package com.dailyalgo.codeExecutor.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailyalgo.codeExecutor.adapter.controller.CodeController;
import com.dailyalgo.codeExecutor.application.code.dto.RunCodeRequestDto;

@SpringBootTest
class CodeControllerTest {

	@Autowired
	private CodeController codeController;

	@Test
	void python_run_test() {
		String code = """
				def solution():
					return 94
				""";
		String language = "python";

		RunCodeRequestDto request = new RunCodeRequestDto("python_run_test", code, language, "");
		String result = codeController.runCode(request)
				.getBody()
				.getResult();

		System.out.println("Result : " + result); // "Result : 94\n
		assertThat(result).isEqualTo("94\n");
	}

	@Test
	void java_run_test() {
		String code = """
				class Solution {
					String solution() {
						return "15";
					}
				}""";
		String language = "java";

		RunCodeRequestDto request = new RunCodeRequestDto("java_run_test", code, language, "String");
		String result = codeController.runCode(request)
				.getBody()
				.getResult();

		System.out.println("Result : " + result); // "Result : 15\n
		assertThat(result).isEqualTo("15\n");
	}

	@Test
	void java_int_run_test() {
		String code = """
				class Solution {
					int solution() {
				    	return 25;
					}
				}""";
		String language = "java";

		RunCodeRequestDto request = new RunCodeRequestDto("java_int_run_test", code, language, "int");
		String result = codeController.runCode(request)
				.getBody()
				.getResult();

		System.out.println("Result : " + result); // "Result : 25\n
		assertThat(result).isEqualTo("25\n");
	}

	@Test
	void java_list_run_test() {
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

		RunCodeRequestDto request = new RunCodeRequestDto("java_list_run_test", code, language, "List");
		String result = codeController.runCode(request)
				.getBody()
				.getResult();

		System.out.println("Result : " + result); // "Result : [5, 10]\n
		assertThat(result).isEqualTo("[5, 10]\n");
	}

}
