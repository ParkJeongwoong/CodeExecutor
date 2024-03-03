package com.dailyalgo.codeExecutor.adapter.controller;

import com.dailyalgo.codeExecutor.application.code.dto.RunCodeRequestDto;
import com.dailyalgo.codeExecutor.application.code.dto.RunCodeResponseDto;
import com.dailyalgo.codeExecutor.application.code.dto.ScoreCodeRequestDto;
import com.dailyalgo.codeExecutor.application.code.dto.ScoreCodeResponseDto;
import com.dailyalgo.codeExecutor.application.code.service.CodeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "코드 실행 API", description = "코드를 실행하는 API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/code")
public class CodeController {

	private final CodeService codeService;

	@PostMapping("/run")
	public ResponseEntity<RunCodeResponseDto> runCode(@RequestBody RunCodeRequestDto requestDto) {
		String id = requestDto.getId();
		String code = requestDto.getCode();
		String language = requestDto.getLanguage();
		String outputType = requestDto.getOutputType();

		RunCodeResponseDto responseDto = codeService.runCode(id, code, language, outputType);
		return ResponseEntity.ok(responseDto);
	}

	@PostMapping("/score")
	public ResponseEntity<ScoreCodeResponseDto> scoreCode(@RequestBody ScoreCodeRequestDto requestDto) {
		String id = requestDto.getId();
		String code = requestDto.getCode();
		String language = requestDto.getLanguage();
		String outputType = requestDto.getOutputType();
		List<String> inputType = requestDto.getInputType();
		List<List<String>> input = requestDto.getInput();
		List<String> output = requestDto.getOutput();

		ScoreCodeResponseDto responseDto = codeService.scoreCode(id, code, language, inputType, outputType, input, output);
		return ResponseEntity.ok(responseDto);
	}

}
