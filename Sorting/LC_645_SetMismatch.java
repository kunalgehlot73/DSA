/*
Problem: Set Mismatch
Platform: LeetCode
Problem ID: 645
Topic: Arrays / Cyclic Sort
Difficulty: Easy
Link: https://leetcode.com/problems/set-mismatch/

Description:
You are given an array containing numbers from 1 to n.
One number appears twice, and one number is missing.
Return the duplicate number and the missing number.

Approach (Cyclic Sort):
- Place every number at its correct index (value - 1)
- Swap elements until every possible value is in its correct position
- Skip swapping when the correct position already contains the same value
- After rearranging:
  - nums[i] represents the duplicate
  - i + 1 represents the missing number
  whenever nums[i] != i + 1

Time Complexity: O(n)
Space Complexity: O(1)

Notes:
- Uses index mapping (value → value - 1)
- Combines duplicate detection and missing number identification
- Classic Cyclic Sort application
*/

import java.util.Arrays;

class LC_645_SetMismatch {

    // find duplicate and missing
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return new int[] { nums[i], i + 1 };
            }
        }
        return new int[] { -1, -1 };
    }

    // main function for testing
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4 };
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
}