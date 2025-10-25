package Leetcode.Medium;

public class LCLexicographicallySmallestStringAfterReverse {
    public String lexSmallest(String s) {
        int i=0;
        String ans = s;
        int n = s.length();
        for(int k=1;k<=n;k++){
            String fr= reverseSubstring(s,0,k-1);
            String bk = reverseSubstring(s,n-k,n-1);
            if(fr.compareTo(ans)<0){
                ans=fr;
            }
            if(bk.compareTo(ans)<0){
                ans=bk;
            }
        }
        return ans;
    }
    public static String reverseSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder(str);
        String reversedPart = new StringBuilder(sb.substring(start, end + 1)).reverse().toString();
        sb.replace(start, end + 1, reversedPart);
        return sb.toString();
    }
}
