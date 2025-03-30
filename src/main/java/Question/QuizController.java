package Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping(path = "/quiz", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuizController {

    @Autowired
    private  QuizService quizService;

    @Autowired
    private QuestionsLoader questionsLoader;

    @PostMapping(path= "/quizDetails")
    public ResponseEntity<QuizModel> postQuiz(@RequestBody QuizModel quizDetails) {

        QuizModel quiz= quizService.postQuizDetails(quizDetails);

        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        questionsLoader.downloadQuestions();

        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }

    @GetMapping(path= "/getQuizDetails")
    public ResponseEntity<QuizModel> getQuiz() {
        QuizModel quiz= quizService.GetQuizDetails();

        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }


}
