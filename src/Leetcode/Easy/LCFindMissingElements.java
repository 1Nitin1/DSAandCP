package Leetcode.Easy;

import java.util.*;

public class LCFindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int min=nums[0];
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
            if(nums[i]>max){
                max=nums[i];
            }
        }
        boolean[] p = new boolean[max-min+1];
        for(int i=0;i<nums.length;i++){
            p[nums[i]-min]=true;
        }
        for(int i=0;i<p.length;i++){
            if(!p[i]){
                list.add(i+min);
            }
        }
        return list;
    }
}
