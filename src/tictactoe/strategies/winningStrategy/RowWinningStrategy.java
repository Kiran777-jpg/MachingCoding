package tictactoe.strategies.winningStrategy;

import tictactoe.models.Board;
import tictactoe.models.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{

    private final HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Character aChar = move.getPlayer().getSymbol().getaChar();
        if(!rowMaps.containsKey(row)) {
            rowMaps.put(row, new HashMap<>());
        }
        HashMap<Character, Integer> currRowMap = rowMaps.get(row);
        if(!currRowMap.containsKey(aChar)) {
            currRowMap.put(aChar, 0);
        }
        currRowMap.put(aChar, currRowMap.get(aChar) + 1);
        return currRowMap.get(aChar).equals(board.getDimensions());
    }
}
