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
public class QuestionController {

    @Autowired
    private  QuestionService questionService;

    @Autowired
    private QuestionsLoader questionsLoader;


    // Aggregate root
    @GetMapping(path= "/allQuestions")
    public ResponseEntity<List<QuestionModel>> getAllQuestions() {
       questionsLoader.downloadQuestions();

        // set a timer for few seconds
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<QuestionModel> allQuestions = questionService.getAllQuestions();

            return new ResponseEntity<>(allQuestions, HttpStatus.OK);
    }


    @DeleteMapping(path= "/DeleteAllQuestion")
    public  ResponseEntity<?> deleteAllQuestions() {
        questionService.removeAll();
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
