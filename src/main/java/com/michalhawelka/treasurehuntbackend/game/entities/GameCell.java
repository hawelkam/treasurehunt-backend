package com.michalhawelka.treasurehuntbackend.game.entities;

public class GameCell {
    int id;
    String value = "";

    public GameCell(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
