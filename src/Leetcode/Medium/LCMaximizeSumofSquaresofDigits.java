package Leetcode.Medium;

public class LCMaximizeSumofSquaresofDigits {
    public String maxSumOfSquares(int num, int sum) {
        int ans=0;
        int sc=0;
        StringBuilder str = new StringBuilder();
        if((sum/num==9 && sum%num!=0)||sum/num>9 ){
            return "";
        }
        outerloop:
        for(int i=9;i>=0;i--){

            while(sum-i>=0){
                if(str.length()==num){
                    break outerloop;
                }
                str.append(i);
                sum-=i;
            }
        }
        return str.toString();
    }
}
