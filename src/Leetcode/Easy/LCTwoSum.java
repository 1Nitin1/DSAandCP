package Leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

class LCTwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[2];
    }
}

//TC=O(N) or TC=O(N^2)
//SC=O(N) or SC=O(1)
//Concept used = Hashing
