package offer;

public class offer11 {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode pre = pHead;
        for(int i=1;i<=k;i++)
        {
            if(pre == null) return null;
            pre = pre.next;
        }
            
        while(pre!=null){
            pre = pre.next;
            pHead = pHead.next;
        }
        return pHead;
    }
}

class ListNode {
   int val;
   ListNode next = null;
   public ListNode(int val) {
   this.val = val;
  }
}