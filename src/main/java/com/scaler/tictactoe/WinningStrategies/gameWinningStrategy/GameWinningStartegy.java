package com.scaler.tictactoe.WinningStrategies.gameWinningStrategy;

import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Move;

public interface GameWinningStartegy {
    public boolean checkWinner(Board board, Move move);
    public void handleundofeature(Board board, Move move);
}
