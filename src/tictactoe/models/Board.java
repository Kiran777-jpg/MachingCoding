package tictactoe.models;

import tictactoe.models.enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimensions;
    private List<List<Cell>> board;

    public Board(int dimensions) {
        this.dimensions = dimensions;

        for(int i=0;i<dimensions;i++) {
            board.add(new ArrayList<>());

            for(int j=0;j<dimensions;j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void printBoard() {
        for(List<Cell> row : board) {
            for(Cell cell : row) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    System.out.print("| - |");
                } else {
                    System.out.print("| " + cell.getPlayer().getSymbol().getaChar() + " |");
                }
            }
        }
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
