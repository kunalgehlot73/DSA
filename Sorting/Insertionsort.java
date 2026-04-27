/*
Algorithm: Insertion Sort
Topic: Sorting

Description:
Builds the sorted array one element at a time by inserting each element
into its correct position in the already sorted portion.

Approach:
- Start from index 1
- Compare current element with previous elements
- Shift elements greater than current to the right
- Insert current element at correct position

Time Complexity:
- Best: O(n) (already sorted)
- Average: O(n^2)
- Worst: O(n^2)

Space Complexity: O(1)

Notes:
- Stable sorting algorithm
- Efficient for small or nearly sorted arrays
- Used in hybrid algorithms (like TimSort)
*/

import java.util.Arrays;

class Insertionsort {

    // Insertion Sort Algorithm
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    // main function for testing
    public static void main(String[] args) {
        int[] arr = { 9, 5, 1, 3, 5, 7, 8, 5, 2, 6, 5, 4 }; // average case
        // int[] arr = { 1, 2, 3, 4, 5 }; // best case
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}