package br.com.taoshu.taoshu;

import br.com.taoshu.config.SwaggerConfig;
import br.com.taoshu.resource.ProfessorResource;
import br.com.taoshu.entity.Aluno;
import br.com.taoshu.exception.ExceptionHandling;
import br.com.taoshu.repository.ProfessorRepository;
import br.com.taoshu.service.ProfessorService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;


@SpringBootApplication
@ComponentScan(basePackageClasses = {ProfessorResource.class, ProfessorService.class, ExceptionHandling.class, SwaggerConfig.class})
@EntityScan(basePackageClasses = Aluno.class)
@EnableJpaRepositories(basePackageClasses = ProfessorRepository.class)
@Configuration
@Slf4j
public class TaoshuApplication{

	public static void main(String[] args) {
		SpringApplication.run(TaoshuApplication.class, args);
	}

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		return new Jackson2ObjectMapperBuilder() {

			@Override
			public void configure(ObjectMapper objectMapper) {
				super.configure(objectMapper);
				objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
			}

		};

	}

}
