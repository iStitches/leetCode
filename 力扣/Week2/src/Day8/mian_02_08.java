package Day8;

import java.util.HashSet;
import java.util.Set;

public class mian_02_08 {
	/**
	 * Hash求重方法
	 * @param head
	 * @return
	 */
//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> set=new HashSet();
//        boolean flag=true;
//        ListNode h=head;
//        
//        while(flag) {
//        	if(h == null) {
//        		flag=false;
//        		break;
//        	}
//        	if(!set.add(h)) {
//        		break;
//        	}
//        	h=h.next;
//        }
//        
//        if(flag) {
//        	return h;
//        }
//        else
//        	return null;
//    }
	  /**
	   * 大佬的解法：双指针方法----适合于寻找倒数第k个结点、环入口、公共尾部入口
	   */
	  public ListNode detectCycle(ListNode head) {
		  ListNode h1=head,h2=head;
		  
		  //1. 让指针h2的速度是h1速度的2倍，如果有环的话一定会相交并且两者走过的路程均为环长的整数倍
		  while(true) {
			  if(h2==null || h2.next==null)
				  return null;
			  h1=h1.next;
			  h2=h2.next.next;
			  if(h1==h2)
				  break;
		  }
		  //2. 此时h1走过的距离为环长的n倍，那么再走a个距离就能到达环的入口点，此时不妨将h2放到链表开头，同时减速
		  h2=head;
		  while(h1 != h2)
		  {
			  h1=h1.next;
			  h2=h2.next;
		  }
		  return h2;
	  }
	  public static void main(String[] args) {
		ListNode h1=new ListNode(1);
		ListNode h2=new ListNode(2);
//		ListNode h3=new ListNode(0);
//		ListNode h4=new ListNode(-4);
		h1.next=h2;
//		h2.next=h3;
//		h3.next=h4;
//		h4.next=h2;
		
		mian_02_08 t=new mian_02_08();
		t.detectCycle(h1);
	}
}
