/*
Algorithm: Binary Search in 2D Matrix (Row-wise Binary Search)
Topic: Arrays / Binary Search

Description:
Search for a target element in a 2D matrix where:
- Each row is sorted
- Last element of a row is less than the first element of the next row

Approach:
- Step 1: Apply binary search on rows to find the candidate row
  - Compare target with first and last element of each row
- Step 2: Perform standard binary search within that row

Time Complexity: O(log m + log n)
Space Complexity: O(1)

Notes:
- This is equivalent to binary search on a flattened matrix
- Requires strict row-to-row ordering (fully sorted matrix)
- Not suitable for matrices only sorted row-wise & column-wise
*/

import java.util.Arrays;

class BinarySearch_2D {

    public static int binarySearch(int[] arr, int target) {
        int st = 0, end = arr.length - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
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

    public static int[] binarySearch_2D(int[][] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midLength = nums[mid].length;
            if (target < nums[mid][0]) {
                high = mid - 1;
            } else if (target > nums[mid][midLength - 1]) {
                low = mid + 1;
            } else {
                int col = binarySearch(nums[mid], target);
                if (col != -1) {
                    return new int[] { mid, col };
                }
                return new int[] { -1, -1 };
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 12, 13 },
                { 14, 15, 16, 17 }
        };
        int target = 17;
        System.out.println(Arrays.toString(binarySearch_2D(nums, target)));
    }
}