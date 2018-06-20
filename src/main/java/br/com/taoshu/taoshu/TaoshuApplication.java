package br.com.taoshu.taoshu;

import br.com.taoshu.controller.ProfessorController;
import br.com.taoshu.entity.Aluno;
import br.com.taoshu.exception.ExceptionHandling;
import br.com.taoshu.repository.ProfessorRepository;
import br.com.taoshu.service.IProfessorService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {ProfessorController.class, IProfessorService.class, ExceptionHandling.class})
@EntityScan(basePackageClasses = Aluno.class)
@EnableJpaRepositories(basePackageClasses = ProfessorRepository.class)
@Configuration
@Slf4j
public class TaoshuApplication{

	public static void main(String[] args) {
		log.info("==== PREPARANDO PARA INICIAR API TAO SHU ====");
		SpringApplication.run(TaoshuApplication.class, args);
		log.info("==== API TAO SHU INICIADA ====");
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
