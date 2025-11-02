package Leetcode.Medium;
import java.util.*;
public class LCCombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        ans(list,new ArrayList<>(),k,n,0);
        return list;
    }
    public void ans(List<List<Integer>> list,List<Integer> l,int k,int n,int idx){
        if(n<0 || k<0){
            return;
        }else if(n==0 && k==0){
            list.add(new ArrayList<>(l));
            return;
        }else{
            for(int i=1;i<=9;i++){
                if(idx>=i){
                    continue;
                }
                l.add(i);
                ans(list,l,k-1,n-i,i);
                l.remove(l.size()-1);
            }
        }
    }
}
