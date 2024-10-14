package Question;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface QuizRepository extends ListCrudRepository<QuizModel, Serializable> {

}
