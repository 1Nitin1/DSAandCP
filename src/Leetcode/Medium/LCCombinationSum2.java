package Leetcode.Medium;
import java.util.*;
public class LCCombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        boolean[] b = new boolean[candidates.length];
        Arrays.sort(candidates);
        add(list,arr,target,candidates,0,b);
        return list;
    }
    public void add(List<List<Integer>> list,List<Integer> arr,int target,int[] cap,int idx,boolean[] b){
        if(target<0){
            return;
        }else if(target==0){
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<arr.size();i++){
                l.add(arr.get(i));
            }
            list.add(l);
            return;
        }
        for(int i=0;i<cap.length;i++){
            if((i>0 && cap[i]==cap[i-1])&&!b[i-1] || (b[i]) || (idx>i)){
                continue;
            }

            arr.add(cap[i]);
            b[i]=true;
            add(list,arr,target-cap[i],cap,i,b);
            arr.remove(arr.size()-1);
            b[i]=false;
        }
    }
}
