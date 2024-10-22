package Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private  QuestionRepository questionRepository;

    public List<QuestionModel> getAllQuestions(){
        return questionRepository.findAll();
    }
    public void  removeAll() { questionRepository.deleteAll();}

}
