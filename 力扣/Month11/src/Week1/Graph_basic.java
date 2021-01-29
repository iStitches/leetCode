package Week1;

/**
 * 对图的两种构造方式： 邻接表和邻接矩阵
 * @author dell
 *
 */
public class Graph_basic {
    /**
     * 邻接表
     */
	
}


/**
 * 邻接矩阵
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
 * 邻接表
 */
class Graph2<E>{
	//顶点：  包括 顶点域+头指针域
	private static class VNode<E>{
		E data;  //顶点域
		ENode firstAdj; //邻接表第一个结点
	}
	
	//对应链表顶点：  包括  邻接顶点序号+权值+下一个邻接表顶点
	private static class ENode{
		int adjvex; //顶点序号
		int weight; //权值
		ENode nextadj; //下一个邻接表顶点
	}
}