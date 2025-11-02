package Leetcode.Medium;

public class LCCountUnguardedCellsintheGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int ans=0;
        int[][] p=new int[m][n];
        for(int[] a:guards){
            p[a[0]][a[1]]=1;
        }
        for(int[] a:walls){
            p[a[0]][a[1]]=2;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(p[i][j]==1){
                    fill(i,j,p,m,n);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(p[i][j]==0){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void fill(int i,int j,int[][] grid,int m,int n){
        for(int k=j+1;k<n;k++){
            if (grid[i][k] == 1 || grid[i][k] == 2) break;
            grid[i][k]=-1;
        }
        for(int k=j-1;k>=0;k--){
            if (grid[i][k] == 1 || grid[i][k] == 2) break;
            grid[i][k]=-1;
        }
        for(int k=i+1;k<m;k++){
            if (grid[k][j] == 1 || grid[k][j] == 2) break;
            grid[k][j]=-1;
        }
        for(int k=i-1;k>=0;k--){
            if (grid[k][j] == 1 || grid[k][j] == 2) break;
            grid[k][j]=-1;
        }
    }
}
