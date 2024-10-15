package com.scaler.tictactoe.models;

import java.util.Scanner;

public class Player {
    private Long id;
    private String name;
    private PlayerType playerType;
    private Symbol playerSymbol;
    private Scanner scanner;

    public Player(Long id, String name, PlayerType playerType, Symbol playerSymbol) {
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.playerSymbol = playerSymbol;
        scanner = new Scanner(System.in);
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

    public Move makeMove(Board board) {
        System.out.println("Please enter row number");
        int row = scanner.nextInt();

        System.out.println("Please enter column number");
        int col = scanner.nextInt();

        return new Move(new Cell(row,col),this);
    }
}
