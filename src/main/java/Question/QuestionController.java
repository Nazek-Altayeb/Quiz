package Question;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/questions", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionController {

    @Autowired
    private  QuestionService questionService;

    // Aggregate root
    @GetMapping(path= "/allQuestions")
    public ResponseEntity<List<QuestionModel>> getAllQuestions() {
        List<QuestionModel> allQuestions = questionService.getAllQuestions();
            return new ResponseEntity<>(allQuestions, HttpStatus.OK);
    }

}
