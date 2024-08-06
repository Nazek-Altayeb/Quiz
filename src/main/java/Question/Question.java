package Question;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int Id;
    private String Question;
    private String Category;
    private String Difficulty;
    private String Answer;
    private String Option1;
    private String Option2;
    private String Option3;

    public Question() {
    }

    public Question(String question, String category, String difficulty, String answer, String option1, String option2, String option3) {
        this.Question = question;
        this.Category = category;
        this.Difficulty = difficulty;
        this.Answer = answer;
        this.Option1 = option1;
        this.Option2 = option2;
        this.Option3 = option3;
    }

    public String toString() {
        return String.format("Question[id=%d, question='%s', category='%s', difficulty='%s', answer='%s, option1=%s', option2=%s', option3=%s']", this.Question, this.Question, this.Category, this.Difficulty, this.Answer, this.Option1, this.Option2, this.Option3);
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setQuestion(String question) {
        this.Question = question;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public void setDifficulty(String difficulty) {
        this.Difficulty = difficulty;
    }

    public void setAnswer(String answer) {
        this.Answer = answer;
    }

    public void setOption1(String option1) {
        this.Option1 = option1;
    }

    public void setOption2(String option2) {
        this.Option2 = option2;
    }

    public void setOption3(String option3) {
        this.Option3 = option3;
    }

    public int getId() {
        return this.Id;
    }

    public String getQuestion() {
        return this.Question;
    }

    public String getCategory() {
        return this.Category;
    }

    public String getDifficulty() {
        return this.Difficulty;
    }

    public String getAnswer() {
        return this.Answer;
    }

    public String getOption1() {
        return this.Option1;
    }

    public String getOption2() {
        return this.Option2;
    }

    public String getOption3() {
        return this.Option3;
    }
}
