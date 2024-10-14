package Question;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/quiz", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionController {

    @Autowired
    private  QuestionService questionService;

    @Autowired
    private  QuizService quizService;

    // Aggregate root
    @GetMapping(path= "/allQuestions")
    public ResponseEntity<List<QuestionModel>> getAllQuestions() {
        List<QuestionModel> allQuestions = questionService.getAllQuestions();

            return new ResponseEntity<>(allQuestions, HttpStatus.OK);
    }

    @PostMapping(path= "/quizDetails")
    public ResponseEntity<QuizModel> postQuiz(@RequestBody QuizModel quizDetails) {
        QuizModel quiz= quizService.postQuizDetails(quizDetails);

        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }
}
