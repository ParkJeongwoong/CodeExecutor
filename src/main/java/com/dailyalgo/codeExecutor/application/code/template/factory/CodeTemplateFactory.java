package com.dailyalgo.codeExecutor.application.code.template.factory;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dailyalgo.codeExecutor.application.code.template.CTemplate;
import com.dailyalgo.codeExecutor.application.code.template.CodeTemplate;
import com.dailyalgo.codeExecutor.application.code.template.CppTemplate;
import com.dailyalgo.codeExecutor.application.code.template.JavaScriptTemplate;
import com.dailyalgo.codeExecutor.application.code.template.JavaTemplate;
import com.dailyalgo.codeExecutor.application.code.template.PythonScoreTemplate;
import com.dailyalgo.codeExecutor.application.code.template.PythonTemplate;
import com.dailyalgo.codeExecutor.application.code.template.ScoreTemplate;

public enum CodeTemplateFactory {

	C("c", CTemplate::new, null),
	CPP("cpp", CppTemplate::new, null),
	JAVA("java", JavaTemplate::new, null),
	PYTHON("python", PythonTemplate::new, PythonScoreTemplate::new),
	JAVASCRIPT("javascript", JavaScriptTemplate::new, null),
	;

	private static final Map<String, CodeTemplateFactory> FACTORY_MAPPER = Stream.of(values())
			.collect(Collectors.toUnmodifiableMap(factory -> factory.language, Function.identity()));

	private final String language;
	private final TriFunction<String, List<String>, String, CodeTemplate> runTemplateBuilder;
	private final PentaFunction<String, List<String>, String, List<List<String>>, List<String>, ScoreTemplate> scoreTemplateBuilder;

	CodeTemplateFactory(
			String language,
			TriFunction<String, List<String>, String, CodeTemplate> runTemplateBuilder,
			PentaFunction<String, List<String>, String, List<List<String>>, List<String>, ScoreTemplate> scoreTemplateBuilder
	) {
		this.language = language;
		this.runTemplateBuilder = runTemplateBuilder;
		this.scoreTemplateBuilder = scoreTemplateBuilder;
	}

	public CodeTemplate buildRunTemplate(String code, List<String> inputType, String outputType) {
		return this.runTemplateBuilder.apply(code, inputType, outputType);
	}

	public ScoreTemplate buildScoreTemplate(
			String code,
			List<String> inputType,
			String outputType,
			List<List<String>> input,
			List<String> output
	) {
		return this.scoreTemplateBuilder.apply(code, inputType, outputType, input, output);
	}

	public static CodeTemplateFactory from(String language) {
		return Optional.ofNullable(FACTORY_MAPPER.get(language))
				.orElseThrow(() -> new IllegalArgumentException("해당 언어에 대한 코드 템플릿이 없습니다."));
	}

}
