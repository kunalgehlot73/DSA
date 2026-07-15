/*
Problem: Find All Duplicates in an Array
Platform: LeetCode
Problem ID: 442
Topic: Arrays / Cyclic Sort
Difficulty: Medium
Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/

Description:
Given an integer array where 1 ≤ nums[i] ≤ n (n = array length),
some elements appear twice and others appear once.
Return all elements that appear exactly twice.

Approach (Cyclic Sort):
- Place every element at its correct index (value - 1)
- Swap until every possible element reaches its correct position
- Skip swapping when the correct position already contains the same value
- After rearranging, every index i where nums[i] != i + 1
  indicates that nums[i] is a duplicate

Time Complexity: O(n)
Space Complexity: O(1)
(Excluding the output list)

Notes:
- Uses index mapping (value → value - 1)
- Handles duplicate values safely
- Another classic application of Cyclic Sort
*/

import java.util.ArrayList;
import java.util.List;

class LC_442_FindAllDuplicates {

    // find all duplicates
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
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
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDuplicates(nums));
    }
}