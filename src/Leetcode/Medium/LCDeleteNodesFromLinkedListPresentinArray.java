package Leetcode.Medium;

import java.util.HashSet;
import java.util.Set;

public class LCDeleteNodesFromLinkedListPresentinArray {
    class ListNode{
        ListNode next;
        int val;
        ListNode(int a){
            val=a;
        }
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int a : nums){
            set.add(a);
        }
        ListNode dummy = new ListNode(0);

        dummy.next=head;
        ListNode temp = dummy;
        while(head!=null){
            if(set.contains(head.val)){
                temp.next=head.next;
                head=head.next;
            }else{
                temp=head;
                head=head.next;
            }
        }
        return dummy.next;
    }
}
