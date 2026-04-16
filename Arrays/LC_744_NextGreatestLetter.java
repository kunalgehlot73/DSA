/*
Problem: Find Smallest Letter Greater Than Target
Platform: LeetCode
Problem ID: 744
Topic: Arrays / Binary Search
Difficulty: Easy
Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/

Description:
Given a sorted array of characters and a target, return the smallest character
that is strictly greater than the target. The array is circular.

Approach (Binary Search - Upper Bound):
- Handle circular case:
  - If target >= last element → return first element
- Apply binary search:
  - If letters[mid] > target → search left (high = mid - 1)
  - Else → search right (low = mid + 1)
- Loop ends when low > high
- The answer is at index low (first element greater than target)

Time Complexity: O(log n)
Space Complexity: O(1)

Notes:
- This is an “upper bound” pattern (first element > target)
- Guaranteed valid index due to circular condition
*/
class LC_744_NextGreatestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1, mid;
        if (target >= letters[high]) {
            return letters[0];
        }
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target < letters[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return letters[low];
    }

    public static void main(String[] args) {
        char[] letters = {'e','e','e','e','e','e','n','n','n','n'};
        char target = 'e';
        System.out.println(nextGreatestLetter(letters, target));
    }
}