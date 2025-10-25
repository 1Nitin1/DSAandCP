package Leetcode.Easy;

public class LCCalculateMoneyinLeetcodeBank {
    public int totalMoney(int n) {
        int a=1;
        int ans=0;
        while(n-7>=0){
            ans+=((2*a+6)/2)*7;
            n-=7;
            a++;
        }
        if(n>0){
            ans+=((2*a+n-1)*(n))/2;
        }
        return ans;
    }
}
