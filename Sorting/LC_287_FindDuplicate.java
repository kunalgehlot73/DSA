/*
Problem: Find the Duplicate Number
Platform: LeetCode
Problem ID: 287
Topic: Arrays / Cyclic Sort
Difficulty: Medium
Link: https://leetcode.com/problems/find-the-duplicate-number/

Description:
Given an array of n + 1 integers where each integer is in the range [1, n],
find the duplicate number without using extra space.

Approach (Cyclic Sort):
- Each value belongs at index (value - 1)
- Traverse the array and place each element at its correct index
- If the target index already contains the same value,
  that value is the duplicate
- Otherwise, swap until every possible element is placed correctly

Time Complexity: O(n)
Space Complexity: O(1)

Notes:
- Uses index mapping (value → value - 1)
- Modifies the input array
- LeetCode also has an optimal solution using Floyd's Cycle Detection
  that does not modify the array
*/

class LC_287_FindDuplicate {

    // find duplicate
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (i != correctIndex) {
                if (nums[i] == nums[correctIndex]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        return -1;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] nums = { 3, 3, 3, 3, 3, 3 };
        System.out.println(findDuplicate(nums));
    }
}