package com.boilerplate.springboot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 주소 : /swagger-ui/index.html
@OpenAPIDefinition(
	info = @io.swagger.v3.oas.annotations.info.Info(
		title = "Spring Boot Boilerplate",
		version = "1.0.0",
		description = "Boilerplate for Spring Boot Application"
))
@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
			.group("boilerplate")
			.pathsToMatch("/**")
			.build();
	}

}
