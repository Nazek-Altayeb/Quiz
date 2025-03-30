package Services;

import Entities.QuizModel;
import Repositories.QuizDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizDetailsService {
    @Autowired
    private QuizDetailsRepository quizDetailsRepository;

    public QuizModel postQuizDetails(QuizModel quizDetails){ return quizDetailsRepository.save(quizDetails);}
    public QuizModel GetQuizDetails(){ return quizDetailsRepository.findAll().getLast();}
}
