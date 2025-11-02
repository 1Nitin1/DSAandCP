package Leetcode.Medium;

import java.util.Arrays;

public class LCMaximumProductofThreeElementsAfterOneReplacement {
    public long maxProduct(int[] nums) {

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i]=-nums[i];
            }
        }
        Arrays.sort(nums);
        long m1=(long)nums[nums.length-1];
        long m2=(long)nums[nums.length-2];
        long ans=m1*m2*100000;
        return ans;

    }
}
