package Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private  QuizRepository quizRepository;

    public QuizModel postQuizDetails(QuizModel quizDetails){ return quizRepository.save(quizDetails);}
    public QuizModel GetQuizDetails(){ return quizRepository.findAll().getLast();}

}
