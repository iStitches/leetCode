package Sunday;

class ListNode{
	int val;
	ListNode next;
	ListNode(){};
	ListNode(int x){this.val=x;}
	ListNode(int x,ListNode next){this.val=x;this.next=next;}
}

public class every {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h1=head,h2=head,pre=null;
        for(int i=0;i<n;i++) {
       	 h1=h1.next;
        }
        if(h1==null)
            return head.next;
        while(h1!=null) {
       	 h1=h1.next;
       	 pre=h2;
       	 h2=h2.next;
        }
        pre.next=h2.next;
        return head;
    }
}
