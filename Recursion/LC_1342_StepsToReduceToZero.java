
/*
Problem: Number of Steps to Reduce a Number to Zero
Platform: LeetCode
Problem ID: 1342
Topic: Recursion
Difficulty: Easy
Link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

Description:
Given a non-negative integer, return the number of steps required
to reduce it to zero.
If the number is even, divide it by 2.
If the number is odd, subtract 1.

Approach (Recursion):
- Base case: If num == 0, return 0
- If num is even, recursively call with num / 2
- If num is odd, recursively call with num - 1
- Add 1 for each operation

Time Complexity: O(log n)
Space Complexity: O(log n)

Notes:
- Uses conditional (ternary) operator
- Demonstrates a single recursive call per step
*/

class LC_1342_StepsToReduceToZero {
    // find number of steps
    public static  int numberOfSteps(int num) {
        if (num == 0)
            return 0;
        return 1 + ((num % 2 == 0) ? numberOfSteps(num / 2) : numberOfSteps(num - 1));
    }
    // main function for testing
    public static void main(String[] args) {
        int num = 123;
        System.out.println(numberOfSteps(num));
    }
}