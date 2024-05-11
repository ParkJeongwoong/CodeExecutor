package com.dailyalgo.codeExecutor.application.code.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.dailyalgo.codeExecutor.application.code.template.CodeTemplate;
import com.dailyalgo.codeExecutor.application.code.template.ScoreTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CodeFileManager {

	public void saveRunCodes(String path, CodeTemplate runTemplate, String language) {
		createFile(path, runTemplate.getFileName(), runTemplate.getTemplate());

		if (language.equals("java")) {
			createFile(path, "Solution.java", runTemplate.getCode());
		}
	}

	public void saveScoreCodes(String path, ScoreTemplate scoreTemplate, String language) {
		createFile(path, scoreTemplate.getFileName(), scoreTemplate.getTemplate());

		if (language.equals("java")) {
			createFile(path, "Solution.java", scoreTemplate.getCode());
		}
	}

	private void createFile(String path, String fileName, String content) {
		File file = new File(path + "/" + fileName);

		try {
			if (!createDirectory(path)) {
				throw new IOException("Error occurred while creating directory");
			}

			if (file.exists() && !file.delete()) {
				throw new IOException("Error occurred while deleting file");
			}

			if (file.createNewFile()) {
				log.info("File created: {}", file.getName());

				BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				writer.write(content);
				writer.newLine();
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			log.error("Error occurred while saving file", e);
		}
	}

	private boolean createDirectory(String path) {
		File file = new File(path);

		if (file.exists()) {
			return true;
		}

		if (file.mkdirs()) {
			log.info("Directory created: {}", file.getName());
			return true;
		}

		log.error("Error occurred while creating directory");
		return false;
	}

}
