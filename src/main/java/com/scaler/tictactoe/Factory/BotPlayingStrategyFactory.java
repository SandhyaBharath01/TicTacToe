package com.scaler.tictactoe.Factory;

import com.scaler.tictactoe.WinningStrategies.BotPlayingStrategy.BotPlayingStrategy;
import com.scaler.tictactoe.WinningStrategies.BotPlayingStrategy.EastBotPlayingStrategy;
import com.scaler.tictactoe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new EastBotPlayingStrategy();
        }else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)){
            return new EastBotPlayingStrategy();
        }else if(botDifficultyLevel.equals((BotDifficultyLevel.HARD))){
            return new EastBotPlayingStrategy();
        }
        return null;
    }
}
