package tictactoe.strategies.winningStrategy;

import tictactoe.models.Board;
import tictactoe.models.Move;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        HashMap<Character, Integer> leftDiagonalMap = new HashMap<>();
        HashMap<Character, Integer> rightDiagonalMap = new HashMap<>();

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character aChar = move.getPlayer().getSymbol().getaChar();

        if(row == col) {
            leftDiagonalMap.put(aChar, leftDiagonalMap.getOrDefault(aChar, 0) + 1);
            if(leftDiagonalMap.get(aChar).equals(board.getDimensions())) {
                return true;
            }
        }

        if(row + col == board.getDimensions()-1) {
            rightDiagonalMap.put(aChar, rightDiagonalMap.getOrDefault(aChar, 0) + 1);
            return rightDiagonalMap.get(aChar).equals(board.getDimensions());
        }
        return false;
    }
}
