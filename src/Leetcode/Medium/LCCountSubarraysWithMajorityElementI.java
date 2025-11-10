package Leetcode.Medium;

import java.util.*;

public class LCCountSubarraysWithMajorityElementI {
    public int countMajoritySubarrays(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans=0;

        for(int l=0;l<nums.length;l++){
            map.clear();
            int i=1;
            for(int m=l;m<nums.length;m++){
                map.put(nums[m],map.getOrDefault(nums[m],0)+1);
                if(map.containsKey(target) && map.get(target)>i/2){
                    ans++;
                }
                i++;
            }
        }
        return ans;
    }
}
