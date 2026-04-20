/*
Problem: Search in Rotated Sorted Array
Platform: LeetCode
Problem ID: 33
Topic: Arrays / Binary Search
Difficulty: Medium
Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

Description:
Given a rotated sorted array and a target value, return its index if found,
otherwise return -1.

Approach (Binary Search on Rotated Array):
- Use binary search
- At each step, determine which half is sorted:
  - If nums[low] <= nums[mid] → left half is sorted
  - Else → right half is sorted
- Check if target lies in sorted half:
  - If yes → search there
  - Else → search other half

Time Complexity: O(log n)
Space Complexity: O(1)

Notes:
- Key idea: one half is always sorted
- Avoid linear search (must be O(log n))
*/

class LC_33_SearchRotatedSortedArray {
    // search rotated array
    public static int search(int[] nums, int target) {
        int st = 0, end = nums.length - 1, mid;
        while (st <= end) {
            mid = st + (end - st) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[st] <= nums[mid]) {
                if (nums[st] <= target && target <= nums[mid])
                    end = mid - 1;
                else
                    st = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[end])
                    st = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(search(nums, 0));
    }
}
