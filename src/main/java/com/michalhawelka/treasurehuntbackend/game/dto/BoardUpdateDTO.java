package com.michalhawelka.treasurehuntbackend.game.dto;

import com.michalhawelka.treasurehuntbackend.game.entities.GameCell;

import java.util.ArrayList;
import java.util.List;

public class BoardUpdateDTO {
    List<GameCell> cellValues = new ArrayList<>();
    Integer treasuresFound;
    Integer round;
    Boolean isFinished;

    public List<GameCell> getCellValues() {
        return cellValues;
    }

    public void setCellValues(List<GameCell> cellValues) {
        this.cellValues = cellValues;
    }

    public Integer getTreasuresFound() {
        return treasuresFound;
    }

    public void setTreasuresFound(Integer treasuresFound) {
        this.treasuresFound = treasuresFound;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }
}
