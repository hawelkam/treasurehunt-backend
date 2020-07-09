package com.michalhawelka.treasurehuntbackend.game.controller;

import com.michalhawelka.treasurehuntbackend.game.dto.BoardUpdateDTO;
import com.michalhawelka.treasurehuntbackend.game.dto.CheckCellsDTO;
import com.michalhawelka.treasurehuntbackend.game.entities.FinishedGame;
import com.michalhawelka.treasurehuntbackend.game.entities.GameBoard;
import com.michalhawelka.treasurehuntbackend.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GameRestController {
    private GameService gameService;

    @Autowired
    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/board/{player}")
    public ResponseEntity<GameBoard> getUsersById(@PathVariable(value = "player") String playerName) {
        return ResponseEntity.ok().body(gameService.receiveBoard(playerName));
    }

    @PostMapping("/check")
    public BoardUpdateDTO createUser(@RequestBody CheckCellsDTO dto) {
        return gameService.checkCells(dto);
    }

    @GetMapping("/leaderboard")
    public List<FinishedGame> getLeaderboard() {
        return gameService.getLeaderboard();
    }
}
