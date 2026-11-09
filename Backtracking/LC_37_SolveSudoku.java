/*
Problem: Sudoku Solver
Platform: LeetCode
Problem ID: 37
Topic: Backtracking / Recursion
Difficulty: Hard
Link: https://leetcode.com/problems/sudoku-solver/

Description:
Write a program to solve a Sudoku puzzle by filling the empty cells.
Each empty cell must be filled with a digit from 1 to 9 such that
every row, column, and 3x3 subgrid contains all digits without repetition.

Approach (Backtracking):
- Traverse the board row by row and column by column
- Skip cells that are already filled
- Try digits from 1 to 9 in each empty cell
- Check whether the digit is safe to place
- Place the digit and recursively process the next cell
- Restore the cell to '.' if the recursive call fails
- Return true when the entire board is successfully filled

Safety Checks:
- Same row
- Same column
- Same 3x3 subgrid

Time Complexity: O(9^E), where E is the number of empty cells (worst case)
Space Complexity: O(E) for the recursion stack

Notes:
- Uses Choose -> Explore -> Unchoose
- Modifies the original board in place
- Uses recursion to traverse the Sudoku board
- Backtracks when a digit leads to an invalid solution
- Stops once a valid solution is found
*/
import java.util.Arrays;
public class LC_37_SolveSudoku {
    // function to call recursive function
    public static void solveSudoku(char[][] board) {
        placeNumber(board, 0, 0);
    }

    // function to recursively place numbers
    public static boolean placeNumber(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }
        if (col == board.length) {
            return placeNumber(board, row + 1, 0);
        }
        if (board[row][col] != '.') {
            return placeNumber(board, row, col + 1);
        }
        char[] nums = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        for (int i = 0; i < nums.length; i++) {
            if (isSafe(board, row, col, nums[i])) {
                board[row][col] = nums[i];
                if (!placeNumber(board, row, col + 1)) {
                    board[row][col] = '.';
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    // function to check if the current cell is safe
    public static boolean isSafe(char[][] board, int row, int col, char num) {
        // check row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        // check column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        // check square
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // main function for testing
    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        for (char[] row : board)
            System.out.println(Arrays.toString(row));
        solveSudoku(board);
        System.out.println();
        for (char[] row : board)
            System.out.println(Arrays.toString(row));
    }
}