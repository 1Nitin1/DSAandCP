package Leetcode.Easy;

import java.util.*;

public class LCFindTheTownJudge {
    public int findJudge(int n, int[][] p) {
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++){
            indegree[p[i][1]-1]++;
            list.get(p[i][0]-1).add(p[i][1]-1);
        }
        int l=0;
        for(int a : indegree){
            if(a==n-1 && list.get(l).size()==0){
                return l+1;
            }
            l++;
        }
        return -1;

    }
}
