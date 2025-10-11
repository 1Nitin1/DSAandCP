package Leetcode.Medium;

class LCZigzagConversion {
    public String convert(String s, int numRows)
    {
        StringBuilder[] st = new StringBuilder[numRows];
        if(numRows==1){
            return s;
        }
        for(int i=0;i<numRows;i++){
            st[i]=new StringBuilder();
        }
        boolean inc = true;
        int ct=0;
        for(char a : s.toCharArray()){
            if(ct==numRows && inc){
                ct=numRows-2;
                inc=false;
            }else if(ct==-1 && !inc){
                inc=true;
                ct=1;
            }
            st[ct].append(a);
            if(inc){
                ct++;
            }else{
                ct--;
            }


        }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<numRows;i++){
            str.append(st[i]);
        }
        return str.toString();
    }
}
