package com.scaler.tictactoe.WinningStrategies.BotPlayingStrategy;

import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Cell;
import com.scaler.tictactoe.models.Move;

import java.util.List;

public class EastBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board board) {
        for(List<Cell> cells : board.getBoard()){
            for(Cell cell : cells){
                if(cell.isEmpty()){
                    return new Move(cell, null);
                }
            }
        }
        return null;
    }
}
