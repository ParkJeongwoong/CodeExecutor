package com.dailyalgo.codeExecutor.application.code.template;

import java.util.List;

public class PythonScoreTemplate extends PythonTemplate implements ScoreTemplate {

	public PythonScoreTemplate(String code, List inputType, String outputType, List<List> input, List output) {
		super(code, inputType, outputType);
		input.forEach(this.input::add);
		output.forEach(this.output::add);
	}

	@Override
	public String getTemplate() {
		code = super.code.replaceAll("print\\(.*\\)", "");

		stringBuilder
			.append(code).append(System.lineSeparator())
			.append("if __name__ == \"__main__\":").append(System.lineSeparator())
			.append("    inputList = []").append(System.lineSeparator());
		for (int i = 0; i < input.size(); i++) {
			stringBuilder.append("    inputList.append([");
			for (int j = 0; j < input.get(i).size(); j++) {
				if (inputType.get(j).equals("str")) {
					stringBuilder.append("\"").append(input.get(i).get(j)).append("\"");
				} else {
					stringBuilder.append(inputType.get(j)).append("(").append(input.get(i).get(j)).append(")");
				}
				if (j != input.get(i).size() - 1) {
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
	public ProcessBuilder getProcessBuilder() {
		return new ProcessBuilder("python", "score.py");
	}

}
