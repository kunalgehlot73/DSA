/*
Algorithm: Binary Search (Recursive)
Topic: Recursion / Searching

Description:
Search for a target element in a sorted array using binary search.

Approach:
- Calculate the middle index
- If the middle element equals the target, return its index
- If the target is greater, search the right half
- Otherwise, search the left half
- Base case: Return -1 when start exceeds end

Time Complexity: O(log n)
Space Complexity: O(log n) due to the recursion stack

Notes:
- Requires a sorted array
- Uses divide and conquer
- Each recursive call eliminates half of the remaining search space
*/
class BinarySearch {
    public static int binarySearch(int[] arr, int target, int st, int end) {
        if (st > end) {
            return -1;
        }
        int mid = st + (end - st)/2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, end);
        }
        return binarySearch(arr, target, st, mid - 1);
    }
    public static void main(String[] args) {
        int[] arr = { 2, 5, 9, 12, 15, 20, 35, 45, 65, 67, 69};
        System.out.println(binarySearch(arr, 69, 0, arr.length - 1));
    }
}