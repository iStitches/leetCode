package Day6;

public class mian_02_04 {
	/**
	 * 我的写法
	 * @param args
	 */
//    public ListNode partition(ListNode head, int x) {
//          if(head == null)
//        	  return head;
//          ListNode cur=head.next,pre=head;
//          while(cur != null) {
//        	  //当前点比x小----插入到头部 + 改变头节点
//        	  if(cur!=null && cur.val < x) {
//        		  pre.next=cur.next;
//        		  cur.next=head;
//        		  head=cur;
//        		  cur=pre.next;
//        	  }
//        	  else {
//        		  pre=cur;
//        		  cur=cur.next;
//        	  }
//          }
//          return head;
//    }
	
	/**
	 * 大佬的写法
	 * @param args
	 */
	   public ListNode partition(ListNode head, int x) {
	        if(head == null)
	            return null;
	        
	        ListNode curNode = head;
	        while(curNode.next != null){
	            if(curNode.next.val < x){
	                ListNode tmp = curNode.next;
	                curNode.next = curNode.next.next;
	                tmp.next = head;
	                head = tmp;
	            }
	            else
	                curNode = curNode.next;
	        }
	        
	        return head;
	    }
    
    public static void main(String[] args) {
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(4);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(2);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(2);
		t1.next=t2;
		t2.next=t3;
		t3.next=t4;
		t4.next=t5;
		t5.next=t6;
		mian_02_04 t=new mian_02_04();
		t.partition(t1, 3);
	}
}
