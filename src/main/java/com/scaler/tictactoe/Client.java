package com.scaler.tictactoe;


import com.scaler.tictactoe.Controllers.GameController;
import com.scaler.tictactoe.Exceptions.DuplicateSymbolException;
import com.scaler.tictactoe.Exceptions.InvalidBotCountException;
import com.scaler.tictactoe.Exceptions.InvalidPlayerCountException;
import com.scaler.tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, DuplicateSymbolException, InvalidPlayerCountException {
        System.out.println("Welcome to TicTacToe!");
        Scanner scn = new Scanner(System.in);
        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        players.add(
                new Player(1L, "Sandhya", PlayerType.BOT, new Symbol('X'))
        );
        players.add(
                new Bot(2L, "Bot",PlayerType.BOT, new Symbol('O'), BotDifficultyLevel.EASY)
        );
        Game game = gameController.startGame(
                3,
                players
        );
        gameController.displayBoard(game) ;
    }
}
