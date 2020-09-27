package Day7;

import java.util.ArrayList;
import java.util.List;

public class mian_02_06 {
	/**
	 * 我的解法
	 * @param head
	 * @return
	 */
//    public boolean isPalindrome(ListNode head) {
//          List<Integer> list=new ArrayList();
//          while(head != null) {
//        	  list.add(head.val);
//        	  head=head.next;
//          }
//          
//          if(list.size() <= 1)
//              return true;
//          int i=0,j=list.size()-1;
//          boolean flag=true;
//          while(flag && i<=j) {
//        	  if(!list.get(i).equals(list.get(j)))
//                  flag=false;
//        	  i++;
//        	  j--;
//          }
//          return flag;
//    }
	
	/**
	 * 大佬的解法----快慢指针+部分链表反转
	 * @param args
	 */
	public boolean isPalindrome(ListNode head) {
         if(head==null)
            return true; 
	     ListNode center=center(head);
	     ListNode h2=reverse(center.next);
	     while(h2 != null) {
	    	 if(head.val != h2.val)
	    		 return false;
	    	 head=head.next;
	    	 h2=h2.next;
	     }
	     return true;
	}
	
	/**
	 * 快慢指针查找链表中点
	 * @param head
	 * @return
	 */
	public ListNode center(ListNode head) {
		ListNode fast=head,slow=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	} 
	
	/**
	 * 反转链表
	 * @param args
	 */
	public ListNode reverse(ListNode head) {
		ListNode prev=null,cur=head;
		while(cur != null) {
			ListNode temp=cur.next;
			cur.next=prev;
			prev=cur;
			cur=temp;
		}
		return prev;
	}
    
    public static void main(String[] args) {
		ListNode h1=new ListNode(129);
		ListNode h2=new ListNode(129);
		h1.next=h2;
		System.out.println(Integer.valueOf(129).equals(Integer.valueOf(129)));
		mian_02_06 t=new mian_02_06();
		t.isPalindrome(h1);
	}
}
