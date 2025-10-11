package Leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class LCRomanToInteger {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length()-1;
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans = 0;
        ans+=map.get(s.charAt(n));
        for(int i=n-1;i>=0;i--){
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                ans-=map.get(s.charAt(i));
            }else{
                ans+=map.get(s.charAt(i));
            }
        }
        return ans;
    }
}
