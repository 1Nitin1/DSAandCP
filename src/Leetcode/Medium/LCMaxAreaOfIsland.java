package Leetcode.Medium;

public class LCMaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int[] cur = new int[1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,cur);
                    ans=Math.max(ans,cur[0]);
                    cur[0]=0;
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] arr,int r,int c,int[] cur){
        if(r==-1||c==-1||r==arr.length||c==arr[0].length){
            return;
        }else if(arr[r][c]!=1){
            return;
        }else{
            cur[0]++;
            arr[r][c]=2;
            dfs(arr,r,c+1,cur);
            dfs(arr,r,c-1,cur);
            dfs(arr,r+1,c,cur);
            dfs(arr,r-1,c,cur);
        }

    }
}
