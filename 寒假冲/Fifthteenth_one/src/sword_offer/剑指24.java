package sword_offer;

public class ��ָ24 {
	/**
	 * ͷ�巨
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        // �������ͷ���
        ListNode newhead = null;
        // ���ڱ��������ָ��
        ListNode p = head;
        while(p != null){
            // ����p����һ��λ��
            ListNode temp = p.next;
            p.next = newhead;
            // newheadʼ��Ϊͷ���
            newhead = p;
            p = temp;
        }
        return newhead;
    }
}
