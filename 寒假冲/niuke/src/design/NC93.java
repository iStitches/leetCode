package design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 **  设计LRU缓存结构，要求满足(1) set、get时间复杂度为O(1)；
 *                           (2)某个key的set或者get操作一旦发生，认为这个key就是最常使用的；
 *                           (3)当缓存大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 **  设计思路：可以通过模仿 LinkedHashMap来实现一个有顺序的HashMap哈希表，头部保留最近使用的，尾部保留最久未使用的。
 * @author dell
 *
 */
public class NC93 {
	//LinkedHashMap内部的结点是通过双向链表实现的
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
    
    //模拟一个 HashMap，结点类型为Node
    private Map<Integer,Node> map = new HashMap<Integer,Node>();
	private Node head = new Node(-1,-1);
	private Node tail = new Node(-1,-1);
	private int k;   //初始大小
	
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
	 ** 存值操作：
	 *     1.判断该key是否已经存在，存在的话直接覆盖
	 *     2.判断是否已满，满了先去除尾部(最近最少使用的)。
	 *     3.将当前值调整到首部
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
	 **  取值操作：
	 *       1.如果值存在，取出并且将该值放到链表首部，表示最近使用的；
	 *       2.如果不存在，返回 -1
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
	 ** 将某个结点移动到首部
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

