package Leetcode.Medium;

public class LCIntegerToRoman {
    public String intToRoman(int num) {

        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num < nums[i]) {
                i++;

            }
            num -= nums[i];

            ans.append(letters[i]);
        }
        return ans.toString();
    }
}
