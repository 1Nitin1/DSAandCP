package Leetcode.Medium;

import java.util.*;

public class LCNextGreaterNumericallyBalancedNumber {
    public int nextBeautifulNumber(int n) {
        List<Integer> list = new ArrayList<>();
        int max=1224444;
        generate(0,new int[10],list);
        for(int a = 0;a<list.size();a++){
            if(list.get(a)<max && list.get(a)>n){
                max=list.get(a);
            }
        }
        return max;
    }
    public static void generate(long num,int[] count,List<Integer> list){
        if(num>1224444){
            return;
        }
        if(num>0 && isBalanced(num,count)){
            list.add((int)num);
        }

        for(int i=1;i<=7;i++){
            count[i]++;
            generate(num*10+i,count,list);
            count[i]--;
        }
    }
    public static boolean isBalanced(long n,int[] count){
        for(int i=1;i<10;i++){
            if(count[i]!=0 && count[i]!=i){
                return false;
            }
        }
        return true;
    }
}
