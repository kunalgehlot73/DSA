/*
Problem: Find All Numbers Disappeared in an Array
Platform: LeetCode
Problem ID: 448
Topic: Arrays / Cyclic Sort
Difficulty: Easy
Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Description:
Given an array of integers where 1 ≤ nums[i] ≤ n (n = array length),
some elements appear twice while others appear once.
Return all numbers in the range [1, n] that do not appear in the array.

Approach (Cyclic Sort):
- Place every number at its correct index (value - 1)
- Skip swapping when:
  - the number is already at its correct position, or
  - the correct position already contains the same value (duplicate)
- After rearranging, every index i where nums[i] != i + 1
  represents a missing number (i + 1)

Time Complexity: O(n)
Space Complexity: O(1)
(Excluding the output list)

Notes:
- Handles duplicate values safely
- Uses index mapping (value → value - 1)
- One of the classic applications of Cyclic Sort
*/

import java.util.ArrayList;
import java.util.List;

class LC_448_FindDisappearedNumbers {

    // find missing numbers
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (i != correctIndex && nums[correctIndex] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (i = 0; i < n; i++) {
            if (i + 1 != nums[i]) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDisappearedNumbers(nums));
    }
}