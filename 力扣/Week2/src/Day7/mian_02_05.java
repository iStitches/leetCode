package Day7;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public class mian_02_05 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode result=null,head=null;
         int pre=0,cur=0,temp;  //进位，当前位
         ListNode h1=l1,h2=l2;
         while(h1!=null || h2!=null || pre!=0) {
        	 temp=0;
             if(h1 != null) {
            	 temp+=h1.val;
            	 h1=h1.next;
             }
             if(h2 != null) {
            	 temp+=h2.val;
            	 h2=h2.next;
             }
             temp+=pre;
        	 
        	 cur=temp%10;
        	 pre=temp/10;
             if(result == null) {
            	 result=new ListNode(cur);
            	 head=result;
             }
             else {
            	 ListNode node=new ListNode(cur);
            	 result.next=node;
            	 result=node;
             }
         }
         return head;
    }
    
    public static void main(String[] args) {
		mian_02_05 t=new mian_02_05();
		ListNode l1=new ListNode(5);
		ListNode l2=new ListNode(5);
//		ListNode l3=new ListNode(3);
//		
//		ListNode r1=new ListNode(5);
//		ListNode r2=new ListNode(6);
//		ListNode r3=new ListNode(4);
//		
//		l1.next=l2;
//		l2.next=l3;
//		
//		r1.next=r2;
//		r2.next=r3;
		t.addTwoNumbers(l1, l2);
	}
}
