/*
Problem: Find First and Last Position of Element in Sorted Array
Platform: LeetCode
Problem ID: 34
Topic: Arrays / Binary Search
Difficulty: Medium
Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Description:
Given a sorted array of integers, find the starting and ending position of a target value.
If the target is not found, return [-1, -1].

Approach (Binary Search - First & Last Occurrence):
- Perform binary search twice:
  1. Find first occurrence:
     - On match → move left (end = mid - 1)
  2. Find last occurrence:
     - On match → move right (st = mid + 1)
- Store index when match is found
- Return both indices

Time Complexity: O(log n)
Space Complexity: O(1)

Notes:
- Key idea: continue searching even after finding target
- This is a variation of lower bound and upper bound
- Single function reused with a boolean flag (findStart)
*/

import java.util.Arrays;

class LC_34_SearchRange {

    // search for first or last occurence depending on the boolean findStart
    public static int search(int[] nums, int target, boolean findStart) {
        int st = 0, end = nums.length - 1, mid;
        int ans = -1;
        while (st <= end) {
            mid = st + (end - st) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                st = mid + 1;
            } else {
                if (findStart) {
                    end = mid - 1;
                    ans = mid;
                } else {
                    st = mid + 1;
                    ans = mid;
                }
            }
        }
        return ans;
    }

    // function to return array of searchRange
    public static int[] searchRange(int[] nums, int target) {
        return new int[] { search(nums, target, true), search(nums, target, false) };
    }

    // main function for testing
    public static void main(String[] args) {
        int[] nums = { 8, 8, 8, 8, 8, 8, 8, 10 };
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
