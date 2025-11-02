package Leetcode.Medium;

import java.util.Arrays;

public class LCCheckIfaStringCanBreakAnotherString {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        Arrays.sort(char1);
        String sorted1 = new String(char1);
        char[] char2 = s2.toCharArray();
        Arrays.sort(char2);
        String sorted2 = new String(char2);
        int inc=0;
        int dec=0;
        for(int i=0;i<sorted1.length();i++){
            if(sorted1.charAt(i)>=sorted2.charAt(i)){
                inc++;
            }
            if(sorted1.charAt(i)<=sorted2.charAt(i)){
                dec++;
            }
        }
        if(inc==s1.length()||dec==s1.length()){
            return true;
        }    else{
            return false;
        }

    }
}
