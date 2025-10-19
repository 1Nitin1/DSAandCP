package Leetcode.Medium;

import java.util.Arrays;

public class LCMaximumNumberOfDistinctElementsAfterOperations {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=1;
        nums[0]-=k;
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            int a = max-nums[i];
            if(max>=nums[i] && a+1<=k){
                ans++;
                nums[i]+=a+1;
            }else if(max<nums[i]){
                ans++;
                nums[i]+=Math.max(a+1,-k);
            }
            if(nums[i]>max){
                max=nums[i];
            }
        }

        return ans;
    }
}
