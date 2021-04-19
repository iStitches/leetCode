package sword_offer;

public class ½£Ö¸18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode thead = new ListNode(0);
        ListNode temp=head,pre=thead;
        while(temp!=null && temp.val!=val){
            pre.next = temp;
            pre = temp;
            temp = temp.next;
        }
        if(temp != null)
            pre.next = temp.next;
        return thead.next;
   }
    public static void main(String[] args) {
		ListNode h1 =new ListNode(4);
		ListNode h2 =new ListNode(5);
		ListNode h3 =new ListNode(1);
		ListNode h4 =new ListNode(9);
		h1.next=h2;
		h2.next=h3;
		h3.next=h4;
		½£Ö¸18 t= new ½£Ö¸18();
		ListNode res = t.deleteNode(h1, 5);
	}
}
