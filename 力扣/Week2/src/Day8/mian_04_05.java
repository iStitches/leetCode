package Day8;

import java.util.ArrayList;
import java.util.List;

public class mian_04_05 {
	/**
	 * �ҵĽⷨ
	 * @param args
	 */
//    public boolean isValidBST(TreeNode root) {
//         //1.����������ѽ���洢��list������
//    	 List<Integer> list=new ArrayList();
//    	 inorder(root,list);
//    	 
//    	 //2.�жϼ����Ƿ��������
//    	 for(int i=0;i<list.size()-1;i++) {
//    		 if(list.get(i)>=list.get(i+1))
//    			 return false;
//    	 }
//    	 return true;
//    }
//    
//    public void inorder(TreeNode root,List<Integer> result) {
//    	if(root == null)
//    		return;
//    	inorder(root.left,result);
//    	result.add(root.val);
//    	inorder(root.right,result);
//    }
	
	/**
	 * ���еĽⷨ
	 * @param args
	 */
	public boolean isValidBST(TreeNode root) {
	    return inorder(root,true);
	}
	
	public boolean inorder(TreeNode cur,boolean flag) {
	    if( cur==null || (cur.left==null && cur.right==null) || flag==false)
	    {
	    	return flag;
	    }
	    
	    //����Ƚϵ�ǰ��������ӽڵ�Ĵ�С
	    if(cur.left!=null && cur.val<=cur.left.val)
	    	flag=false;
	    if(cur.right!=null && cur.val>=cur.right.val)
	    	flag=false;
	    flag=inorder(cur.left,flag);
	    flag=inorder(cur.right,flag);
	    return flag;
	}
    
    public static void main(String[] args) {
		TreeNode h1=new TreeNode(5);
		TreeNode h2=new TreeNode(1);
		TreeNode h3=new TreeNode(6);
		TreeNode h4=new TreeNode(4);
		TreeNode h5=new TreeNode(7);
		
		h1.left=h2;
		h1.right=h3;
		h3.left=h4;
		h3.right=h5;
		h1.left=h2;
		h1.right=h3;
		
		mian_04_05 t=new mian_04_05();
		System.out.println(t.isValidBST(h1));
	  
	}
}
