package Leetcode.Medium;

public class LCConstructStringFronBT {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public String tree2str(TreeNode root) {
        StringBuilder str= new StringBuilder();
        pre(root,str);
        str.deleteCharAt(str.length()-1);
        str.deleteCharAt(0);
        return str.toString();
    }
    public void pre(TreeNode root,StringBuilder str){
        if(root==null){
            return;
        }
        str.append('(');
        str.append(root.val);
        if(root.left==null && root.right!=null){
            str.append("()");
        }
        pre(root.left,str);
        pre(root.right,str);
        str.append(')');
    }
}
