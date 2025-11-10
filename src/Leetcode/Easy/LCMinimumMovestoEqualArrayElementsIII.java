package Leetcode.Easy;

public class LCMinimumMovestoEqualArrayElementsIII {
    public int minMoves(int[] nums) {
        int max=nums[0];
        int sum=0;
        for(int a:nums){
            if(a>max){
                max=a;
            }
            sum+=a;
        }
        return max*nums.length-sum;
    }
}
