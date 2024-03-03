package com.dailyalgo.codeExecutor.service;

import com.dailyalgo.codeExecutor.application.code.dto.RunCodeResponseDto;
import com.dailyalgo.codeExecutor.application.code.dto.ScoreCodeResponseDto;
import com.dailyalgo.codeExecutor.application.code.service.CodeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CodeServiceTest {

	@Autowired
	CodeService codeService;

	@Test
	public void python_run_test() {
		String code = "def solution():\n    return 94";
		String language = "python";
		RunCodeResponseDto response = codeService.runCode("python_test", code, language, "");
		System.out.println("Result : " + response.getResult()); // "Result : 94\n
	}

	@Test
	public void python_score_test1() {
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

		ScoreCodeResponseDto response = codeService.scoreCode("test1", code, language, inputType, outputType, input, output);
		System.out.println("Score : " + response.getResultList().toString()); // "Score : 100\n
	}

	@Test
	public void python_score_test2() {
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

		ScoreCodeResponseDto response = codeService.scoreCode("test2", code, language, inputType, outputType, input, output);
		System.out.println("Score : " + response.getResultList().toString()); // "Score : [true, true, false]
	}

	@Test
	public void python_score_test3() {
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

		ScoreCodeResponseDto response = codeService.scoreCode("test3", code, language, inputType, outputType, input, output);
		System.out.println("Result : " + response.getResultList().toString()); // "Result : [true, false]
	}

}
