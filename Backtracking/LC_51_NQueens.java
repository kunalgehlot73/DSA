
/*
Problem: N-Queens
Platform: LeetCode
Problem ID: 51
Topic: Backtracking / Recursion
Difficulty: Hard
Link: https://leetcode.com/problems/n-queens/

Description:
Place n queens on an n x n chessboard such that no two queens attack each other.
Return all distinct valid board configurations.

Approach (Backtracking):
- Place exactly one queen in each row
- Try every column in the current row
- Check whether the position is safe
- Place the queen and recursively process the next row
- Remove the queen when returning from recursion
- Save the board when all n queens are placed

Safety Checks:
- Same column
- Upper-left diagonal
- Upper-right diagonal

Time Complexity: O(n * n!) upper bound
Space Complexity: O(n^2) for the board, plus O(n) recursion stack

Notes:
- Uses Choose -> Explore -> Unchoose
- Only checks previously processed rows
- One queen is placed per row
- Demonstrates constraint-based backtracking
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LC_51_NQueens {
    // function to save a board
    public static void saveBoard(char[][] board, List<List<String>> ans) {
        List<String> listStr = new ArrayList<>();
        for (char[] r : board) {
            String row = "";
            for (char c : r) {
                row += c;
            }
            listStr.add(row);
        }
        ans.add(listStr);
    }

    // recursive function that places queens on safe squares
    public static void placeQueens(char[][] board, List<List<String>> ans, int row) {
        if (row == board.length){
            saveBoard(board, ans);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                placeQueens(board, ans, row+1);
                board[row][col] = '.';
            }
        }
    }

    // function to check if a square is safe
    public static boolean isSafe(char[][] board, int row, int col) {
        // check column
        for(int i = 0; i < row; i++){
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // check left diagonal
        for(int i = 1; i <= Math.min(row,col); i++) {
            if (board[row-i][col-i] == 'Q') {
                return false;
            }
        }
        // check right diagonal
        for(int i = 1; i <= Math.min(row,board[0].length - col - 1); i++) {
            if (board[row-i][col+i] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // function to init empty board and return the answer list
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] r : board) {
            Arrays.fill(r, '.');
        }
        placeQueens(board, ans, 0);
        return ans;
    }

    // main function for testing
    public static void main(String[] args) {
        int n = 9;
        List<List<String>> ans = solveNQueens(n);
        for (List<String> i : ans) {
            System.out.println(i.toString());
        }
    }
}