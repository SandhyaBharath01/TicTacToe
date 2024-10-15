package com.scaler.tictactoe.WinningStrategies.gameWinningStrategy;

import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Move;
import com.scaler.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements GameWinningStartegy {
    Map<Symbol, Integer> leftDiagonalmap = new HashMap<>();
    Map<Symbol, Integer> rightDiagonalmap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getPlayerSymbol();
        if(row==col){
            if(!leftDiagonalmap.containsKey(symbol)){
                leftDiagonalmap.put(symbol,1);
            }else{
                leftDiagonalmap.put(symbol, leftDiagonalmap.get(symbol)+1);
            }
            if(leftDiagonalmap.get(symbol)== board.getSize()) return true;
        }
        if(row+col== board.getSize()-1){
            if(!rightDiagonalmap.containsKey(symbol)){
                rightDiagonalmap.put(symbol,1);
            }else{
                rightDiagonalmap.put(symbol,rightDiagonalmap.get(symbol)+1);
            }
            if(rightDiagonalmap.get(symbol)==board.getSize()) return true;
        }
        return false;
    }
    @Override
    public void handleundofeature(Board board, Move move){
//        int left = move.getCell().getRow();
//        int right = move.getCell().getCol();
//        Symbol sym = move.getPlayer().getPlayerSymbol();
//        leftDiagonalmap.get(left).put(sym,leftDiagonalmap.get(left).get(sym)-1);
    }
}
