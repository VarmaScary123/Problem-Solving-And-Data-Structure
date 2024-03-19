/*
    Sudoku problem

    Each test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents
    empty block.

    Output Format
    For each test case, in a new line, print the space separated values of the solution of the the sudoku.
    Constraints
    1 <= board[] <= 9

    Sample Input 1 : 3 0 6 5 0 8 4 0 0                 3 1 6 5 7 8 4 9 2
                     5 2 0 0 0 0 0 0 0                 5 2 9 1 3 4 7 6 8
                     0 8 7 0 0 0 0 3 1                 4 8 7 6 2 9 5 3 1
                     0 0 3 0 1 0 0 8 0                 2 6 3 4 1 5 9 8 7
                     9 0 0 8 6 3 0 0 5        ==>      9 7 4 8 6 3 1 2 5
                     0 5 0 0 9 0 6 0 0                 8 5 1 7 9 2 6 4 3
                     1 3 0 0 0 0 2 5 0                 1 3 8 9 4 7 2 5 6
                     0 0 0 0 0 0 0 0 0                 6 9 2 3 5 1 8 7 4
                     0 0 5 2 0 6 3 0 0                 7 4 5 2 8 6 3 1 9

    Sample Input 2 : 0 0 0 7 0 0 0 0 0
                     1 0 0 0 0 0 0 0 0
                     0 0 0 4 3 0 2 0 0
                     0 0 0 0 0 0 0 0 6
                     0 0 0 5 0 9 0 0 0        ==>      No Solution
                     0 0 0 0 0 0 4 1 8
                     0 0 0 0 8 1 0 0 0
                     0 0 2 0 0 0 5 0 0
                     0 4 0 0 0 0 3 0 0
 */

package Backtracking;

public class SudokuSolver {

    private static long startTime;

    public static boolean isSafe(int row, int col, int[][] board, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num
                    || board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num)
                return false;
        }
        return true;
    }

    public static boolean sudokuSolver(int[][] board, int timer) {
        startTime = System.currentTimeMillis();
        return sudokuHelper(board, timer);
    }

    public static boolean sudokuHelper(int[][] board, int timer) {

        if (System.currentTimeMillis() - startTime > timer)
            return false;

        int[] nextEmptyCell = findNextEmptyCell(board);

        int row = nextEmptyCell[0];
        int col = nextEmptyCell[1];

        if (row == -1 && col == -1) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(row, col, board, i)) {
                board[row][col] = i;
                if (sudokuHelper(board, timer)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static int[] findNextEmptyCell(int[][] board) {
        int result[] = new int[2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        result[0] = -1;
        result[1] = -1;

        return result;
    }

    public static void display(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String arg[]) {
        int[][] board = new int[][] {
                { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 4, 3, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 6 },
                { 0, 0, 0, 5, 0, 9, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 4, 1, 8 },
                { 0, 0, 0, 0, 8, 1, 0, 0, 0 },
                { 0, 0, 2, 0, 0, 0, 5, 0, 0 },
                { 0, 4, 0, 0, 0, 0, 3, 0, 0 }
        };

        int timer = 900;
        if (sudokuSolver(board, timer)) {
            display(board);
        } else {
            System.out.println("No Solution");
        }

    }

}