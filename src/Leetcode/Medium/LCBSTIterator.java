package Leetcode.Medium;

import java.util.*;

public class LCBSTIterator {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }
    List<Integer> list;
    int i;

    public void BSTIterator(TreeNode root) {
        i = -1;
        list = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> q = new ArrayDeque<>();
            TreeNode curr = root;
            while (curr != null || !q.isEmpty()) {
                while (curr != null) {
                    q.push(curr);
                    curr = curr.left;
                }
                TreeNode n = q.pop();
                list.add(n.val);
                curr = n.right;
            }
        }
    }

    public int next() {
        return list.get(++i);
    }

    public boolean hasNext() {
        if (i + 1 < list.size()) {
            return true;
        } else {
            return false;
        }
    }
}
