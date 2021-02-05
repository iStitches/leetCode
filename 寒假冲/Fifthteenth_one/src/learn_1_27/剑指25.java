package learn_1_27;

public class ½£Ö¸25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1),tmp = head;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                tmp.next = l2;
                l2 = l2.next;
            }
            else{
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }
        if(l1 != null)
           tmp.next = l1;
        if(l2 != null)
           tmp.next = l2;
        return head.next;
  }
    
    public static void main(String[] args) {
		½£Ö¸25 t = new ½£Ö¸25();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(4);
		l1.next=l2;
		l2.next=l3;
		
		ListNode r1=new ListNode(1);
		ListNode r2=new ListNode(3);
		ListNode r3=new ListNode(4);
		r1.next=r2;
		r2.next=r3;
		ListNode res=t.mergeTwoLists(l1,r1);
	    System.out.println("res");
	}
}
