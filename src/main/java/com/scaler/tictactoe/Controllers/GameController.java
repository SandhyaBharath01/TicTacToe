package com.scaler.tictactoe.Controllers;

import com.scaler.tictactoe.Exceptions.DuplicateSymbolException;
import com.scaler.tictactoe.Exceptions.InvalidBotCountException;
import com.scaler.tictactoe.Exceptions.InvalidPlayerCountException;
import com.scaler.tictactoe.models.Game;
import com.scaler.tictactoe.models.Player;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players) throws InvalidBotCountException, DuplicateSymbolException, InvalidPlayerCountException {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                . Build();
    }
    public void makeMove(Game game){

    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void undo(Game game){

    }
    public void displayBoard(Game game){
        game.displayBoard();
    }

}
