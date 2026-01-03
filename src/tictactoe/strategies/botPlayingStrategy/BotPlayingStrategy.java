package tictactoe.strategies.botPlayingStrategy;

import tictactoe.models.Board;
import tictactoe.models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
