/*
Problem: Peak Index in a Mountain Array
Platform: LeetCode
Problem ID: 852
Topic: Arrays / Binary Search
Difficulty: Medium
Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/

Description:
Given a mountain array (strictly increasing then strictly decreasing),
find the index of the peak element.

Approach (Binary Search):
- Use binary search within range [1, n-2]
- Check if mid is peak:
  - arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]
- If arr[mid] < arr[mid + 1] → we are in increasing part → move right
- Else → we are in decreasing part → move left
- Continue until peak is found

Time Complexity: O(log n)
Space Complexity: O(1)

Notes:
- Mountain property guarantees exactly one peak
- Search space avoids edges (since peak cannot be at 0 or n-1)
*/

class LC_852_peakIndexMountainArray {

    // find peak index
    public static int peakIndexInMountainArray(int[] arr) {
        int low = 1;
        int high = arr.length - 2;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 4, 3, 2, 1 };
        System.out.println(peakIndexInMountainArray(arr));
    }
}
