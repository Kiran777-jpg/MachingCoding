package tictactoe.models;

import java.util.List;

public class Board {
    private int dimnensions;
    private List<List<Cell>> board;

    public int getDimnensions() {
        return dimnensions;
    }

    public void setDimnensions(int dimnensions) {
        this.dimnensions = dimnensions;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
