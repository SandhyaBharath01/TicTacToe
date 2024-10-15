package com.scaler.tictactoe.models;
import com.scaler.tictactoe.Exceptions.DuplicateSymbolException;
import com.scaler.tictactoe.Exceptions.InvalidBotCountException;
import com.scaler.tictactoe.Exceptions.InvalidPlayerCountException;
import com.scaler.tictactoe.WinningStrategies.gameWinningStrategy.ColumnWinningStrategy;
import com.scaler.tictactoe.WinningStrategies.gameWinningStrategy.DiagonalWinningStrategy;
import com.scaler.tictactoe.WinningStrategies.gameWinningStrategy.GameWinningStartegy;
import com.scaler.tictactoe.WinningStrategies.gameWinningStrategy.RowWinningStrategy;

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
    private GameState gameState;
    private  List<GameWinningStartegy> winningStrategies;


    private Game(int dimension, List<Player> players, List<GameWinningStartegy> winningStrategies){
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.gameState = GameState.INPROGRESS;
        this.winningStrategies = winningStrategies;

    }

    public List<GameWinningStartegy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<GameWinningStartegy> winningStrategies) {
        this.winningStrategies = winningStrategies;
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

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void displayBoard(){
        board.printBoard();
    }

    public boolean validateMove(Move move, Board board){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cell = board.getBoard().get(row).get(col);
        return row >= 0 && row <= board.getSize() &&
                col >= 0 && col <= board.getSize() &&
                cell.isEmpty();
    }

    public void makeMove(){
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("This is "+ currentPlayer.getName() + "'s turn");
        Move move = currentPlayer.makeMove(board);
        //validate if cell state is empty or not if empty on player can place the symbol
        validateMove(move,board);
        //if move is valid place the symbol on board
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setPlayer(currentPlayer);
        cell.setCellState(CellState.FILLED);

        Move finalMove = new Move(cell, currentPlayer);
        nextPlayerIndex += 1;
        nextPlayerIndex %= players.size();

        //check the winner
        if(checkWinner(board, finalMove)){
            gameState = GameState.WINNER;
            winner = currentPlayer;
        }else if(moves.size() == board.getSize() * board.getSize()){
            gameState = GameState.DRAW;
        }
    }
    private boolean checkWinner(Board board, Move move){
        //check all the game winning strategies
        for(GameWinningStartegy winningStartegy : winningStrategies){
            if(winningStartegy.checkWinner(board,move)) return true;
        }
        return false;
    }
    public void undo(){
        if(moves.isEmpty()){
            System.out.println("No moves are there to undo");
            return;
        }
        Move lastmove = moves.get(moves.size()-1);
        moves.remove(moves.size()-1);

        lastmove.getCell().setCellState(CellState.EMPTY);
        lastmove.getCell().setSym(null);

        nextPlayerIndex--;
        nextPlayerIndex = (nextPlayerIndex + players.size())%players.size();

        for(GameWinningStartegy strategies : winningStrategies){
            strategies.handleundofeature(board, lastmove);
        }
        setGameState(GameState.INPROGRESS);
        setWinner(null);
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
            return new Game(dimension, players, List.of(new RowWinningStrategy()
            , new ColumnWinningStrategy(), new DiagonalWinningStrategy()));
        }
    }
}

