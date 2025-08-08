package Controllers;

import Entities.QuestionModel;
import Services.QuestionsAnswersService;
import Services.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "/quiz", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionsAnswersController {


    @Autowired
    private QuestionsAnswersService questionService;

    @Autowired
    private DataLoader questionsLoader;

    @GetMapping(path= "/allQuestions")
    public ResponseEntity<List<QuestionModel>> getAllQuestions() {


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<QuestionModel> allQuestions = questionService.getAllQuestions();

        return new ResponseEntity<>(allQuestions, HttpStatus.OK);
    }

    @GetMapping(path = "/questionDetails/{questionId}")
    public ResponseEntity<Optional<QuestionModel>> getQuestionDetail(@PathVariable("questionId") int questionId){
        Optional<QuestionModel> question = questionService.getQuestionDetails(questionId);

        return new ResponseEntity<>(question, HttpStatus.OK);
    }



}
