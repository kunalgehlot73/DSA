/*
Problem: Find Numbers with Even Number of Digits
Platform: LeetCode
Problem ID: 1295
Topic: Arrays
Difficulty: Easy
Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

Description:
Given an array of integers, return how many numbers contain an even number of digits.

Approach 1 (Iterative):
- Count digits by repeatedly dividing the number by 10
- Check if digit count is even

Time Complexity: O(n * d)
Space Complexity: O(1)

Approach 2 (Logarithmic):
- Use log10 to calculate number of digits
- digits = floor(log10(num)) + 1

Time Complexity: O(n)
Space Complexity: O(1)

Notes:
- Logarithmic approach is more optimized
*/

class LC_1295_EvenDigits {

    // Iterative Approach
    public static int findNumbersIteration(int[] nums) {
        int num;
        int digit;
        int count = 0;
        for (int i : nums) {
            num = i;
            digit = 0;
            while (num > 0) {
                num /= 10;
                digit++;
            }
            if (0 == digit % 2) {
                count++;
            }
        }
        return count;
    }

    // Logarithmic Approach
    public static int findNumbersLog(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (((int) Math.log10(num) + 1) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7896 };
        System.out.println(findNumbersIteration(nums));
        System.out.println(findNumbersLog(nums));
    }
}