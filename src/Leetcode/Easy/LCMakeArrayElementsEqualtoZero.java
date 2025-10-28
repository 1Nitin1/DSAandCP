package Leetcode.Easy;

public class LCMakeArrayElementsEqualtoZero {
    public int countValidSelections(int[] nums) {
        int ans=0;
        int[] p = new int[nums.length];
        p[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            p[i]=nums[i]+p[i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(p[i]==p[nums.length-1]-p[i]){
                    ans+=2;
                }else if(Math.abs(p[i]-p[nums.length-1]+p[i])==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
