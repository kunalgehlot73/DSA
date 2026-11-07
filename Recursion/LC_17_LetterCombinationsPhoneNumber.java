
/*
Problem: Letter Combinations of a Phone Number
Platform: LeetCode
Problem ID: 17
Topic: Recursion / Backtracking
Difficulty: Medium
Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Description:
Given a string containing digits from 2 to 9,
return all possible letter combinations that the
digits could represent using a phone keypad.

Approach (Recursion / Backtracking):
- Map each digit to its corresponding letters
- Process one digit at a time
- Try every possible letter for the current digit
- Recursively process the next digit
- When all digits are processed, add the combination to the answer

Time Complexity: O(n * 4^n)
Space Complexity: O(n) auxiliary space
(Excluding the output list)

Notes:
- Demonstrates multiple recursive calls
- Uses backtracking to explore all possibilities
- Each recursive call processes one digit
- Uses String immutability to avoid manual undo operations
*/

import java.util.ArrayList;
import java.util.List;

class LC_17_LetterCombinationsPhoneNumber {
    // combine every char and append in ans
    public static void combine(String digits, int index, String currStr, List<String> ans, String[] map) {
        if (currStr.length() == digits.length()) {
            ans.add(currStr);
            return;
        }
        String digitToChar = map[digits.charAt(index)-'2'];
        for (int i = 0; i < digitToChar.length(); i++) {
            combine(digits, index+1, currStr+digitToChar.charAt(i), ans, map);
        }
    }
    // maps digit to chars
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if (digits.length() > 0) combine(digits, 0, "", ans, map);
        return ans;
    }
    // main function for testing
    public static void main(String[] args) {
        List<String> ans = letterCombinations("23");
        System.out.println(ans.toString());
    }    
}