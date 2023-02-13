package quizApi.springbootrestapi.beans;

import java.util.List;

public class Question {
    private String question;
    private String imageUrl;
    private List<String> answerOptions;
    private String answer;

    public Question(String question, String imageUrl, List<String> answerOptions, String answer) {
        this.question = question;
        this.imageUrl = imageUrl;
        this.answerOptions = answerOptions;
        this.answer = answer;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<String> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
