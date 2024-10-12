package com.scaler.tictactoe.models;
import com.scaler.tictactoe.Exceptions.DuplicateSymbolException;
import com.scaler.tictactoe.Exceptions.InvalidBotCountException;
import com.scaler.tictactoe.Exceptions.InvalidPlayerCountException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private int nextPlayerIndex;

//    public Game(Board board, List<Player> players, List<Move> moves, Player winner, int nextPlayerIndex) {
//        this.board = board;
//        this.players = players;
//        this.moves = moves;
//        this.winner = winner;
//        this.nextPlayerIndex = nextPlayerIndex;
//    }
    private Game(int dimension, List<Player> players){
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;

    }
    public static Builder getBuilder(){
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }
    public void displayBoard(){
        board.printBoard();
    }
    public static class Builder{
        private int dimension;
        private List<Player> players;

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private void validateCount() throws InvalidPlayerCountException {
            //Number of players should be boardsize()-1
            if(players.size()!=dimension-1){
                throw new InvalidPlayerCountException("Players must be dimention-1");
            }
        }
        private void validateSymbol() throws DuplicateSymbolException {
            //No 2 players should have same symbol
            Map<Character, Integer> hm = new HashMap<>();
            for(Player player : players) {
                if (!hm.containsKey(player.getPlayerSymbol().getSym())) {
                    hm.put(player.getPlayerSymbol().getSym(), 1);
                } else {
                    hm.put(player.getPlayerSymbol().getSym(),
                            hm.get(player.getPlayerSymbol().getSym()) + 1);
                }
                if(hm.get(player.getPlayerSymbol().getSym())>1){
                    throw new DuplicateSymbolException("No 2 players should have same symbol");
                }
            }
        }
        private void validateBot() throws InvalidBotCountException {
            //There must be only one bot
            int botCount = 0;
            for(Player player: players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
                if(botCount>1){
                    throw new InvalidBotCountException("There must be only one Bot");
                }
            }
        }
        public void validateGame(int dimension, List<Player> players) throws InvalidPlayerCountException, InvalidBotCountException, DuplicateSymbolException {
            validateCount();
            validateSymbol();
            validateBot();
        }
        public Game Build() throws InvalidPlayerCountException, InvalidBotCountException, DuplicateSymbolException {
            validateGame(dimension,players);
            return new Game(dimension, players);
        }
    }
}

