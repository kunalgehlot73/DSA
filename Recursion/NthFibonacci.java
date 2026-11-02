/*
Problem: Fibonacci Number
Topic: Recursion
Approach: Multiple Recursive Calls

Description:
Find the nth Fibonacci number.
The first two Fibonacci numbers are 0 and 1.
Each subsequent number is the sum of the previous two numbers.

Approach:
- Base case: Return n when n is 0 or 1
- Recursive case: Add fibonacci(n - 1) and fibonacci(n - 2)

Time Complexity: O(2^n) approximately
Space Complexity: O(n) due to the recursion stack

Notes:
- Demonstrates multiple recursive calls
- Recalculates previously computed values
- Can be optimized using memoization or dynamic programming
*/
class NthFibonacci {
    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        int num = 10;
        for (int i = 0; i < num; i++) {
            System.out.println(fibonacci(i));
        }
    }
}