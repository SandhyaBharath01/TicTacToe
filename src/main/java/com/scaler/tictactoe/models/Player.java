package com.scaler.tictactoe.models;

import java.util.Scanner;

public abstract class Player {
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
}
