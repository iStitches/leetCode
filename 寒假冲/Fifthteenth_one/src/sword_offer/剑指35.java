package sword_offer;

import java.util.HashMap;
import java.util.Map;

public class 剑指35 {
	/**
	 * 拷贝链表，需要先将所有的结点都拷贝一份，然后再去处理next和random指针的关系.
	 * 建立键值对 Map<Node,Node> 来模拟关系
	 * @param head
	 * @return
	 */
//    public Node copyRandomList(Node head) {
//    	Node cur = head;
//        Map<Node,Node> map=new HashMap();
//        //1. 复制拷贝结点
//        while(cur!=null) {
//        	map.put(head, new Node(cur.val));
//        	cur=cur.next;
//        }
//        //2. 建立关系
//        cur=map.get(head);
//        
//    }
//}
//
//class Node {
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
}