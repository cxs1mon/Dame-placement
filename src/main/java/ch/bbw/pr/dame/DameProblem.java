package ch.bbw.pr.dame;

/**
 * DameProbelm
 *
 * @author Peter Rutschmann
 * @version 07.11.2019
 */
public class DameProblem {
    public static final int FIELD_FREE = 0;
    public static final int FIELD_OCCUPIED = 1;

    private int size;
    private int[][] board;

    public int[][] getBoard() {
        return board;
    }

    public DameProblem(int size) {
        super();
        this.size = size;
        this.board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = FIELD_FREE;
            }
        }
    }

    public boolean setQueen(int row) {
        if (row >= size) {
            return true;
        }
        for (int col = 0; col < size; col++) {
            if (isValid(row, col)) {
                board[row][col] = FIELD_OCCUPIED;
                if (setQueen(row + 1)) {
                    return true;
                } else {
                    board[row][col] = FIELD_FREE;
                }
            }
        }
        return false;
    }


    private boolean isValid(int r, int c) {
        int i, j;

        for (i = 0; i < r; i++) {

            if (board[i][c] == FIELD_OCCUPIED) {
                return false;
            }
        }
        i = r - 1;
        j = c - 1;
        while ((i >= 0) && (j >= 0)) {
            if (board[i--][j--] == FIELD_OCCUPIED) {
                return false;
            }
        }

        i = r - 1;
        j = c + 1;
        while ((i >= 0) && (j < size)) {
            if (board[i--][j++] == FIELD_OCCUPIED) {
                return false;
            }
        }
        return true;
    }
}







