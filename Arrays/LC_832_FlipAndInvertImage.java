
/*
Problem: Flipping an Image
Platform: LeetCode
Problem ID: 832
Topic: Arrays / Matrix / Two Pointers
Difficulty: Easy
Link: https://leetcode.com/problems/flipping-an-image/

Description:
Given a binary matrix, horizontally flip each row and then invert
every bit in the resulting matrix.

Approach:
- Traverse each row using two pointers
- Start one pointer at the beginning and the other at the end
- Swap the elements while inverting their values
- Move both pointers towards the center
- Handles the middle element automatically for odd-length rows

Time Complexity: O(m * n)
Space Complexity: O(1)

Notes:
- Performs flipping and inversion in a single traversal
- Modifies the input matrix in-place
- Uses the Two Pointers technique
*/

import java.util.Arrays;
class LC_832_FlipAndInvertImage {
    // flip and invert
    public static  int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int st=0,end=image[i].length - 1;
            while (st <= end) {
                int temp = (image[i][st]==1)? 0:1;
                image[i][st] = (image[i][end]==1)?0:1;
                image[i][end] = temp;
                st++;end--;
            }
        }
        return image;    
    }
    // main function for testing
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] flippedImage = flipAndInvertImage(image);
        for(int[] i:flippedImage) {
            System.out.println(Arrays.toString(i));
        }
    }
}