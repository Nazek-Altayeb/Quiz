package Controllers;

import Services.DataLoader;
import Entities.QuizModel;
import Services.QuizDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/quiz", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuizController {

    @Autowired
    private QuizDetailsService quizService;

    @Autowired
    private DataLoader questionsLoader;

    @PostMapping(path= "/quizDetails")
    public ResponseEntity<QuizModel> postQuiz(@RequestBody QuizModel quizDetails) {

        QuizModel quiz= quizService.postQuizDetails(quizDetails);

        questionsLoader.downloadQuestions();

        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }


}
