package Leetcode.Easy;

public class LCIslandPerimeter {
    int ans=0;
    public int islandPerimeter(int[][] grid) {

        outerloop:
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    break outerloop;
                }
            }
        }

        return ans;

    }
    public void dfs(int[][] arr,int r,int c){
        if(r==-1||c==-1||r==arr.length||c==arr[0].length){
            ans++;
            return;
        }else if(arr[r][c]==0){
            ans++;
            return;
        }else if(arr[r][c]==2){
            return;
        }else{
            arr[r][c]=2;
            dfs(arr,r,c+1);
            dfs(arr,r,c-1);
            dfs(arr,r+1,c);
            dfs(arr,r-1,c);
        }

    }
}
