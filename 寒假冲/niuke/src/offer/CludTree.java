package offer;

public class CludTree {
	//����һ��ǰ���ڵ�
	Node preNode = null;
	
	//����ڵ�ṹ
    static class Node{
    	String data;
    	Node left;
    	Node right;
    	boolean isLeftThread = false;   //��ָ��������  false��ָ���ӽڵ㡢true��ǰ����������
    	boolean isRightThread = false;  //��ָ��������  false��ָ���ӽڵ㡢true��ǰ����������
    	Node(String data){
    		this.data = data;
    	}
    }
    
    //�����������������Ĺ��췽��
    static Node createTree(String[] array,int index) {
    	Node node = null;
    	if(index < array.length) {
    		node = new Node(array[index]);
    		node.left = createTree(array,index*2+1);
    		node.right = createTree(array,index*2+2);
    	}
    	return node;
    }
    
    //����������������
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
    
    //ǰ��������������
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
    
    //�����������������������̷�ʽ-----���������ұ�����
    /**
     * �뷨��1.���ҵ�����ߵĽڵ㣬Ȼ�������ǰ�Ľڵ㣻
     *    2.��鵱ǰ�ڵ�� isRightThread�ǲ���������
     *    3.�����������ֱ���л���������Ӧ�ĵ㣻
     *    4.��������������ҵ������� Ϊ��������ߵĽڵ㡣
     * @param node
     */
    void inThreadList(Node node) {
    	while(node!=null && !node.isLeftThread) {
    		node = node.left;
    	}
    	while(node!=null) {
    		System.out.println(node.data);
    		//������������
    		if(node.isRightThread)
    			node = node.right;
    		//�������������������ҵ��������Ŀ�ʼ��
    		else {
    			node = node.right;
    			while(node!=null && !node.isLeftThread)
    				node = node.left;
    		}
    	}
    }
    
    //����������������������ǰ����ʽ----���������������
    /**
     * �뷨��
     * 1.���ҵ������������ҽڵ㣻
     * 2.������ǰ�ڵ㣻
     * 3.�����ǰ�ڵ����ָ����������ֱ���л���
     * 4.�����ָ�벻���������ҵ���ڵ�����ҽڵ㣻
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
