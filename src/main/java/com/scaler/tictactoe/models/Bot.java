package com.scaler.tictactoe.models;

import com.scaler.tictactoe.Factory.BotPlayingStrategyFactory;
import com.scaler.tictactoe.WinningStrategies.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Long id, String name, PlayerType playerType, Symbol playerSymbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, playerType, playerSymbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

}
