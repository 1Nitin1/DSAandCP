package Leetcode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LCDeepestLeavesSum {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int a){
            val=a;
            left=null;
            right=null;
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        int ans =0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            ans=0;
            int k = q.size();
            for(int i=0;i<k;i++){
                TreeNode x = q.poll();
                ans+=x.val;
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right!=null){
                    q.add(x.right);
                }
            }
        }
        return ans;
    }
}
