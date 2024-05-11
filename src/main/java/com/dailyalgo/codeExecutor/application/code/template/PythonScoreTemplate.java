package com.dailyalgo.codeExecutor.application.code.template;

import java.util.ArrayList;
import java.util.List;

public class PythonScoreTemplate extends PythonTemplate implements ScoreTemplate {

	private final List<List<String>> input = new ArrayList<>();
	private final List<String> output = new ArrayList<>();

	public PythonScoreTemplate(String code, List<String> inputType, String outputType, List<List<String>> input, List<String> output) {
		super(code, inputType, outputType);
		this.input.addAll(input);
		this.output.addAll(output);
	}

	@Override
	public String getTemplate() {
		code = super.code.replaceAll("print\\(.*\\)", "");

		stringBuilder
			.append(code).append(System.lineSeparator())
			.append("if __name__ == \"__main__\":").append(System.lineSeparator())
			.append("    inputList = []").append(System.lineSeparator());
		for (List<String> strings : input) {
			stringBuilder.append("    inputList.append([");
			for (int j = 0; j < strings.size(); j++) {
				if (inputType.get(j).equals("str")) {
					stringBuilder.append("\"").append(strings.get(j)).append("\"");
				} else {
					stringBuilder.append(inputType.get(j)).append("(").append(strings.get(j))
						.append(")");
				}
				if (j != strings.size() - 1) {
					stringBuilder.append(", ");
				}
			}
			stringBuilder.append("])").append(System.lineSeparator());
		}
		stringBuilder
			.append("    for i in range(").append(input.size()).append("):").append(System.lineSeparator())
			.append("        print(solution(");
		for (int i = 0; i < inputType.size(); i++) {
			stringBuilder.append("inputList[i][").append(i).append("]");
			if (i != inputType.size() - 1) {
				stringBuilder.append(", ");
			}
		}
		stringBuilder.append("))").append(System.lineSeparator());
		return stringBuilder.toString();
	}

	@Override
	public String getFileName() {
		return "Score.py";
	}

	@Override
	public ProcessBuilder getProcessBuilder() {
		return new ProcessBuilder("python3", "Score.py");
	}

}
