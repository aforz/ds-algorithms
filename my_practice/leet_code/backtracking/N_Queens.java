package my_practice.leet_code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem: https://leetcode.com/problems/n-queens/
public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');
        backtrack(board, 0, res, n);
        return res;
    }

    private void backtrack(char[][] board, int row, List<List<String>> res, int n) {
        if (row == n) {
            res.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, res, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;
        // Check 45° diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;
        // Check 135° diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q') return false;
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board)
            res.add(new String(row));
        return res;
    }

    public static void main(String[] args) {
        N_Queens solver = new N_Queens();
        int n1 = 4;
        System.out.println("Solutions for " + n1 + "-Queens:");
        List<List<String>> solutions1 = solver.solveNQueens(n1);
        for (List<String> solution : solutions1) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }

        int n2 = 1;
        System.out.println("Solutions for " + n2 + "-Queens:");
        List<List<String>> solutions2 = solver.solveNQueens(n2);
        for (List<String> solution : solutions2) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
