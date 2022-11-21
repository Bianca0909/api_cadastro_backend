package br.com.dvtisul.persistencia.configuration;

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
public class SpringfoxConfig {

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.dvtisul.persistencia.resource"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API para persistência de clientes e cidades").description("Trabalho avaliativo final para a conclusão do curso DEVTISUL \n" + "API criada em JAVA Spring")
				.version("1.0.0").license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.contact(new Contact("Bianca Medeiros", "https://github.com/Bianca0909", "biancamedeiros0909@gmail.com"))
				.build();
	}
}
