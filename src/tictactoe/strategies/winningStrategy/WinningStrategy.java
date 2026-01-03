package tictactoe.strategies.winningStrategy;

import tictactoe.models.Board;
import tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
