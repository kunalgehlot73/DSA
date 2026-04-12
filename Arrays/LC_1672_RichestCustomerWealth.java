/*
Problem: Richest Customer Wealth
Platform: LeetCode
Problem ID: 1672
Topic: Arrays
Difficulty: Easy
Link: https://leetcode.com/problems/richest-customer-wealth/

Description:
You are given a 2D array where each row represents a customer's accounts.
Return the maximum wealth among all customers.

Approach:
- Iterate through each row
- Calculate sum of elements in each row
- Track maximum sum

Time Complexity: O(m * n)
Space Complexity: O(1)
*/

class LC_1672_RichestCustomerWealth {
    // Calculate maximum wealth
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        int amount = 0;
        for (int[] account : accounts) {
            amount = 0;
            for (int i : account) {
                amount += i;
            }
            if (amount > maxWealth) {
                maxWealth = amount;
            }
        }
        return maxWealth;
    }

    // main function for testing
    public static void main(String[] args) {
        int[][] accounts = {
                { 1, 2, 3 },
                { 3, 2, 1 }
        };
        System.out.println(maximumWealth(accounts));
    }
}
