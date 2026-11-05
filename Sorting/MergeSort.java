
/*
Algorithm: Merge Sort
Topic: Sorting / Recursion
Approach: Divide and Conquer

Description:
Recursively divides an array into smaller halves,
sorts them, and merges them back in ascending order.

Approach:
- Divide the array into two halves
- Recursively sort the left half
- Recursively sort the right half
- Merge both sorted halves

Time Complexity: O(n log n)
Space Complexity: O(n) for the temporary array
*/

import java.util.Arrays;
class MergeSort {
    // Merge Sort Algorithm
    public static void mergeSort(int[] arr, int st, int end) {
        if (st >= end) return;
        int mid = st + (end - st) / 2;
        mergeSort(arr, st, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, st, mid, end);
    }
    // function to merge two sorted arrays
    public static void merge(int[] arr, int st, int mid, int end) {
        int[] temp = new int[end - st + 1];
        int i = st;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            arr[st + x] = temp[x];
        }
    }
    // main function for testing
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 1, 3, 7, 6, 4 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
