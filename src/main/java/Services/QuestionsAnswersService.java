package Services;

import Entities.QuestionModel;
import Repositories.QuestionsAnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsAnswersService {

    @Autowired
    private QuestionsAnswersRepository questionsAnswersRepository;

    public List<QuestionModel> getAllQuestions(){
        return questionsAnswersRepository.findAll();
    }
    public void  removeAll() { questionsAnswersRepository.deleteAll();}
    public Optional<QuestionModel> getQuestionDetails(int questionId){
        return  questionsAnswersRepository.findById(questionId);
    }
}
