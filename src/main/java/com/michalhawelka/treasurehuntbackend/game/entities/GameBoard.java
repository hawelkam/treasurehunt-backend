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

    public void setCells(List<GameCell> cells) {
        this.cells = cells;
    }

    public int getRounds() {
        return rounds;
    }

    public void incrementRounds() {
        this.rounds += 1;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getTreasureFound() {
        return treasureFound;
    }

    public void setTreasureFound(int treasureFound) {
        this.treasureFound = treasureFound;
    }

    public void incrementTreasureFound() {
        this.treasureFound += 1;
    }
}
