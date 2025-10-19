package Leetcode.Easy;

public class LCSmallestMissingMultipleOfK {
    public int missingMultiple(int[] nums, int k) {
        boolean[] p = new boolean[100];
        for(int a : nums){
            p[a-1]=true;
        }
        for(int i=0;i<100;i++){
            if(p[i]==false && (i+1)%k==0){
                return i+1;
            }
        }
        return ((100+k)/k)*k;
    }
}
