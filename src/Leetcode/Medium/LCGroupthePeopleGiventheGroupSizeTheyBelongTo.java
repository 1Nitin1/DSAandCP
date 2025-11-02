package Leetcode.Medium;

import java.util.*;

public class LCGroupthePeopleGiventheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] g) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> arr = new ArrayList<>();
        int[][] a = new int[g.length][2];
        for(int i=0;i<g.length;i++){
            a[i][0]=g[i];
            a[i][1]=i;
        }
        Arrays.sort(a,(l,m)->l[0]-m[0]);
        for(int i=0;i<g.length;i++){
            arr.add(a[i][1]);
            if(arr.size()==a[i][0]){
                list.add(new ArrayList<>(arr));
                arr.clear();
            }
        }
        return list;
    }
}
