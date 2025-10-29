package Leetcode.Easy;

public class LCSmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        int a = (int)((Math.log(n)/Math.log(2))+1);
        return (int)Math.pow(2,a)-1;
    }
}
