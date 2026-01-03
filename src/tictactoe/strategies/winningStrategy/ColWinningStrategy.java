package tictactoe.strategies.winningStrategy;

import tictactoe.models.Board;
import tictactoe.models.Move;

import java.util.HashMap;

public class ColWinningStrategy implements WinningStrategy{

    private final HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Character aChar = move.getPlayer().getSymbol().getaChar();

        colMaps.putIfAbsent(col, new HashMap<>());
        HashMap<Character, Integer> currColMap = colMaps.get(col);
        currColMap.put(aChar, currColMap.getOrDefault(aChar, 0) + 1);
        return currColMap.get(aChar).equals(board.getDimensions());
    }
}
