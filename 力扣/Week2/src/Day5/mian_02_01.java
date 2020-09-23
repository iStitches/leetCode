package Day5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}
public class mian_02_01 {
	/**
	 * 我的解法
	 */
//    public ListNode removeDuplicateNodes(ListNode head) {
//         List<Integer> list=new ArrayList();
//         ListNode pre=head,cur=head;
//         while(cur!=null) {
//        	 //不包含就添加
//        	 if(!list.contains(cur.val)) {
//        		 list.add(cur.val);
//            	 pre=cur;
//            	 cur=cur.next;
//        	 }
//        	 //包含则移除---往后多移动几位
//        	 else {
//        		 while(cur.next.val == cur.val) {
//        			 cur=cur.next;
//        		 }
//        		 //截断
//        		 cur=cur.next;
//        		 pre.next=cur;
//        	 }
//        	 
//         }
//         return head;
//    }
	/**
	 * 官方解法-----设置一个set集合来记录遍历到的值,如果加入成功就继续移动到下一个点,如果加入失败就跳过下一个点
	 */
	public ListNode removeDeplicateNodes(ListNode head) {
		if(head == null)
			return head;
		Set<Integer> sets=new HashSet();
		sets.add(head.val);
		//pre代表前驱结点，cur代表后续结点
		ListNode pre=head,cur=head;
		while(pre.next != null) {
			cur=pre.next;
			
			//如果添加成功则说明没有重复，继续下一个点
			if(sets.add(cur.val)) {
				pre=pre.next;
			}
			//如果添加失败就说明重复了，跳过当前点
			else {
				pre=pre.next.next;
			}
		}
		return head;
		
	}
}
