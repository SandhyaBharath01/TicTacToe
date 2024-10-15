package com.scaler.tictactoe.models;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;
    private Symbol sym;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
        this.sym = null;
    }

    public Symbol getSym() {
        return sym;
    }

    public void setSym(Symbol sym) {
        this.sym = sym;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

//    public Symbol getSym() {
//        return sym;
//    }
//
//    public void setSym(Symbol sym) {
//        this.sym = sym;
//    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public boolean isEmpty(){
        return this.cellState.equals(CellState.EMPTY);
    }
}
