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
     * 用cur、pre分别记录当前结点和上一个位置 
     * 知识点：   数的遍历过程中的前缀记录，将每一次遍历的当前点看成cur，将pre的初始值置为null
     * 不管是按 左-根-右还是  根-左-右 还是 左-右-根  ，都在遍历到根的时候进行pre与cur的相关操作
     * @param cur  
     */
    public void dfs(Node cur) {
    	if(cur == null)
    		return;
        dfs(cur.left);
        if(pre != null)   //如果pre不为空，则连接pre的右边
        	pre.right=cur;
        else {
        	head=cur;     //当pre为空的时候说明此时为二叉排序树的最小值----head
        }
        cur.left=pre;     //连接cur的左侧
        pre=cur;          //更新pre
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
