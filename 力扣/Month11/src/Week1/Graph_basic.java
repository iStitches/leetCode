package Week1;

/**
 * ��ͼ�����ֹ��췽ʽ�� �ڽӱ���ڽӾ���
 * @author dell
 *
 */
public class Graph_basic {
    /**
     * �ڽӱ�
     */
	
}


/**
 * �ڽӾ���
 */
class Graph1<E>{
	private E []vexs;
	private int [][]edges;
	private int numOfVexs;
	private int numOfEdges;
	private boolean[] isVisited;
	
	public static void main(String[] args) {
		
	}
}

 
/**
 * �ڽӱ�
 */
class Graph2<E>{
	//���㣺  ���� ������+ͷָ����
	private static class VNode<E>{
		E data;  //������
		ENode firstAdj; //�ڽӱ��һ�����
	}
	
	//��Ӧ�����㣺  ����  �ڽӶ������+Ȩֵ+��һ���ڽӱ���
	private static class ENode{
		int adjvex; //�������
		int weight; //Ȩֵ
		ENode nextadj; //��һ���ڽӱ���
	}
}