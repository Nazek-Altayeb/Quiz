package Question;

import java.io.Serializable;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

/*@Repository
public interface QuestionRepository extends JpaRepository<Question, Serializable> {

}*/

@Repository
public interface QuestionRepository extends ListCrudRepository<QuestionModel, Serializable> {

}

