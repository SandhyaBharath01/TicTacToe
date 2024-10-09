package com.scaler.tictactoe.models;

public class Symbol {
    private char sym;
//    private String color;

    public Symbol(char sym){
        this.sym = sym;
    }
    public char getSym() {
        return sym;
    }

    public void setSym(char sym) {
        this.sym = sym;
    }

}
