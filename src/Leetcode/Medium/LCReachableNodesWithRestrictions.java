package Leetcode.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LCReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=edges.length;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[edges.length+1];
        for(int i=0;i<restricted.length;i++){
            visited[restricted[i]]=true;
        }
        int ans=0;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int a = q.poll();
            ans++;
            for(int i=0;i<list.get(a).size();i++){
                int k = list.get(a).get(i);
                if(!visited[k]){
                    q.add(k);
                    visited[k]=true;
                }
            }
        }
        return ans;
    }
}
