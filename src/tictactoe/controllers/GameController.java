package tictactoe.controllers;

import tictactoe.exceptions.InvalidMoveException;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.models.enums.GameState;
import tictactoe.strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        return Game.getBuilder().setDimensions(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public boolean getcurrentPlayerBot(Game game) {
        return game.getcurrentPlayerBot();
    }
    public void undo(Game game) {
        // todo
    }
}
