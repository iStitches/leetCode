package offer;

public class Test {
   
   //节点存储结构
   static class Node{   
	   String data;          //数据域
	   Node left;            //左指针
	   Node right;           //右指针
	   boolean isLeftThread = false;    //左指针域类型  false：指向子节点、true：前驱或后继线索
	   boolean isRightThread = false;   //右指针域类型  false：指向子节点、true：前驱或后继线索
	   Node(String data){
		   this.data = data;
	   }
   }
   
   /**
    * 通过数组构造一棵完全二叉树
    */
   static Node createBinaryTree(String[] array,int index) {
	   Node node = null;
	   if(index < array.length) {
		   node = new Node(array[index]);
		   node.left = createBinaryTree(array, index*2+1);
		   node.right = createBinaryTree(array, index*2+2);
	   }
	   return node;
   }
   
   private Node preNode = null;
   
   /**
    * 中序线索化二叉树
    */
   void inThreadOrder(Node node) {
	   if(node == null)
		   return;
	   //处理左子树
	   inThreadOrder(node.left);
	   
	   //处理根节点
	   if(node.left == null) {
		   node.left = preNode;
		   node.isLeftThread = true;
	   }
	   if(preNode!=null && preNode.right==null) {
		   preNode.right = node;
		   preNode.isRightThread = true;
	   }
	   preNode = node;
	   
	   //处理右子树
	   inThreadOrder(node.right);
   }
   
   /**
    * 中序遍历线索化二叉树，按照后继方式(找到最左节点开始)
    */
   void inThreadList(Node node) {
	   //找到最左节点
	   while(node!=null && !node.isLeftThread)
		   node = node.left;
	   
	   while(node != null) {
		   //遍历根节点
		   System.out.println(node.data);
		   
		   //如果右指针是线索，直接切换
		   if(node.isRightThread)
			   node = node.right;
		   
		   //如果右指针不是线索，则找到右子树对应左子树的线索
		   else {
			   node = node.right;
			   while(node!=null && !node.isLeftThread)
				   node = node.left;
		   }
	   }
   }
   
   /**
    * 中序遍历二叉树，按照前驱方式(找到最右节点开始)
    */
   void preThreadList(Node node) {
	   //找到最右节点
	   while(node!=null && !node.isRightThread)
		   node = node.right;
	   
	   while(node != null) {
		   //遍历根节点
		   System.out.println(node.data);
		   
		   //如果左指针是线索
		   if(node.isLeftThread)
			   node = node.left;
		   
		   else {
			   node = node.left;
			   while(node.right!=null && !node.isRightThread)
				   node = node.right;
		   }
	   }
   }
   
   /**
    * 前序线索化二叉树
    */
   void preThreadOrder(Node node) {
	   if(node == null)
		   return;
 
	   //处理当前根节点
	   if(node.left == null) {
		   node.left = preNode;
		   node.isLeftThread = true;
	   }
	   if(preNode.right==null && !preNode.isRightThread) {
		   preNode.right = node;
		   preNode.isRightThread = true;
	   }
	   preNode = node;
	   
	   //处理左子树
	   if(!node.isLeftThread)
		   preThreadOrder(node.left);
	   //处理右子树
	   if(!node.isRightThread)
		   preThreadOrder(node.right);
   }
}
