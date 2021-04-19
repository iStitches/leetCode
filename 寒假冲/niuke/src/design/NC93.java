package design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 **  ���LRU����ṹ��Ҫ������(1) set��getʱ�临�Ӷ�ΪO(1)��
 *                           (2)ĳ��key��set����get����һ����������Ϊ���key�����ʹ�õģ�
 *                           (3)�������С����Kʱ���Ƴ������ʹ�õļ�¼����set��get���Զ�ġ�
 **  ���˼·������ͨ��ģ�� LinkedHashMap��ʵ��һ����˳���HashMap��ϣ��ͷ���������ʹ�õģ�β���������δʹ�õġ�
 * @author dell
 *
 */
public class NC93 {
	//LinkedHashMap�ڲ��Ľ����ͨ��˫������ʵ�ֵ�
    static class Node{
    	Node pre,next;
    	int key,value;
		public Node(int key, int value) {
			super();
			this.pre=null;
			this.next=null;
			this.key = key;
			this.value = value;
		}
    	
    }
    
    //ģ��һ�� HashMap���������ΪNode
    private Map<Integer,Node> map = new HashMap<Integer,Node>();
	private Node head = new Node(-1,-1);
	private Node tail = new Node(-1,-1);
	private int k;   //��ʼ��С
	
	public int[] LRU (int[][] operators, int k) {
		head.next = tail;
		tail.pre = head;
		this.k = k;
		int len = (int)Arrays.stream(operators).filter(x -> x[0] == 2).count();
		int[] res = new int[len];
		int index = 0;

		for(int[] operator:operators) {
			switch(operator[0]) {
				case 1: set(operator[1],operator[2]);break;
				case 2: {
					int tmpres = get(operator[1]);
					res[index++] = tmpres;
				}
			}
		}
		return res;
	}
	
	/**
	 ** ��ֵ������
	 *     1.�жϸ�key�Ƿ��Ѿ����ڣ����ڵĻ�ֱ�Ӹ���
	 *     2.�ж��Ƿ�������������ȥ��β��(�������ʹ�õ�)��
	 *     3.����ǰֵ�������ײ�
	 * @param key
	 * @param value
	 */
	public void set(int key,int value) {
		if(map.containsKey(key))
			map.get(key).value = value;
		else {
			if(map.size() == k) {
				int rk = tail.pre.key;
				tail.pre.pre.next = tail;
				tail.pre = tail.pre.pre;
				map.remove(rk);
			}
			Node node = new Node(key,value);
			map.put(key,node);
			moveToHead(node);
		}
	}
	
	/**
	 **  ȡֵ������
	 *       1.���ֵ���ڣ�ȡ�����ҽ���ֵ�ŵ������ײ�����ʾ���ʹ�õģ�
	 *       2.��������ڣ����� -1
	 * @param key
	 * @return
	 */
	public int get(int key) {
		if(map.containsKey(key)) {
			Node tmp = map.get(key);
			tmp.pre.next = tmp.next;
			tmp.next.pre = tmp.pre;
			moveToHead(tmp);
			return tmp.value;
		}
		return -1;
	}
	
	/**
	 ** ��ĳ������ƶ����ײ�
	 * @param node
	 */
	public void moveToHead(Node node) {
		node.next = head.next;
		node.next.pre = node;
		head.next = node;
		node.pre = head;
	}
	
	public static void main(String[] args) {
		int[][] operator = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
		NC93 t= new NC93();
		int[] res = t.LRU(operator, 3);
		System.out.println(Arrays.toString(res));
	}
	
}

