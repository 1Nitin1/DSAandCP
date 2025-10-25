package Leetcode.Easy;

public class LCDistributeMoneytoMaximumChildren {
    public int distMoney(int m, int c) {
        if(m<c){
            return -1;
        }else if(m>c*8){
            return c-1;
        }
        m-=c;
        int k=m/7;
        if(k==c-1 && m%7==3){
            return k-1;
        }else{
            return k;
        }
    }
}
