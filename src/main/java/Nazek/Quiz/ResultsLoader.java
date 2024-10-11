package Nazek.Quiz;


import Question.QuestionModel;
import Question.QuestionRepository;
import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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

        /*
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/Data/OpenTRAVIA.json")){
               json = objectMapper.readValue(inputStream, JsonNode.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON data", e);
        }*/

        /*
        * fetch data from Internet URL and save data into json file.
        * To be refactored, instead : pass the (amount, difficulty ) as variables entered by the end-user from the front-end.
         * */
        try (BufferedInputStream in = new BufferedInputStream(new URL("https://opentdb.com/api.php?amount=15&category=18&difficulty=easy&type=multiple").openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/Data/Test.json")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println (e.toString());
        }

        // save results to database
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/Data/Test.json")){
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
