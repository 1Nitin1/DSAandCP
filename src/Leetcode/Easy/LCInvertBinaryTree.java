package Leetcode.Easy;

public class LCInvertBinaryTree {
    class TreeNode{
        TreeNode left;
        TreeNode right;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return root;
        }
        ans(root,root.left,root.right);
        return root;

    }
    public void ans(TreeNode root,TreeNode a,TreeNode b){
        if(a==null && b==null){
            return;
        }

        root.left=b;
        root.right=a;
        if(a!=null){
            ans(a,a.left,a.right);
        }
        if(b!=null){
            ans(b,b.left,b.right);
        }
    }
}
