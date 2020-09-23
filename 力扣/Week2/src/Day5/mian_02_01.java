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
	 * �ҵĽⷨ
	 */
//    public ListNode removeDuplicateNodes(ListNode head) {
//         List<Integer> list=new ArrayList();
//         ListNode pre=head,cur=head;
//         while(cur!=null) {
//        	 //�����������
//        	 if(!list.contains(cur.val)) {
//        		 list.add(cur.val);
//            	 pre=cur;
//            	 cur=cur.next;
//        	 }
//        	 //�������Ƴ�---������ƶ���λ
//        	 else {
//        		 while(cur.next.val == cur.val) {
//        			 cur=cur.next;
//        		 }
//        		 //�ض�
//        		 cur=cur.next;
//        		 pre.next=cur;
//        	 }
//        	 
//         }
//         return head;
//    }
	/**
	 * �ٷ��ⷨ-----����һ��set��������¼��������ֵ,�������ɹ��ͼ����ƶ�����һ����,�������ʧ�ܾ�������һ����
	 */
	public ListNode removeDeplicateNodes(ListNode head) {
		if(head == null)
			return head;
		Set<Integer> sets=new HashSet();
		sets.add(head.val);
		//pre����ǰ����㣬cur����������
		ListNode pre=head,cur=head;
		while(pre.next != null) {
			cur=pre.next;
			
			//�����ӳɹ���˵��û���ظ���������һ����
			if(sets.add(cur.val)) {
				pre=pre.next;
			}
			//������ʧ�ܾ�˵���ظ��ˣ�������ǰ��
			else {
				pre=pre.next.next;
			}
		}
		return head;
		
	}
}
