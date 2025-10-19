package Leetcode.Medium;
import java.util.*;

public class LCCourseSchedule2 {
    public int[] findOrder(int n, int[][] p) {
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[n];
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++){
            indegree[p[i][0]]++;
            list.get(p[i][1]).add(p[i][0]);
        }
        bfs(list,indegree,ans);
        for(int a : indegree){
            if(a!=0){
                return new int[0];
            }
        }

        return ans;

    }
    public void bfs(List<List<Integer>> list,int[] indegree,int[] ans){
        Deque<Integer> q = new ArrayDeque<>();
        int i=0;
        for(int a:indegree){
            if(a==0){
                q.add(i);
            }
            i++;
        }
        int k = 0;
        while(!q.isEmpty()){
            int a = q.poll();
            ans[k++]=a;
            for(int j=0;j<list.get(a).size();j++){
                int b = list.get(a).get(j);

                indegree[b]--;
                if(indegree[b]==0){
                    q.add(b);
                }
            }
        }
    }
}
