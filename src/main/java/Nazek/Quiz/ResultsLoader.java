package Nazek.Quiz;


import Question.QuestionModel;
import Question.QuestionRepository;
import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component
public class ResultsLoader implements CommandLineRunner {


    private final ObjectMapper objectMapper;
    @Autowired
    private final QuestionRepository questionRepository;

    public ResultsLoader(ObjectMapper objectMapper, QuestionRepository questionRepository) {
        this.objectMapper = objectMapper;
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) {
        List<QuestionModel> questions = new ArrayList<>();

        JsonNode json;

        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/Data/OpenTRIVIA_Response.json")) {
            json = objectMapper.readValue(inputStream, JsonNode.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON data", e);
        }

        JsonNode results = getResults(json);
        for (JsonNode result : results) {
            questions.add(createQuestionFromNode(result));
        }

        questionRepository.saveAll(questions);
    }

    private JsonNode getResults(JsonNode json) {
        return Optional.ofNullable(json)
                .map(j -> j.get("results"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid JSON Object"));
    }

    private QuestionModel createQuestionFromNode(JsonNode result) {
        JsonNode node = result.get("node");
        String question = node.get("question").asText();
        String category = node.get("category").asText();
        String difficulty = node.get("difficulty").asText();
        String correct_answer = node.get("correct_answer").asText();

        return new QuestionModel(difficulty,category, question, correct_answer);
    }

}
