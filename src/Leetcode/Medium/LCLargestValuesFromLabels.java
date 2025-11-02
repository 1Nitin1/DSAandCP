package Leetcode.Medium;

import java.util.*;

public class LCLargestValuesFromLabels {
    public int largestValsFromLabels(int[] v, int[] l, int numWanted, int useLimit) {
        int ans=0;
        int ct=0;
        Map<Integer,Integer> map = new HashMap<>();
        int[][] arr = new int[v.length][2];
        for(int i=0;i<v.length;i++){
            arr[i][0]=v[i];
            arr[i][1]=l[i];
        }
        Arrays.fill(l,0);
        Arrays.sort(arr,(a,b)->b[0]-a[0]);
        for(int i=0;i<v.length;i++){
            if(map.containsKey(arr[i][1])&& map.get(arr[i][1])==useLimit){
                continue;
            }else{
                ans+=arr[i][0];
                ct++;
                if(ct==numWanted){
                    return ans;
                }
                map.put(arr[i][1],map.getOrDefault(arr[i][1],0)+1);

            }
        }
        return ans;
    }
}
