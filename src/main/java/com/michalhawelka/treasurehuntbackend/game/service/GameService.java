package com.michalhawelka.treasurehuntbackend.game.service;

import com.michalhawelka.treasurehuntbackend.game.dto.CheckCellsDTO;
import com.michalhawelka.treasurehuntbackend.game.dto.BoardUpdateDTO;
import com.michalhawelka.treasurehuntbackend.game.entities.FinishedGame;
import com.michalhawelka.treasurehuntbackend.game.entities.GameBoard;
import com.michalhawelka.treasurehuntbackend.game.entities.GameCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GameService {
    Map<String, GameBoard> playerMap;
    List<FinishedGame> leaderboard;
    List<String> values = new ArrayList<>(
            List.of("2", "3", "2", "3", "T",
                    "3", "T", "3", "2", "3",
                    "2", "3", "2", "3", "2",
                    "1", "1", "3", "T", "3",
                    "1", "1", "2", "3", "2"));

    @Autowired
    public GameService(Map<String, GameBoard> playerMap, List<FinishedGame> leaderboard) {
        this.playerMap = playerMap;
        this.leaderboard = leaderboard;
    }

    public GameBoard receiveBoard(String playerName) {
        if (playerMap.containsKey(playerName)) {
            return playerMap.get(playerName);
        } else {
            GameBoard emptyBoard = prepareEmptyBoard();
            playerMap.put(playerName, emptyBoard);
            return emptyBoard;
        }
    }

    public BoardUpdateDTO checkCells(CheckCellsDTO dto) {
        BoardUpdateDTO resultDTO = new BoardUpdateDTO();
        GameBoard gb = playerMap.get(dto.getPlayerName());
        dto.getCells().forEach(cell -> {
            int cellIndex = cell - 1;
            gb.getCells().get(cellIndex).setValue(values.get(cellIndex));
            if ("T".equals(values.get(cellIndex))) {
                gb.incrementTreasureFound();
                resultDTO.setTreasuresFound(gb.getTreasureFound());
            }
            resultDTO.getCellValues().add(gb.getCells().get(cellIndex));
        });
        gb.incrementRounds();
        resultDTO.setRound(gb.getRounds());
        if (gb.getTreasureFound() == 3) {
            resultDTO.setFinished(true);
            handleFinishedGame(gb, dto.getPlayerName());
        }
        return resultDTO;
    }

    public List<FinishedGame> getLeaderboard() {
        return leaderboard.stream()
                .sorted(Comparator.comparingInt(FinishedGame::getRounds))
                .limit(10)
                .collect(Collectors.toList());
    }

    private void handleFinishedGame(GameBoard gb, String playerName) {
        leaderboard.add(new FinishedGame(playerName, gb.getRounds()));
        playerMap.remove(playerName);
    }

    private GameBoard prepareEmptyBoard() {
        List<GameCell> cells = new ArrayList<>();
        for(int i = 1; i <= 25; i++) {
            cells.add(new GameCell(i));
        }
        return new GameBoard(cells);
    }
}
