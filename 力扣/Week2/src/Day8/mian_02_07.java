package Day8;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

public class mian_02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1=headA;
        ListNode h2=headB;
        //注意这里是判断对象的地址是否相等，不是判断值是否相等
        while(h1 != h2) {
        	if(h1 == null)
        		h1=headB;
        	else
        		h1=h1.next;
        	if(h2 == null)
        		h2=headA;
        	else
        		h2=h2.next;
        }
        return h1;
    }
    
    public static void main(String[] args) {
	}
}
