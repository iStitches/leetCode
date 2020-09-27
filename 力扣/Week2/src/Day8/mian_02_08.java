package Day8;

import java.util.HashSet;
import java.util.Set;

public class mian_02_08 {
	/**
	 * Hash���ط���
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
	   * ���еĽⷨ��˫ָ�뷽��----�ʺ���Ѱ�ҵ�����k����㡢����ڡ�����β�����
	   */
	  public ListNode detectCycle(ListNode head) {
		  ListNode h1=head,h2=head;
		  
		  //1. ��ָ��h2���ٶ���h1�ٶȵ�2��������л��Ļ�һ�����ཻ���������߹���·�̾�Ϊ������������
		  while(true) {
			  if(h2==null || h2.next==null)
				  return null;
			  h1=h1.next;
			  h2=h2.next.next;
			  if(h1==h2)
				  break;
		  }
		  //2. ��ʱh1�߹��ľ���Ϊ������n������ô����a��������ܵ��ﻷ����ڵ㣬��ʱ������h2�ŵ�����ͷ��ͬʱ����
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
