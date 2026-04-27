/*
Algorithm: Bubble Sort
Topic: Sorting

Description:
Repeatedly compares adjacent elements and swaps them if they are in the wrong order.
After each pass, the largest element "bubbles up" to its correct position.

Approach:
- Traverse the array multiple times
- Compare adjacent elements (arr[j] and arr[j+1])
- Swap if they are in wrong order
- After each iteration, the largest element moves to the end
- Optimization: stop early if no swaps occur

Time Complexity:
- Best: O(n) (already sorted with optimization)
- Average: O(n^2)
- Worst: O(n^2)

Space Complexity: O(1)

Notes:
- Stable sorting algorithm
- Simple but inefficient for large inputs
*/

import java.util.Arrays;

class BubbleSort {

    // Bubble Sort algorithm
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            boolean sorted = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = true;
                }
            }
            if (!sorted)
                break;
        }
    }

    // main function for testing
    public static void main(String[] args) {
        // int[] arr = { 9, 5, 1, 3, 5, 7, 8, 5, 2, 6, 5, 4 }; // average case
        int[] arr = { 1, 2, 3, 4, 5 }; // best case
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}