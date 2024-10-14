package Question;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface QuizDetailsRepository extends JpaRepository<QuizModel, Long> {

    QuizModel findFirstByOrderByIdDesc();

}
