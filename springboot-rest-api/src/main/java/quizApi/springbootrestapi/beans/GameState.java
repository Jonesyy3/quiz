package quizApi.springbootrestapi.beans;

import quizApi.springbootrestapi.models.DisneyCharacterModel;

import java.util.List;

public class GameState {
    private int round;
    private int score;
    private Question currentQuestion;
    private List<DisneyCharacterModel> characterData;

    public GameState(List<DisneyCharacterModel> characterData) {
        this.characterData = characterData;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public List<DisneyCharacterModel> getCharactersData() {
        return characterData;
    }

    public void setCharactersData(List<DisneyCharacterModel> characterData) {
        this.characterData = characterData;
    }
}
