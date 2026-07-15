/*
Problem: First Missing Positive
Platform: LeetCode
Problem ID: 41
Topic: Arrays / Cyclic Sort
Difficulty: Hard
Link: https://leetcode.com/problems/first-missing-positive/

Description:
Given an unsorted integer array, find the smallest missing positive integer.
The solution must run in O(n) time and use O(1) extra space.

Approach (Cyclic Sort):
- Only numbers in the range [1, n] can affect the answer
- Ignore negative numbers, zero, and values greater than n
- Place each valid number at its correct index (value - 1)
- Skip swapping when the correct position already contains the same value
- After rearranging, the first index i where nums[i] != i + 1
  represents the smallest missing positive
- If every position is correct, return n + 1

Time Complexity: O(n)
Space Complexity: O(1)

Notes:
- Classic Cyclic Sort application
- Handles duplicates and invalid values safely
- One of the most important array interview problems
*/

class LC_41_FirstMissingPositive {

    // find first missing positive
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] nums = { 4, 3, -1, 1 };
        System.out.println(firstMissingPositive(nums));
    }
}