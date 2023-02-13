package quizApi.springbootrestapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quizApi.springbootrestapi.beans.GameState;
import quizApi.springbootrestapi.services.GameStateService;

@RestController
@CrossOrigin
public class GameStateController {

    @Autowired
    private GameStateService gameStateService;

    @GetMapping("/new-game")
    public ResponseEntity<GameState> newGame() {
        gameStateService.newGame();

        return ResponseEntity.ok(gameStateService.getGameState());
    }

    @GetMapping("/submit-answer")
    public ResponseEntity<GameState> submitAnswer(@RequestParam String answer) {
        gameStateService.checkAnswer(answer);

        return ResponseEntity.ok(gameStateService.getGameState());
    }

    @GetMapping("/time-out")
    public ResponseEntity<GameState> timeOut() {
        final GameState gameState = gameStateService.getGameState();
        gameState.setRound(0);

        return ResponseEntity.ok(gameState);
    }
}
