package Leetcode.Medium;
import java.util.*;
public class LCCombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        add(list,arr,target,candidates,0);
        return list;
    }
    public void add(List<List<Integer>> list,List<Integer> arr,int target,int[] cap,int idx){
        if(target<0){
            return;
        }
        if(target==0){
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<arr.size();i++){
                l.add(arr.get(i));
            }
            list.add(l);
            return;
        }
        for(int i=0;i<cap.length;i++){
            if(i>=idx){
                arr.add(cap[i]);
                add(list,arr,target-cap[i],cap,i);
                arr.remove(arr.size()-1);
            }
        }
    }
}
