package br.com.taoshu.taoshu;

import br.com.taoshu.controller.ProfessorController;
import br.com.taoshu.entity.Aluno;
import br.com.taoshu.exception.ExceptionHandling;
import br.com.taoshu.repository.ProfessorRepository;
import br.com.taoshu.service.IProfessorService;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {ProfessorController.class, IProfessorService.class, ExceptionHandling.class})
@EntityScan(basePackageClasses = Aluno.class)
@EnableJpaRepositories(basePackageClasses = ProfessorRepository.class)
@Configuration
public class TaoshuApplication {

	private static final Logger logger = LoggerFactory.getLogger(TaoshuApplication.class);

	public static void main(String[] args) {
		logger.info("==== PREPARANDO PARA INICIAR API TAO SHU ====");
		SpringApplication.run(TaoshuApplication.class, args);
		logger.info("==== API TAO SHU INICIADA ====");
	}

	@Resource
	private Environment env;

	/*@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		logger.info("==== PREPARANDO A BASE DE DADOS ====");
		return DataSourceBuilder.create().build();
	}
*/

    @Bean
	public DataSource dataSource(
			@Value("${spring.datasource.driverClassName}") final String driverClass,
			@Value("${spring.datasource.url}") final String url,
			@Value("${spring.datasource.username}") final String username,
			@Value("${spring.datasource.password}") final String password
	) throws URISyntaxException {


		return DataSourceBuilder
				.create()
				.username(username)
				.password(password)
				.url(url)
				.driverClassName(driverClass)
				.build();
	}

}
