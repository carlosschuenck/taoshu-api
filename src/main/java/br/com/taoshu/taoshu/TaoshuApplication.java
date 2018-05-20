package br.com.taoshu.taoshu;

import br.com.taoshu.controller.ProfessorController;
import br.com.taoshu.entity.Aluno;
import br.com.taoshu.exception.ExceptionHandling;
import br.com.taoshu.repository.ProfessorRepository;
import br.com.taoshu.service.IProfessorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sql.DataSource;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {ProfessorController.class, IProfessorService.class, ExceptionHandling.class})
@EntityScan(basePackageClasses = Aluno.class)
@EnableJpaRepositories(basePackageClasses = ProfessorRepository.class)
public class TaoshuApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaoshuApplication.class, args);
	}

	@Resource
	private Environment env;



	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource customDataSource() {
		return DataSourceBuilder.create().build();
	}
}
