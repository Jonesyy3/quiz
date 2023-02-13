package quizApi.springbootrestapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import quizApi.springbootrestapi.beans.GameState;
import quizApi.springbootrestapi.beans.Question;
import quizApi.springbootrestapi.models.DisneyApiModel;
import quizApi.springbootrestapi.models.DisneyCharacterModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameStateService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    private GameState gameState;

    public void newGame() {
        DisneyApiModel chracterData;
        try {
            chracterData = this.getData();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        final GameState gameState = new GameState(chracterData.getData());
        setQuestion(gameState);
        setGameState(gameState);
    }

    private DisneyApiModel getData() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.disneyapi.dev/characters";
        String json = restTemplate.getForObject(url, String.class);

        DisneyApiModel disneyApi = objectMapper.readValue(json, DisneyApiModel.class);

        return disneyApi;
    }

    public void checkAnswer(String answer) {
        if (this.gameState.getCurrentQuestion().getAnswer().equals(answer)) {
            this.gameState.setScore(this.gameState.getScore() + 1);
        }

        if (this.gameState.getRound() < 10) {
            setQuestion(this.gameState);
        } else {
            endGame(this.gameState);
        }
    }

    private void endGame(GameState gameState) {
        gameState.setRound(0);
    }

    /**
     * Generates 4 random characters from our potential list
     * pick one of them to be the correct answer and take the respective image
     * @param gameState
     */
    public void setQuestion(GameState gameState) {

        final Random rand = new Random();
        final List<String> possibleAnswers = new ArrayList<>();
        final int answerIndex = rand.nextInt(4);
        int count = gameState.getCharactersData().size();
        String answer = "";
        String imgUrl = "";
        if (count >= 4) {
            for (int i = 0; i < 4; i++) {
                final int randomNum = rand.nextInt(count);
                final DisneyCharacterModel disneyCharacterModel = gameState.getCharactersData().get(randomNum); // maybe remove model in name?
                possibleAnswers.add(disneyCharacterModel.name);
                if (i == answerIndex) {
                    imgUrl = disneyCharacterModel.imageUrl;
                    answer = disneyCharacterModel.name;
                    gameState.getCharactersData().remove(randomNum);
                    count--;
                }
            }
        }

        Question question = new Question("Who is this character?", imgUrl, possibleAnswers, answer);
        gameState.setCurrentQuestion(question);
        gameState.setRound(gameState.getRound() + 1);
    }
}
