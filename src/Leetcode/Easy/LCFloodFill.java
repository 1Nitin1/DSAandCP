package Leetcode.Easy;

public class LCFloodFill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if(color==image[sr][sc]){
                return image;
            }
            dfs(image,sr,sc,color,image[sr][sc]);
            return image;
        }
        public void dfs(int[][] mat, int sr,int sc,int color,int wanted){
            if(sr==mat.length||sc==mat[0].length || sr==-1 || sc==-1){
                return;
            }else if(mat[sr][sc]!=wanted){
                return;
            }
            mat[sr][sc]=color;
            dfs(mat,sr,sc+1,color,wanted);
            dfs(mat,sr,sc-1,color,wanted);
            dfs(mat,sr+1,sc,color,wanted);
            dfs(mat,sr-1,sc,color,wanted);

        }
    }
}
