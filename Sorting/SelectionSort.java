/*
Algorithm: Selection Sort
Topic: Sorting

Description:
Selects the minimum element from the unsorted portion of the array
and places it at the correct position in each iteration.

Approach:
- Divide array into sorted and unsorted parts
- Find minimum element in unsorted part
- Swap it with the first unsorted element
- Repeat until array is sorted

Time Complexity:
- Best: O(n^2)
- Average: O(n^2)
- Worst: O(n^2)

Space Complexity: O(1)

Notes:
- Not stable (can be made stable with modifications)
- Performs fewer swaps compared to Bubble Sort
- Useful when memory writes are costly
*/

import java.util.Arrays;

class SelectionSort {

    // Selection Sort algorithm
    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    // main function for testing
    public static void main(String[] args) {
        int[] arr = { 9, 5, 1, 3, 5, 7, 8, 5, 2, 6, 5, 4 }; // average case
        // int[] arr = { 1, 2, 3, 4, 5 }; // best case
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}