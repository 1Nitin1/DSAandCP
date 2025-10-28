package Leetcode.Medium;
import java.util.*;
public class LCCombinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        solve(list,new ArrayList<>(),1,k,n);
        return list;
    }
    public void solve(List<List<Integer>> l,List<Integer> a,int idx,int k,int n){
        if(a.size()==k){
            l.add(new ArrayList<>(a));
            return;
        }else{
            for(int i=idx;i<=n;i++){
                a.add(i);
                solve(l,a,i+1,k,n);
                a.remove(a.size()-1);
            }
        }
    }
}
