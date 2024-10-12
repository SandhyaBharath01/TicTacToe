package com.scaler.tictactoe.WinningStrategies.gameWinningStrategy;

import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Move;
import com.scaler.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements GameWinningStartegy {

    Map<Integer, Map<Symbol, Integer>> rowhm = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getPlayerSymbol();
        if(!rowhm.containsKey(row)){
            rowhm.put(row, new HashMap<>());
        }
        Map<Symbol,Integer> currentrowhm = rowhm.get(row);
        if(!currentrowhm.containsKey(symbol)){
            currentrowhm.put(symbol,1);
        }else{
            currentrowhm.put(symbol, currentrowhm.get(symbol)+1);
        }
        return  currentrowhm.get(symbol)==board.getSize();
    }
}
