package Leetcode.Easy;

import Leetcode.Medium.LCFindElementsInAContaminatedBinaryTree;

public class LCSumOfLeftLeaves {
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
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = new int[1];
        add(root,sum);
        return sum[0];

    }
    public void add(TreeNode root,int[] sum){
        if(root==null){
            return;
        }
        if(root.left!=null){
            if(root.left.left==null && root.left.right==null){
                sum[0]+=root.left.val;
            }
            add(root.left,sum);
        }
        if(root.right!=null){
            add(root.right,sum);
        }
    }
}
