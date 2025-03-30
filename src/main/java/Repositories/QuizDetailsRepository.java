package Repositories;

import Entities.QuizModel;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface QuizDetailsRepository extends ListCrudRepository<QuizModel, Serializable> {
}
