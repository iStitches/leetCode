package sword_offer;

public class 剑指24 {
	/**
	 * 头插法
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        // 新链表的头结点
        ListNode newhead = null;
        // 用于遍历链表的指针
        ListNode p = head;
        while(p != null){
            // 保存p的下一个位置
            ListNode temp = p.next;
            p.next = newhead;
            // newhead始终为头结点
            newhead = p;
            p = temp;
        }
        return newhead;
    }
}
