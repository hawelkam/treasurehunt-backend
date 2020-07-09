package com.michalhawelka.treasurehuntbackend.game.entities;

public class FinishedGame {
    String playerName;
    Integer rounds;

    public FinishedGame(String playerName, Integer rounds) {
        this.playerName = playerName;
        this.rounds = rounds;
    }

    public Integer getRounds() {
        return rounds;
    }

    public String getPlayerName() {
        return playerName;
    }
}
