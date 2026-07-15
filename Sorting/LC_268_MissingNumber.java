/*
Problem: Missing Number
Platform: LeetCode
Problem ID: 268
Topic: Arrays / Cyclic Sort
Difficulty: Easy
Link: https://leetcode.com/problems/missing-number/

Description:
Given an array containing n distinct numbers in the range [0, n],
find the only missing number.

Approach (Cyclic Sort):
- Place every number at its correct index (value -> index)
- Ignore the value n since it has no valid index in the array
- After rearranging, the first index where nums[i] != i
  is the missing number
- If every index contains the correct value, the missing
  number is n

Time Complexity: O(n)
Space Complexity: O(1)

Notes:
- Uses Cyclic Sort because each number has a unique target index
- Skip value n as it lies outside the valid index range [0, n-1]
*/

class LC_268_MissingNumber {

    // find missing number
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int correctIndex;
        int i = 0;
        while (i < n) {
            correctIndex = nums[i];
            if (nums[i] < n && i != correctIndex) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (i = 0; i < n; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return n;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(missingNumber(nums));
    }
}