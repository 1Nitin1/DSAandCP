package Leetcode.Hard;

public class LCNQueens2 {
    public int totalNQueens(int n) {
        int[] ans={0};
        int[][] k = new int[n][n];
        ans(ans,0,k,n);
        return ans[0];
    }
    public void ans(int[] ans,int idx,int[][] k,int n){
        if(idx==n){
            ans[0]++;
            return;
        }

        for(int i=0;i<n;i++){
            if(k[idx][i]==0){
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
                ans(ans,idx+1,k,n);

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
