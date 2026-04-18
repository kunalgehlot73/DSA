/*
Problem: Find in Mountain Array
Platform: LeetCode
Problem ID: 1095
Topic: Arrays / Binary Search
Difficulty: Hard
Link: https://leetcode.com/problems/find-in-mountain-array/

Description:
Given a mountain array (strictly increasing then strictly decreasing),
find the index of a target element. If the target does not exist, return -1.

Approach (Binary Search on Mountain Array):
- Step 1: Find peak index using binary search
- Step 2: Perform binary search on left (ascending) part [0 → peak]
- Step 3: If not found, perform binary search on right (descending) part [peak+1 → n-1]
- Adjust comparison logic based on ascending/descending order

Time Complexity: O(log n)
Space Complexity: O(1)

Notes:
- Access to array is via MountainArray API (get, length)
- Minimize number of get() calls (important constraint)
- Combines 3 binary searches (peak + 2 searches)
*/

// Mountain Array API Interface
interface MountainArray {
    int get(int index);

    int length();
}

// Mock implementation of Mountain Array API for local testing
class MountainArrayImpl implements MountainArray {
    private int[] arr;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }
}

class LC_1095_FindInMountainArray {

    // find and return the index of target element in the mountainArr
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakElement(mountainArr);
        int index = binarySearch(mountainArr, target, 0, peakIndex, true);
        if (index != -1)
            return index;
        return binarySearch(mountainArr, target, peakIndex + 1, mountainArr.length() - 1, false);
    }

    // find peak element in mountainArr
    public static int findPeakElement(MountainArray arr) {
        int low = 0, high = arr.length() - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr.get(mid) > arr.get(mid + 1))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    // order agnostic binary search to find element in both part of the mountainArr
    public static int binarySearch(MountainArray arr, int target, int low, int high, boolean asc) {
        int mid, num;
        while (low <= high) {
            mid = low + (high - low) / 2;
            num = arr.get(mid);
            if (num == target)
                return mid;
            if (asc) {
                if (num < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                if (num < target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    // main function for testing
    public static void main(String[] args) {
        int[] test = { 1, 3, 5, 7, 6, 4, 2 };
        MountainArray mountainArr = new MountainArrayImpl(test);
        int target = 6;
        System.out.println(findInMountainArray(target, mountainArr));
    }
}