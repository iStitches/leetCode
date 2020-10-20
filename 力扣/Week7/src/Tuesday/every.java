package Tuesday;

class ListNode{
	int val;
	ListNode next;
	ListNode (){}
	ListNode(int x){this.val=x;}
	ListNode(int x,ListNode next){this.val=x;this.next=next;}
}

public class every {
    public void reorderList(ListNode head) {
        
    	if(head==null || head.next==null)
    		return;

    	//用快慢指针找到中间点
        ListNode h1=head,h2=head;
        while(h1.next!=null && h1.next.next!=null) {
        	h1=h1.next.next;
        	h2=h2.next;
        }
    	
    	
    	//将后段链表倒置
    	ListNode afterhead=h2.next,cur=afterhead,pre=new ListNode(),next=null;
    	pre.next=afterhead;
    	h2.next=null;   //前段链表掐断
    	while(cur.next!=null) {
    		next=cur.next;
    		cur.next=next.next;
    		next.next=pre.next;
    		pre.next=next;
    	}
    	afterhead=pre.next;
    	
    	//隔一个插入
    	ListNode firsthead=head;
    	while(afterhead!=null) {
    		ListNode first=firsthead.next;
    		firsthead.next=afterhead;
    		ListNode second=afterhead.next;
    		afterhead.next=first;
    		firsthead=first;
    		afterhead=second;
    	}
    }
    public static void main(String[] args) {
		ListNode h1=new ListNode(1);
		ListNode h2=new ListNode(2);
		ListNode h3=new ListNode(3);
		ListNode h4=new ListNode(4);
		ListNode h5=new ListNode(5);
		h1.next=h2;
		h2.next=h3;
		h3.next=h4;
		h4.next=h5;
		every t=new every();
		t.reorderList(h1);
	}
}
