package Nazek.Quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "Nazek.Quiz")
@EnableJpaRepositories(basePackages = "Question")
@EntityScan(basePackages = "Question")
@ComponentScan(basePackages = "Question")
@ComponentScan(basePackages = "Nazek.Quiz")
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	}
