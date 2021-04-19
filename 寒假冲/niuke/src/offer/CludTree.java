package offer;

public class CludTree {
	//定义一个前驱节点
	Node preNode = null;
	
	//定义节点结构
    static class Node{
    	String data;
    	Node left;
    	Node right;
    	boolean isLeftThread = false;   //左指针域类型  false：指向子节点、true：前驱或后继线索
    	boolean isRightThread = false;  //右指针域类型  false：指向子节点、true：前驱或后继线索
    	Node(String data){
    		this.data = data;
    	}
    }
    
    //定义线索化二叉树的构造方法
    static Node createTree(String[] array,int index) {
    	Node node = null;
    	if(index < array.length) {
    		node = new Node(array[index]);
    		node.left = createTree(array,index*2+1);
    		node.right = createTree(array,index*2+2);
    	}
    	return node;
    }
    
    //中序线索化二叉树
    void inThreadOrder(Node node) {
    	if(node == null)
    		return;
    	inThreadOrder(node.left);
    	
    	if(preNode!=null && preNode.right == null) {
    		preNode.right = node;
    		preNode.isRightThread = true;
    	}
    	if(node.left == null) {
    		node.isLeftThread = true;
    		node.left = preNode;
    	}
    	preNode = node;
    	
    	inThreadOrder(node.right);
    }
    
    //前序线索化二叉树
    void preThreadOrder(Node node) {
    	if(node == null)
    		return;
    	if(node.left == null) {
    		node.left = preNode;
    		node.isLeftThread = true;
    	}
    	if(preNode!=null && preNode.right == null) {
    		preNode.right = node;
    		preNode.isRightThread = true;
    	}
    	preNode = node;
    	
    	if(!node.isLeftThread)
    	    preThreadOrder(node.left);
    	if(!node.isRightThread)
    	    preThreadOrder(node.right);
    }
    
    //中序遍历线索化二叉树（后继方式-----从最左往右遍历）
    /**
     * 想法：1.先找到最左边的节点，然后遍历当前的节点；
     *    2.检查当前节点的 isRightThread是不是线索；
     *    3.如果是线索，直接切换到线索对应的点；
     *    4.如果不是线索，找到右子树 为根的最左边的节点。
     * @param node
     */
    void inThreadList(Node node) {
    	while(node!=null && !node.isLeftThread) {
    		node = node.left;
    	}
    	while(node!=null) {
    		System.out.println(node.data);
    		//右子树是线索
    		if(node.isRightThread)
    			node = node.right;
    		//右子树不是线索，则找到右子树的开始点
    		else {
    			node = node.right;
    			while(node!=null && !node.isLeftThread)
    				node = node.left;
    		}
    	}
    }
    
    //中序线索化二叉树遍历（前驱方式----从最右往左遍历）
    /**
     * 想法：
     * 1.先找到二叉树的最右节点；
     * 2.遍历当前节点；
     * 3.如果当前节点的左指针是线索，直接切换；
     * 4.如果左指针不是线索，找到左节点的最右节点；
     * @param node
     */
    void inPreThreadList(Node node) {
    	while(node!=null && !node.isRightThread)
    		node = node.right;
    	while(node!=null) {
    		System.out.println(node.data);
    		
    		if(node.isLeftThread)
    			node = node.left;
    		else {
    			node = node.left;
    			while(node!=null && !node.isRightThread)
    				node = node.right;
    		}
    	}
    }
}
