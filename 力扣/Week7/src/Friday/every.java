package Friday;

class ListNode {
     int val;
     ListNode next;
    ListNode(int x) { val = x; }
 }

public class every {
    public boolean isPalindrome(ListNode head) {
    	if(head==null || head.next==null)
    		return true;
    	//双指针找到链表中点 ----h2为前一段终点
    	ListNode h1=head,h2=head;
    	while(h1.next!=null && h1.next.next!=null) {
    		h1=h1.next.next;
    		h2=h2.next;
    	}
    	
    	//将后一段反转
    	ListNode head2=new ListNode(0),cur=h2.next;
    	head2.next=cur;
    	while(cur.next!=null) {
    		ListNode next=cur.next;
    		cur.next=next.next;
    		next.next=head2.next;
    		head2.next=next;
    	}
    	
    	//再次遍历
    	head2=head2.next;
    	while(head!=null) {
    		if(head2.val!=head.val)
    			return false;
    		head=head.next;
    		head2=head2.next;
    	}
    	return false;
    	
   }
    public static void main(String[] args) {
		every t=new every();
		ListNode h1=new ListNode(0);
		ListNode h2=new ListNode(0);
		h1.next=h2;
		t.isPalindrome(h1);
	}
}
