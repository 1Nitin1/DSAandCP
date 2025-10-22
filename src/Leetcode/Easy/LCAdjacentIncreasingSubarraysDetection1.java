package Leetcode.Easy;

import java.util.List;

public class LCAdjacentIncreasingSubarraysDetection1 {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        for(int i=0;i<nums.size()-2*k+1;i++){
            boolean first=true;
            boolean second=true;
            for(int j=i+1;j<=i+2*k-1;j++){
                if(j<=i+k-1){
                    if(nums.get(j)<=nums.get(j-1)){
                        first=false;

                        break;
                    }
                }else if(j>i+k){
                    if(nums.get(j)<=nums.get(j-1)){
                        second=false;

                        break;
                    }
                }
            }
            if(first && second){
                return true;
            }
        }
        return false;
    }
}
