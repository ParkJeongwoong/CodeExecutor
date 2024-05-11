package com.dailyalgo.codeExecutor.application.code.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dailyalgo.codeExecutor.application.code.dto.RunCodeResponseDto;
import com.dailyalgo.codeExecutor.application.code.dto.ScoreCodeResponseDto;
import com.dailyalgo.codeExecutor.application.code.template.CodeTemplate;
import com.dailyalgo.codeExecutor.application.code.template.ScoreTemplate;
import com.dailyalgo.codeExecutor.application.code.template.factory.CodeTemplateFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeService {

	private final CodeFileManager codeFileManager;

	public RunCodeResponseDto runCode(String id, String code, String language, String outputType) {
		CodeTemplateFactory codeTemplateFactory = CodeTemplateFactory.from(language);
		CodeTemplate runTemplate = codeTemplateFactory.buildRunTemplate(code, null, outputType);

		String path = "./code/" + id;
		codeFileManager.saveRunCodes(path, runTemplate, language);
		runTemplate.compile(path); // java only
		String result = execute(path, runTemplate.getProcessBuilder());

		return new RunCodeResponseDto(result);
	}

	public ScoreCodeResponseDto scoreCode(
			String id,
			String code,
			String language,
			List<String> inputType,
			String outputType,
			List<List<String>> input,
			List<String> output
	) {
		CodeTemplateFactory codeTemplateFactory = CodeTemplateFactory.from(language);
		ScoreTemplate scoreTemplate = codeTemplateFactory.buildScoreTemplate(code, inputType, outputType, input, output);

		String path = "./code/" + id;
		codeFileManager.saveScoreCodes(path, scoreTemplate, language);
		scoreTemplate.compile(path); // java only
		List<Boolean> result = score(path, scoreTemplate.getProcessBuilder(), output);

		return ScoreCodeResponseDto.builder()
				.id(id)
				.resultList(result)
				.isCorrect(true)
				.message("Success")
				.build();
	}

	private String execute(String path, ProcessBuilder processBuilder) {
		String result = "";

		try {
			log.info("Executing code");
			processBuilder.directory(new File(path));
			Process process = processBuilder.start();

			StringBuilder output = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line).append("\n");
			}

			int exitVal = process.waitFor();

			if (exitVal == 0) {
				result = output.toString();
			} else {
				result = "Error occurred while executing code";
			}
		} catch (IOException | InterruptedException e) {
			log.error("Error occurred while executing code", e);
		}

		return result;
	}

	private List<Boolean> score(String path, ProcessBuilder processBuilder, List<String> outputList) {
		List<String> result = new ArrayList<>();

		try {
			log.info("Score code");
			processBuilder.directory(new File(path));
			Process process = processBuilder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				result.add(line);
			}

			int exitVal = process.waitFor();

			if (exitVal == 0) {
				log.info("Scored code");
			} else {
				log.error("Error occurred while executing code");
				return null;
			}
		} catch (IOException | InterruptedException e) {
			log.error("Error occurred while executing code", e);
			return null;
		}

		List<Boolean> scoreResult = new ArrayList<>();

		for (int i = 0; i < outputList.size(); i++) {
			if (result.size() <= i) {
				System.out.println("null " + outputList.get(i));
				scoreResult.add(false);
				continue;
			}

			System.out.println(outputList.get(i) + " " + result.get(i));
			scoreResult.add(String.valueOf(outputList.get(i)).equals(result.get(i)));
		}

		return scoreResult;
	}

}
