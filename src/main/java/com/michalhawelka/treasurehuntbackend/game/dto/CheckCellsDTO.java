package com.michalhawelka.treasurehuntbackend.game.dto;

import java.util.List;

public class CheckCellsDTO {
    List<Integer> cells;
    String playerName;

    public List<Integer> getCells() {
        return cells;
    }

    public String getPlayerName() {
        return playerName;
    }
}
