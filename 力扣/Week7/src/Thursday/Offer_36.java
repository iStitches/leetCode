package Thursday;


class Node{
	public int val;
	public Node left;
	public Node right;
	public Node() {};
	public Node(int _val) {
		val=_val;
	}
	public Node(int _val,Node _left,Node _right) {
		val=_val;
		left=_left;
		right=_right;
	}
}


public class Offer_36 {
Node pre=null,head=null;
	
    public Node treeToDoublyList(Node root) {
          dfs(root);
          if(pre!=null){
            head.left=pre;
            pre.right=head;
          }            
          return head;
    }  
    
    /**
     * ��cur��pre�ֱ��¼��ǰ������һ��λ�� 
     * ֪ʶ�㣺   ���ı��������е�ǰ׺��¼����ÿһ�α����ĵ�ǰ�㿴��cur����pre�ĳ�ʼֵ��Ϊnull
     * �����ǰ� ��-��-�һ���  ��-��-�� ���� ��-��-��  �����ڱ���������ʱ�����pre��cur����ز���
     * @param cur  
     */
    public void dfs(Node cur) {
    	if(cur == null)
    		return;
        dfs(cur.left);
        if(pre != null)   //���pre��Ϊ�գ�������pre���ұ�
        	pre.right=cur;
        else {
        	head=cur;     //��preΪ�յ�ʱ��˵����ʱΪ��������������Сֵ----head
        }
        cur.left=pre;     //����cur�����
        pre=cur;          //����pre
        dfs(cur.right);
    }
    
    public static void main(String[] args) {
		Node r1=new Node(1);
		Node r2=new Node(2);
		Node r3=new Node(3);
		Node r4=new Node(4);
		Node r5=new Node(5);
		r2.left=r1;
		r2.right=r3;
		r4.left=r2;
		r4.right=r5;
		Offer_36 t=new Offer_36();
		t.treeToDoublyList(r4);
	}
}
