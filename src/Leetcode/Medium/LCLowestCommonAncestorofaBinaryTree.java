package Leetcode.Medium;

public class LCLowestCommonAncestorofaBinaryTree {
    class TreeNode{
        TreeNode left;
        TreeNode right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q) return root;
        TreeNode x = lowestCommonAncestor(root.left,p,q);
        TreeNode y = lowestCommonAncestor(root.right,p,q);
        if(x!=null && y!=null) return root;
        else return x!=null?x:y;
    }
}
