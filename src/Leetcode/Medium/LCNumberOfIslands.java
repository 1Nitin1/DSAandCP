package Leetcode.Medium;

public class LCNumberOfIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] arr,int r,int c){
        if(r==-1||c==-1||r==arr.length||c==arr[0].length){
            return;
        }else if(arr[r][c]!='1'){
            return;
        }else{
            arr[r][c]='2';
            dfs(arr,r,c+1);
            dfs(arr,r,c-1);
            dfs(arr,r+1,c);
            dfs(arr,r-1,c);
        }

    }
}
