package offer;

public class Test {
   
   //�ڵ�洢�ṹ
   static class Node{   
	   String data;          //������
	   Node left;            //��ָ��
	   Node right;           //��ָ��
	   boolean isLeftThread = false;    //��ָ��������  false��ָ���ӽڵ㡢true��ǰ����������
	   boolean isRightThread = false;   //��ָ��������  false��ָ���ӽڵ㡢true��ǰ����������
	   Node(String data){
		   this.data = data;
	   }
   }
   
   /**
    * ͨ�����鹹��һ����ȫ������
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
    * ����������������
    */
   void inThreadOrder(Node node) {
	   if(node == null)
		   return;
	   //����������
	   inThreadOrder(node.left);
	   
	   //������ڵ�
	   if(node.left == null) {
		   node.left = preNode;
		   node.isLeftThread = true;
	   }
	   if(preNode!=null && preNode.right==null) {
		   preNode.right = node;
		   preNode.isRightThread = true;
	   }
	   preNode = node;
	   
	   //����������
	   inThreadOrder(node.right);
   }
   
   /**
    * ������������������������պ�̷�ʽ(�ҵ�����ڵ㿪ʼ)
    */
   void inThreadList(Node node) {
	   //�ҵ�����ڵ�
	   while(node!=null && !node.isLeftThread)
		   node = node.left;
	   
	   while(node != null) {
		   //�������ڵ�
		   System.out.println(node.data);
		   
		   //�����ָ����������ֱ���л�
		   if(node.isRightThread)
			   node = node.right;
		   
		   //�����ָ�벻�����������ҵ���������Ӧ������������
		   else {
			   node = node.right;
			   while(node!=null && !node.isLeftThread)
				   node = node.left;
		   }
	   }
   }
   
   /**
    * �������������������ǰ����ʽ(�ҵ����ҽڵ㿪ʼ)
    */
   void preThreadList(Node node) {
	   //�ҵ����ҽڵ�
	   while(node!=null && !node.isRightThread)
		   node = node.right;
	   
	   while(node != null) {
		   //�������ڵ�
		   System.out.println(node.data);
		   
		   //�����ָ��������
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
    * ǰ��������������
    */
   void preThreadOrder(Node node) {
	   if(node == null)
		   return;
 
	   //����ǰ���ڵ�
	   if(node.left == null) {
		   node.left = preNode;
		   node.isLeftThread = true;
	   }
	   if(preNode.right==null && !preNode.isRightThread) {
		   preNode.right = node;
		   preNode.isRightThread = true;
	   }
	   preNode = node;
	   
	   //����������
	   if(!node.isLeftThread)
		   preThreadOrder(node.left);
	   //����������
	   if(!node.isRightThread)
		   preThreadOrder(node.right);
   }
}
