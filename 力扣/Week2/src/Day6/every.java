package Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class  TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}

public class every {
	/**
	 * �ҵķ���
	 */
//	Map<Integer,Integer> map=new HashMap();
//	List<Integer> list=new ArrayList();
//	
//    public int[] findMode(TreeNode root) {
//    	traverse(root);
//    	int max=0,index=0;
//    	for(Map.Entry<Integer, Integer> key:map.entrySet()) {
//    		if(max<key.getValue())
//    			max=key.getValue();
//    	}
//    	
//    	for(Map.Entry<Integer, Integer>key:map.entrySet()) {
//    		if(key.getValue().equals(max)) {
//    			list.add(key.getKey());
//    		}
//    	}
//    	int arr[]=new int[list.size()];
//    	for(int i=0;i<arr.length;i++)
//    		arr[i]=list.get(i);
//    	return arr;
//    }
//    
//    public void traverse(TreeNode root) {
//    	if(root == null) {
//    		return;
//    	}
//    	map.put(root.val,map.get(root.val)==null?1:map.get(root.val)+1);
//        traverse(root.left);
//        traverse(root.right);
//    }
	
	/**
	 * ���еķ���
	 * @param pre:��ǰ������һ�����
	 * @param ret:�������
	 * @param recount:���������±�
	 * @param maxcount:���������ֵĴ���
	 * @param curcount:��ǰ�����ֵĴ���
	 */
	TreeNode pre=null;
	int ret[];
	int retcount=0;
	int maxcount=0;
	int curcount=0;
	public int[] findMode(TreeNode root) {
		//�������α���----��һ�α�����ȡ������ĳ��ȣ��ڶ��α�����ȡ�����ֵ
		traverse(root);
		ret=new int[retcount];
		//ˢ��ȫ�ֱ���
		pre=null;
		curcount=0;
		retcount=0;
		traverse(root);
		return ret;
	}
	
	//����BST����������������ܹ��õ�һ���������������
	public void traverse(TreeNode root) {
		if(root == null)
			return;
		traverse(root.left);
		//1.�Ƚϵ�ǰ����ֵ����һ������ֵ
		if(pre!=null && pre.val==root.val) {
			curcount++;
		}
		else {
			curcount=1;
		}
		//2.���������ִ���---�������
		if(maxcount < curcount) {
			maxcount=curcount;
			retcount=1;
		}
		//������ӵ�ǰֵ��ret����
		else if(maxcount == curcount) {
			if(ret!=null) {
				ret[retcount]=root.val;
			}
			retcount++;
		}
		pre=root;
		traverse(root.right);
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		TreeNode right1=new TreeNode(2);
		TreeNode left2=new TreeNode(2);
		root.right=right1;
		right1.left=left2;
		every t=new every();
		int arr[]=t.findMode(root);
		Arrays.toString(arr);
	}
}
