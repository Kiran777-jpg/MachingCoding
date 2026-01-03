package tictactoe.models;

import tictactoe.exceptions.InvalidMoveException;
import tictactoe.models.enums.CellState;
import tictactoe.models.enums.GameState;
import tictactoe.models.enums.PlayerType;
import tictactoe.strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;

    public static Builder getBuilder() {
        return new Builder();
    }

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextMovePlayerIndex = 0;
        this.winningStrategies = winningStrategies;
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextMovePlayerIndex);
        System.out.println("This is " + currentPlayer.getName() + "'s move.");

        // Player chooses the move
        Move move = currentPlayer.makeMove(board);

        // validate the move
        if(!validateMove(move)) {
            throw new InvalidMoveException("Invalid move, please retry");
        }

        // move is valid, add to board
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        Move finalMove =new Move(cell, currentPlayer);
        moves.add(finalMove);

        if(checkWinner(finalMove)) {
            winner = currentPlayer;
            gameState = GameState.ENDED;
        } else if(moves.size() == (board.getDimensions() * board.getDimensions())) {
            gameState = GameState.DRAW;
        }

        nextMovePlayerIndex = (nextMovePlayerIndex + 1)%players.size();
    }

    public boolean checkWinner(Move move) {
        for(WinningStrategy winningStrategy : winningStrategies) {
            if(winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    public boolean getcurrentPlayerBot() {
        if(players != null) {
            return players.get(nextMovePlayerIndex).getPlayerType().equals(PlayerType.BOT);
        }
        return false;
    }


    public void printBoard() {
        board.printBoard();
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

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row < 0 || row >= board.getDimensions() || col < 0 || col >= board.getDimensions()) {
            return false;
        }

        if(!board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            return false;
        }

        return true;
    }

    public static class Builder {

        private int dimensions;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        private Builder() {
            this.dimensions = 0;
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }

        public Game build() {
            return new Game(dimensions, players, winningStrategies);
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
    }
}
