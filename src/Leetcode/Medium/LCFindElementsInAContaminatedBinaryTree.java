package Leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class LCFindElementsInAContaminatedBinaryTree {
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
    Set<Integer> set = new HashSet<>();
    public void FindElements(TreeNode root) {
        TreeNode head=root;
        head.val=0;
        set.add(0);
        init(head);
    }
    public void init(TreeNode root){
        if(root.left!=null){
            root.left.val=root.val*2+1;
            set.add(root.left.val);
            init(root.left);
        }
        if(root.right!=null){
            root.right.val=root.val*2+2;
            set.add(root.right.val);
            init(root.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
