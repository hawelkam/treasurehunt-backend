package com.michalhawelka.treasurehuntbackend.game.entities;

import java.util.List;

public class GameBoard {
    List<GameCell> cells;
    int rounds = 0;
    int treasureFound = 0;

    public GameBoard(List<GameCell> cells) {
        this.cells = cells;
    }

    public List<GameCell> getCells() {
        return cells;
    }

    public int getRounds() {
        return rounds;
    }

    public int incrementRounds() {
        this.rounds += 1;
        return this.rounds;
    }

    public int getTreasureFound() {
        return treasureFound;
    }

    public int incrementTreasureFound() {
        this.treasureFound += 1;
        return this.treasureFound;
    }
}
