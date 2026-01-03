package tictactoe.models;

public interface WinningStrategy {
    boolean checkWinner(Board board,  Move move);
}
