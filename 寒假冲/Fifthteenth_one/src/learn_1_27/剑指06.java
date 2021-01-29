package learn_1_27;

import java.util.List;
import java.util.ArrayList;

public class ½£Ö¸06 {
    public int[] reversePrint(ListNode head) {
        ListNode p2=head,tempPrev=null,tempAfter=null;
        ListNode p1 = new ListNode(0);
        while(p2!=null){
            tempPrev=p1.next;
            p1.next=p2;
            tempAfter=p2.next;
            p2.next=tempPrev;
            p2=tempAfter;
        }
        head = p1.next;
        List<Integer> list = new ArrayList();
        while(head!=null) {
        	list.add(head.val);
        	head=head.next;
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
   }
    public static void main(String[] args) {
		½£Ö¸06 t= new ½£Ö¸06();
		ListNode head = new ListNode(1);
		ListNode h1 = new ListNode(3);
		ListNode h2 = new ListNode(2);
		head.next=h1;
		h1.next=h2;
	}
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
