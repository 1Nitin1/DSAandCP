package Leetcode.Medium;

public class LCMinimumTimetoMakeRopeColorful {
    public int minCost(String c, int[] nums) {
        int ans=0;
        int s=nums[0];
        int max=nums[0];

        for(int i=1;i<nums.length;i++){
            if(c.charAt(i)==c.charAt(i-1)){
                s+=nums[i];
                if(nums[i]>max){
                    max=nums[i];
                }
            }else{
                if(max>0){
                    ans+=s-max;
                    max=nums[i];
                }

                s=nums[i];
            }
        }
        if(max>0){
            ans+=s-max;
        }
        return ans;
    }
}
