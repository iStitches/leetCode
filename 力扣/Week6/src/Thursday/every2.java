package Thursday;
import Thursday.Node;
/**
 * ����ָ����в����������ʡ�ռ�
 * @author dell
 *
 */
public class every2 {
    public Node connect(Node root) {
        Node head=root,tmp=root,cur=null;
        
        while(tmp!=null) {
        	//�����ò�ʱͬʱ��һ��������¼����һ��Ľ��
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
        	tmp=head.next;   //�л�����һ��
        }
        
        return root;
    }

}
