package Leetcode.Medium;
import java.util.*;
public class LCPermutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] arr=new boolean[nums.length];
        ans(ans,new ArrayList<>(),nums,arr);

        return ans;
    }
    public void ans(List<List<Integer>> a,List<Integer> l,int[] nums,boolean[] arr){
        if(l.size()==nums.length){
            List<Integer> k = new ArrayList<>();
            for(int i=0;i<l.size();i++){
                k.add(l.get(i));

            }
            a.add(k);
            return;
        }else{
            for(int i=0;i<nums.length;i++){
                if((i>0&&nums[i]==nums[i-1])&&!arr[i-1] || (arr[i])){
                    continue;
                }
                arr[i]=true;
                l.add(nums[i]);
                ans(a,l,nums,arr);
                l.remove(l.size()-1);
                arr[i]=false;
            }
        }
    }
}
