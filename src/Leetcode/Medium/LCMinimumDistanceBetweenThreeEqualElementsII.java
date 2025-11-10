package Leetcode.Medium;

import java.util.*;

public class LCMinimumDistanceBetweenThreeEqualElementsII {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            }else{
                map.get(nums[i]).add(i);
            }

        }
        int ans=Integer.MAX_VALUE;
        for(int k:map.keySet()){
            if(map.get(k).size()>2){
                for(int i=2;i<map.get(k).size();i++){
                    int a=map.get(k).get(i)-map.get(k).get(i-2);
                    ans=Math.min(ans,2*a);
                }
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}
