package Repositories;

import Entities.QuestionModel;
import org.springframework.data.repository.ListCrudRepository;

import java.io.Serializable;

public interface QuestionsAnswersRepository extends ListCrudRepository<QuestionModel, Serializable> {}
