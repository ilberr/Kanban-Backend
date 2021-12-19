package org.rygn.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class springfoxconfiguration {
	private final BuildProperties buildProperties;
	
	@Autowired
	public springfoxconfiguration(BuildProperties buildProperties) {
		this.buildProperties = buildProperties;
	}
	
	@Bean
	public ApiInfo info() {
		
		return new ApiInfoBuilder().title(buildProperties.getName()).version(buildProperties.getVersion())
	            .description(buildProperties.get("description"))
	            .contact(new Contact("Test Developper","","test@test.fr"))
	            .build();	
	}
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.rygn.kanban"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(info());
	}

}
