package Leetcode.Medium;

public class LCNumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int ans = 0;
        boolean[] closed=new boolean[1];
        closed[0]=true;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    dfs(grid,i,j,closed);
                    if(closed[0]){
                        ans++;
                    }
                    closed[0]=true;
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] arr,int r,int c,boolean[] closed){
        if(r==-1||c==-1||r==arr.length||c==arr[0].length){
            closed[0]=false;
            return;
        }else if(arr[r][c]!=0){
            return;
        }else{
            arr[r][c]=2;
            dfs(arr,r,c+1,closed);
            dfs(arr,r,c-1,closed);
            dfs(arr,r+1,c,closed);
            dfs(arr,r-1,c,closed);
        }

    }
}
