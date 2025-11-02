package Leetcode.Easy;

public class LCTheTwoSneakyNumbersofDigitville {
    public int[] getSneakyNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while(nums[i]!=nums[nums[i]]){
                int a = nums[i];
                nums[i]=nums[a];
                nums[a]=a;
            }
        }
        return new int[]{nums[nums.length-2],nums[nums.length-1]};
    }
}
