package Leetcode.Hard;

public class LCMinimumNumberofIncrementsonSubarraystoFormaTargetArray {
    public int minNumberOperations(int[] t) {
        int ans=0;
        int max=0;
        for(int i=0;i<t.length;i++){
            if(t[i]>max){
                ans+=t[i]-max;
            }
            max=t[i];
        }
        return ans;
    }
}
