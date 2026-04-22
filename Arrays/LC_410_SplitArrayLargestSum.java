/*
Problem: Split Array Largest Sum
Platform: LeetCode
Problem ID: 410
Topic: Arrays / Binary Search
Difficulty: Hard
Link: https://leetcode.com/problems/split-array-largest-sum/

Description:
Given an integer array nums and an integer k, split the array into k or fewer
subarrays such that the largest sum among these subarrays is minimized.
Return this minimized largest sum.

Approach (Binary Search on Answer):
- Search range:
  - low = max element in array
  - high = sum of all elements
- For a given mid (candidate max sum):
  - Check if we can split array into ≤ k subarrays
    such that no subarray sum exceeds mid
- If possible → try smaller value (high = mid)
- Else → increase limit (low = mid + 1)

Time Complexity: O(n * log(sum))
Space Complexity: O(1)

Notes:
- This is a classic “minimize the maximum” problem
- Greedy + binary search on answer space
*/

class LC_410_SplitArrayLargestSum {
    
    // method to check if the possible answer can split the array in k parts
    public static boolean isValid(int[] nums, int max, int k) {
        int count = 1;
        int currSum = 0;
        for (int i : nums) {
            if (currSum + i <= max) {
                currSum += i;
            } else {
                count++;
                currSum = i;
            }
        }
        return (count <= k);
    }

    //  method to find the minimum maximized sum of split array
    public static int splitArray(int[] nums, int k) {
        int minSum = Integer.MIN_VALUE, maxSum = 0;
        for (int i : nums) {
            maxSum += i;
            if (i > minSum)
                minSum = i;
        }
        while (minSum < maxSum) {
            int mid = minSum + (maxSum - minSum) / 2;
            if (isValid(nums, mid, k))
                maxSum = mid;
            else
                minSum = mid + 1;
        }
        return minSum;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;
        System.out.println(splitArray(nums, k));
    }
}
