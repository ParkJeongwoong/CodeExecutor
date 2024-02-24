package com.dailyalgo.codeExecutor.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 주소 : /swagger-ui/index.html
@OpenAPIDefinition(
	info = @io.swagger.v3.oas.annotations.info.Info(
		title = "Code Executor",
		version = "1.0.0",
		description = "Code Executor Project API 문서"
))
@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
			.group("dailyalgo")
			.pathsToMatch("/**")
			.build();
	}

}
