/*
Problem: Binary Search
Topic: Arrays / Searching
Difficulty: Easy

Description:
Given a sorted array of integers, search for a target value.
Return its index if found, otherwise return -1.

Approach:
- Use two pointers (low, high)
- Find mid = low + (high - low) / 2
- Compare target with mid element
  - If equal → return index
  - If target < mid → search left half
  - Else → search right half
- Repeat until low > high

Time Complexity: O(log n)
Space Complexity: O(1)

Prerequisite:
- Array must be sorted

Notes:
- Avoid overflow using: mid = low + (high - low) / 2
*/

class BinarySearch {
    // Binary Search Algorithm
    public static int binarySearch(int[] arr, int target) {
        int st = 0, end = arr.length - 1;
        while (st<=end) {
            int mid = st + (end - st)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // main function for testing    
    public static void main(String[] args) {
        int[] arr = { 2, 5, 9, 12, 15, 20, 35, 45, 65, 67, 69};
        System.out.println(binarySearch(arr, 69));
    }
}
