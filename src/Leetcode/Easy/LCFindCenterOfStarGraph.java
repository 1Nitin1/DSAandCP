package Leetcode.Easy;

public class LCFindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        int[] arr = new int[edges.length+1];
        for(int i=0;i<edges.length;i++){
            arr[edges[i][0]-1]++;
            arr[edges[i][1]-1]++;
        }
        int i=0;
        for(int a : arr){
            if(a==edges.length){
                return i+1;
            }
            i++;
        }
        return -1;
    }
}
