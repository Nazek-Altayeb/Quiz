package Question;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Component
public class QuestionsLoader {

    private final ObjectMapper objectMapper;
    @Autowired
    private final QuestionRepository questionRepository;

    @Autowired
    private  QuestionService questionService;

    @Autowired
    private final QuizService quizService;

    public QuestionsLoader(ObjectMapper objectMapper, QuestionRepository questionRepository, QuizService quizService) {
        this.objectMapper = objectMapper;
        this.questionRepository = questionRepository;
        this.quizService = quizService;
    }
    public void ResetQuestionsList(){

        questionService.removeAll();
    }

    public void ResetQuizDetails(){
        quizService.DeleteDetails();
    }
    public void downloadQuestions() {
        //this.ResetQuestionsList();

        List<QuestionModel> questions = new ArrayList<>();
        JsonNode json;
        String category = quizService.GetQuizDetails().getCategory();
        String difficulty = quizService.GetQuizDetails().getDifficulty();


        try (BufferedInputStream in = new BufferedInputStream(new URL("https://opentdb.com/api.php?amount=10&category="+category+"&difficulty="+difficulty+"&type=multiple").openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/Data/OpenTrivia.json")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            // save results to database
            InputStream inputStream = new FileInputStream("src/main/resources/Data/OpenTrivia.json");
                json = objectMapper.readValue(inputStream, JsonNode.class);


            JsonNode results = getResults(json);
            for (JsonNode result : results) {
                questions.add(createQuestionFromNode(result));
            }
        } catch (IOException e) {
            System.out.println (e.toString());
        }



        questionRepository.saveAll(questions);
        //this.ResetQuizDetails();
    }
    private JsonNode getResults(JsonNode json) {
        return Optional.ofNullable(json)
                .map(j -> j.get("results"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid JSON Object"));
    }

    private QuestionModel createQuestionFromNode(JsonNode result) {
        String question = result.get("question").asText();
        String category = result.get("category").asText();
        String difficulty = result.get("difficulty").asText();
        String correct_answer = result.get("correct_answer").asText();
        String[] incorrect_answers = new String[3];
        Iterator<JsonNode> iterator = result.withArray("incorrect_answers").elements();
        int count =0;
        while (iterator.hasNext()) {
            incorrect_answers[count] = iterator.next().asText();
            count ++;
        }

        return new QuestionModel(difficulty,category, question, correct_answer, incorrect_answers);
    }
}
