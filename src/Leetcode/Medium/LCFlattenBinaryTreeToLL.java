package Leetcode.Medium;

import java.util.*;

public class LCFlattenBinaryTreeToLL {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
    }
    public void flatten(TreeNode root) {
        TreeNode ans=new TreeNode(101);
        TreeNode temp=ans;
        if(root==null){
            return ;
        }
        Deque<TreeNode> q=new ArrayDeque<>();
        q.push(root);

        while(!q.isEmpty()){
            temp.right = q.pop();
            temp=temp.right;
            if(temp.right!=null){
                q.push(temp.right);
            }
            if(temp.left!=null){
                q.push(temp.left);
            }
            temp.left=null;
        }

    }
}
