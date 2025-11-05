package Leetcode.Hard;

import java.util.*;

public class LCNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int[][] k = new int[n][n];
        ans(list,new ArrayList<>(),0,k,n);
        return list;
    }
    public void ans(List<List<String>> list,List<String> arr,int idx,int[][] k,int n){
        if(idx==n){
            list.add(new ArrayList<>(arr));
            return;
        }

        for(int i=0;i<n;i++){
            if(k[idx][i]==0){

                StringBuilder str=new StringBuilder();
                for(int l=0;l<n;l++){
                    if(l==i){
                        str.append('Q');
                    }else{
                        str.append('.');
                    }
                }
                arr.add(str.toString());
                for(int j=idx+1;j<n;j++){
                    k[j][i]-=1;
                }
                for(int m=1;m<n;m++){
                    if(idx+m==n || i+m==n){
                        break;
                    }
                    k[idx+m][i+m]-=1;
                }
                for(int m=1;m<n;m++){
                    if(idx+m==n || i-m==-1){
                        break;
                    }
                    k[idx+m][i-m]-=1;
                }
                ans(list,arr,idx+1,k,n);
                arr.remove(arr.size()-1);
                for(int j=idx+1;j<n;j++){
                    k[j][i]+=1;
                }
                for(int m=1;m<n;m++){
                    if(idx+m==n || i+m==n){
                        break;
                    }
                    k[idx+m][i+m]+=1;
                }
                for(int m=1;m<n;m++){
                    if(idx+m==n || i-m==-1){
                        break;
                    }
                    k[idx+m][i-m]+=1;
                }
            }
        }

    }
}
