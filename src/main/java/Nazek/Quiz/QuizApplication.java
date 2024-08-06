package Nazek.Quiz;

import Question.Question;
import Question.QuestionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.PrintStream;
import java.util.List;

import Question.QuestionController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "Nazek.Quiz")
@EnableJpaRepositories(basePackages = "Question")
@EntityScan(basePackages = "Question")
@ComponentScan(basePackages = "Question")
public class QuizApplication {
	// private QuestionRepository questionRepository;

	/*public QuizApplication() {
	}*/
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}
		/*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Question> questions = entityManager.createQuery("SELECT q FROM Question q").getResultList();
		PrintStream printstr = System.out;
		if (questions == null) {
			System.out.println("No questions found . ");
		} else {
			for (Question ques : questions){
				printstr.println("Question= " + ques.getQuestion() + ", Question id " + ques.getId());
			}

		}

		entityManager.close();
		entityManagerFactory.close();*/

}
