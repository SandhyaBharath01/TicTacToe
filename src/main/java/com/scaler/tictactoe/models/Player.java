package com.scaler.tictactoe.models;

import java.util.Scanner;

public class Player {
    private Long id;
    private String name;
    private PlayerType playerType;
    private Symbol playerSymbol;

    public Player(Long id, String name, PlayerType playerType, Symbol playerSymbol) {
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.playerSymbol = playerSymbol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(Symbol playerSymbol) {
        this.playerSymbol = playerSymbol;
    }
}
