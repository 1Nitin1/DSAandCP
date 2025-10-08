package Leetcode;

public class LCPalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int rev=0;
        int num = x;
        while(num>0){
            rev=rev*10+num%10;
            num/=10;
        }
        if(x==rev){
            return true;
        }
        return false;
    }
}
//TC=O(D)
//SC=O(1)
//Concept used = brute force
