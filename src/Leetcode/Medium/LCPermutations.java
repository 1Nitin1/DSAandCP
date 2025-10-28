package Leetcode.Medium;
import java.util.*;
public class LCPermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        ans(ans,new ArrayList<>(),nums,set);
        return ans;
    }
    public void ans(List<List<Integer>> a,List<Integer> l,int[] nums,Set<Integer> set){
        if(l.size()==nums.length){
            List<Integer> k = new ArrayList<>();
            for(int i=0;i<l.size();i++){
                k.add(l.get(i));

            }
            a.add(k);
            return;
        }else{
            for(int i=0;i<nums.length;i++){
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                    l.add(nums[i]);
                    ans(a,l,nums,set);
                    l.remove(l.size()-1);
                    set.remove(nums[i]);
                }
            }
        }
    }
}
