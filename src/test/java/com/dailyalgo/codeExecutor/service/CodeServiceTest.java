package com.dailyalgo.codeExecutor.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailyalgo.codeExecutor.application.code.service.CodeService;

@SpringBootTest
class CodeServiceTest {

	@Autowired
	private CodeService codeService;

	@Test
	void python_run_test() {
		String code = "def solution():\n    return 94";
		String language = "python";

		String result = codeService.runCode("python_test", code, language, "")
				.getResult();

		System.out.println("Result : " + result); // "Result : 94\n
		assertThat(result).isEqualTo("94\n");
	}

	@Test
	void python_score_test1() {
		String code = "def solution(a, b):\n    return a+b";
		String language = "python";
		List<String> inputType = new ArrayList<>();
		inputType.add("int");
		inputType.add("int");
		String outputType = "int";
		List<List<String>> input = new ArrayList<>();
		input.add(List.of("5", "10"));
		input.add(List.of("10", "20"));
		input.add(List.of("15", "30"));
		List<String> output = new ArrayList<>();
		output.add("15");
		output.add("30");
		output.add("55");

		List<Boolean> resultList = codeService.scoreCode("test1", code, language, inputType, outputType, input, output)
				.getResultList();

		System.out.println("Score : " + resultList.toString()); // "Score : [true, true, false]
		assertThat(resultList).containsExactly(true, true, false);
	}

	@Test
	void python_score_test2() {
		String code = "def solution(a, b):\n    return a+b";
		String language = "python";
		List<String> inputType = new ArrayList<>();
		inputType.add("str");
		inputType.add("str");
		String outputType = "str";
		List<List<String>> input = new ArrayList<>();
		input.add(List.of("5", "10"));
		input.add(List.of("10", "20"));
		input.add(List.of("15", "30"));
		List<String> output = new ArrayList<>();
		output.add("510");
		output.add("1020");
		output.add("153");

		List<Boolean> resultList = codeService.scoreCode("test2", code, language, inputType, outputType, input, output)
				.getResultList();

		System.out.println("Score : " + resultList.toString()); // "Score : [true, true, false]
		assertThat(resultList).containsExactly(true, true, false);
	}

	@Test
	void python_score_test3() {
		String code = "def solution(a, b, c):\n    return a+b+c";
		String language = "python";
		List<String> inputType = new ArrayList<>();
		inputType.add("str");
		inputType.add("str");
		inputType.add("str");
		String outputType = "str";
		List<List<String>> input = new ArrayList<>();
		input.add(List.of("hello", " ", "world"));
		input.add(List.of("hi", " ", "there"));
		List<String> output = new ArrayList<>();
		output.add("hello world");
		output.add("hi there?");

		List<Boolean> resultList = codeService.scoreCode("test3", code, language, inputType, outputType, input, output)
				.getResultList();

		System.out.println("Result : " + resultList.toString()); // "Result : [true, false]
		assertThat(resultList).containsExactly(true, false);
	}

}
