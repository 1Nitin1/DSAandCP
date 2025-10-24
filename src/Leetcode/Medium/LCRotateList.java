package Leetcode.Medium;

public class LCRotateList {
    class ListNode{
        ListNode next;
        int data;
        ListNode(int a){
            data=a;
            next=null;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next==null){
            return head;
        }
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        k%=n;
        if(k==0){
            return head;
        }
        head = reverseBetween(head,1,n);
        head = reverseBetween(head,k+1,n);
        return reverseBetween(head,1,k);

    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev=null;

        ListNode temp = head;
        int i =1;
        while(temp!=null && left>1){
            if(i+1==left){
                prev = temp;
                break;
            }else{
                temp=temp.next;
                i++;
            }

        }
        ListNode curr;
        if(prev==null){
            curr=head;
        }else{
            curr=prev.next;
        }
        ListNode start = curr;
        ListNode end = prev;
        temp = curr;
        int j=0;
        while(j<right-left+1){
            temp=temp.next;
            curr.next=prev;
            prev=curr;
            curr=temp;

            j++;
        }
        if(end!=null){
            end.next=prev;
        }
        start.next=curr;
        if(left==1){
            return prev;
        }else{
            return head;
        }
    }
}
