package Thursday;
import Thursday.Node;
/**
 * 采用指针进行层序遍历，节省空间
 * @author dell
 *
 */
public class every2 {
    public Node connect(Node root) {
        Node head=root,tmp=root,cur=null;
        
        while(tmp!=null) {
        	//遍历该层时同时用一条新链记录下下一层的结点
        	head=new Node();
        	cur=head;
        	while(tmp!=null) {
        		if(tmp.left!=null) {
        			cur.next=tmp.left;
        			cur=cur.next;
        		}
        		if(tmp.right!=null) {
        			cur.next=tmp.right;
        			cur=cur.next;
        		}
        		tmp=tmp.next;
        	}
        	tmp=head.next;   //切换到下一层
        }
        
        return root;
    }

}
