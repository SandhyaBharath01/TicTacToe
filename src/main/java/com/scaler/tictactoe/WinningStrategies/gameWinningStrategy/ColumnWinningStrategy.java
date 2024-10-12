package com.scaler.tictactoe.WinningStrategies.gameWinningStrategy;

import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Move;
import com.scaler.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements GameWinningStartegy {
    Map<Integer, Map<Symbol, Integer>> colhm = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getPlayerSymbol();
        if(!colhm.containsKey(col)){
            colhm.put(col, new HashMap<>());
        }
        Map<Symbol,Integer> currentcolhm = colhm.get(col);
        if(!currentcolhm.containsKey(symbol)){
            currentcolhm.put(symbol,1);
        }else{
            currentcolhm.put(symbol, currentcolhm.get(symbol)+1);
        }
        return  currentcolhm.get(symbol)== board.getSize();
    }
}
