package Leetcode.Hard;

public class LCFirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //or can use index sorting
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0){
                nums[i]=nums.length+1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i])>=nums.length+1){
                continue;
            }
            int idx=Math.abs(nums[i])-1;
            nums[idx]=-Math.abs(nums[idx]);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
