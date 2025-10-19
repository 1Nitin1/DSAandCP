package Leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class LCLongestBalancedSubarray1 {
    public int longestBalanced(int[] nums) {
        int ect=0;
        int oct=0;
        int ans=0;
        Set<Integer> even = new HashSet<>();
        Set<Integer> odd = new HashSet<>();
        for(int i=0;i<nums.length-1;i++){
            even.clear();
            odd.clear();
            if(nums[i]%2==0){
                even.add(nums[i]);
                ect=1;
                oct=0;
            }else{
                odd.add(nums[i]);
                ect=0;
                oct=1;
            }
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]%2==0){
                    if(!even.contains(nums[j])){
                        even.add(nums[j]);
                        ect++;
                    }
                }else{
                    if(!odd.contains(nums[j])){
                        odd.add(nums[j]);
                        oct++;
                    }
                }

                if(ect==oct){
                    ans=Math.max(j-i+1,ans);
                }
            }
        }
        return ans;
    }
}
