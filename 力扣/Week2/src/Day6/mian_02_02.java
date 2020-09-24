package Day6;


class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}
public class mian_02_02 {
    public int kthToLast(ListNode head, int k) {
        ListNode pre=head,cur=head;
        for(int i=1;i<=k;i++) {
        	cur=cur.next;
        }
        
        while(cur != null) {
        	cur=cur.next;
        	pre=pre.next;
        }
        return pre.val;
    }
}
