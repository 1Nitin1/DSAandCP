package Leetcode.Easy;

public class LCFinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for(String a : operations){
            if(a.charAt(1)=='-'){
                ans--;
            }else{
                ans++;
            }
        }
        return ans;
    }
}
