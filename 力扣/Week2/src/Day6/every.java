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
	 * 我的方法
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
	 * 大佬的方法
	 * @param pre:当前结点的上一个结点
	 * @param ret:结果数组
	 * @param recount:结果数组的下标
	 * @param maxcount:当先最多出现的次数
	 * @param curcount:当前结点出现的次数
	 */
	TreeNode pre=null;
	int ret[];
	int retcount=0;
	int maxcount=0;
	int curcount=0;
	public int[] findMode(TreeNode root) {
		//采用两次遍历----第一次遍历获取结果集的长度，第二次遍历获取结果的值
		traverse(root);
		ret=new int[retcount];
		//刷新全局变量
		pre=null;
		curcount=0;
		retcount=0;
		traverse(root);
		return ret;
	}
	
	//对于BST树，采用中序遍历能够得到一个升序的有序序列
	public void traverse(TreeNode root) {
		if(root == null)
			return;
		traverse(root.left);
		//1.比较当前结点的值和上一个结点的值
		if(pre!=null && pre.val==root.val) {
			curcount++;
		}
		else {
			curcount=1;
		}
		//2.更新最多出现次数---清空数组
		if(maxcount < curcount) {
			maxcount=curcount;
			retcount=1;
		}
		//否则添加当前值进ret数组
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
