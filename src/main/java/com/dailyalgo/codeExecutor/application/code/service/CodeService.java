package com.dailyalgo.codeExecutor.application.code.service;

import com.dailyalgo.codeExecutor.application.code.dto.RunCodeResponseDto;
import com.dailyalgo.codeExecutor.application.code.dto.ScoreCodeResponseDto;
import com.dailyalgo.codeExecutor.application.code.template.CodeTemplate;
import com.dailyalgo.codeExecutor.application.code.template.JavaTemplate;
import com.dailyalgo.codeExecutor.application.code.template.PythonScoreTemplate;
import com.dailyalgo.codeExecutor.application.code.template.PythonTemplate;
import com.dailyalgo.codeExecutor.application.code.template.ScoreTemplate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CodeService {

	public RunCodeResponseDto runCode(String code, String language, String outputType) {
		CodeTemplate codeTemplate = getCodeTemplate(code, language, outputType);
		if (codeTemplate == null) {
			return new RunCodeResponseDto("Template not found");
		}
		saveFile("./code/run"+codeTemplate.getFileType(), codeTemplate.getTemplate());
		codeTemplate.compile(); // java only
		String result = executeCode(codeTemplate.getProcessBuilder());
		return new RunCodeResponseDto(result);
	}

	public ScoreCodeResponseDto scoreCode(String code, String language, List inputType, String outputType, List input, List output) {
		ScoreTemplate scoreTemplate = getScoreTemplate(code, language, inputType, outputType, input, output);
		if (scoreTemplate == null) {
			return new ScoreCodeResponseDto(null).setResult(false, "Template not found");
		}
		saveFile("./code/score"+scoreTemplate.getFileType(), scoreTemplate.getTemplate());
		scoreTemplate.compile(); // java only
		List result = score(scoreTemplate.getProcessBuilder(), output);
		return new ScoreCodeResponseDto(result).setResult(true, "Success");
	}

	private CodeTemplate getCodeTemplate(String code, String language, String outputType) {
		CodeTemplate codeTemplate = null;
		if (language.equals("python")) {
			codeTemplate = new PythonTemplate(code, null, "");
		}
		else if (language.equals("java")) {
			codeTemplate = new JavaTemplate(code, null, outputType);
		}
		return codeTemplate;
	}

	private ScoreTemplate getScoreTemplate(String code, String language, List inputType, String outputType, List input, List output) {
		ScoreTemplate codeTemplate = null;
		if (language.equals("python")) {
			codeTemplate = new PythonScoreTemplate(code, inputType, outputType, input, output);
		}
		return codeTemplate;
	}

	private void saveFile(String path, String code) {
		File file = new File(path);
		try {
			if (file.exists()) {
				if (!file.delete()) {
					throw new IOException("Error occurred while deleting file");
				}
			}
			if (file.createNewFile()) {
				log.info("File created: {}", file.getName());

				BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				writer.write(code);
				writer.newLine();
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			log.error("Error occurred while saving file", e);
		}
	}

	private String executeCode(ProcessBuilder processBuilder) {
		String result = "";
		try {
			log.info("Executing code");
			processBuilder.directory(new File("./code"));
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

	private List<Boolean> score(ProcessBuilder processBuilder, List outputList) {
		List<String> result = new ArrayList<>();
		try {
			log.info("Score code");
			processBuilder.directory(new File("./code"));
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
