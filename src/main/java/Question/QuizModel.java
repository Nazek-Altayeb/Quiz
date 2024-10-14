package Question;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuizModel {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    int id;
    String difficulty;
    String category;
    Number amountOfQuestions;

    public QuizModel(){}

    public QuizModel(String difficulty, String category, Number amountOfQuestions) {
        this.difficulty = difficulty;
        this.category = category;
        this.amountOfQuestions = amountOfQuestions;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Number getAmountOfQuestions() {
        return amountOfQuestions;
    }

    public void setAmountOfQuestions(Number amountOfQuestions) {
        this.amountOfQuestions = amountOfQuestions;
    }

    }

