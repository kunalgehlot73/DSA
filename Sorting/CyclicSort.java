/*
Algorithm: Cyclic Sort
Topic: Sorting

Description:
Sorts an array containing numbers from 1 to N by placing each element
at its correct index (value - 1).

Approach:
- Traverse the array using a pointer i
- For each element:
  - Calculate its correct index as arr[i] - 1
  - If element is not at its correct position, swap it
  - Otherwise move to the next index
- Continue until all elements are placed correctly

Time Complexity: O(n)
Space Complexity: O(1)

Prerequisites:
- Array contains numbers from 1 to N
- No duplicate values

Notes:
- Not a comparison-based sorting algorithm
- Much faster than O(n log n) sorting for this special case
- Forms the basis for many array-placement problems
  (Missing Number, Find Duplicates, First Missing Positive, etc.)
*/

import java.util.Arrays;

class CyclicSort {

    // Cyclic Sort Algorithm
    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i<arr.length) {
            int correctIndex = arr[i] - 1;
            if (i != correctIndex) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
    }

    // main function for testing
    public static void main(String[] args) {
        int[] arr = { 9, 5, 1, 3, 7, 4, 6, 8, 2 }; // average case
        // int[] arr = { 1, 2, 3, 4, 5 }; // best case
        System.out.println(Arrays.toString(arr));
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}