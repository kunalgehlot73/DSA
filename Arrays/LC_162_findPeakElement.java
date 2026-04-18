/*
Problem: Find Peak Element
Platform: LeetCode
Problem ID: 162
Topic: Arrays / Binary Search
Difficulty: Medium
Link: https://leetcode.com/problems/find-peak-element/

Description:
A peak element is an element strictly greater than its neighbors.
Given an array, return the index of any peak element.

Approach (Binary Search):
- Use binary search with condition low < high
- Compare nums[mid] with nums[mid + 1]:
  - If nums[mid] > nums[mid + 1] → peak lies on left (including mid)
  - Else → peak lies on right
- Continue until low == high
- Return low (index of peak)

Time Complexity: O(log n)
Space Complexity: O(1)

Notes:
- Multiple peaks may exist → return any one
- No need to check both neighbors explicitly
- This is a “binary search on answer space” pattern
*/

class LC_162_findPeakElement {

    // find peak element
    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println(findPeakElement(nums));
    }
}
