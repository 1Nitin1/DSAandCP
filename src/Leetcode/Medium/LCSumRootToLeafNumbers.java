package Leetcode.Medium;

public class LCSumRootToLeafNumbers {
    int ans;
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
    public int sumNumbers(TreeNode root) {
        int a=0;
        ans=0;
        num(root,a);
        return ans;
    }
    public void num(TreeNode root,int a){

        if(root==null){
            return ;
        }
        a=a*10+root.val;
        if(root.left==null && root.right==null){
            ans+=a;
            return;

        }
        num(root.left,a);

        num(root.right,a);

    }
}
