/*
Problem: Linear Search
Topic: Arrays
Difficulty: Easy

Description:
Find the index of a target element in the array.
Return -1 if not found.

Approach:
- Traverse array from start to end
- Compare each element with target

Time Complexity: O(n)
Space Complexity: O(1)
*/

class LinearSearch {

    // Linear Search Algorithm
    public static int linearSearch(int[] arr, int target) {
        if (0 == arr.length) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(linearSearch(arr, 5));
    }
}
