package sword_offer;

import java.util.Stack;

public class 剑指33 {
	/**
	 * 方法一： 递归分治法
	 * 思路：后序遍历(左右根),同时该树又是一棵搜索树,右子树的值大小一定大于根,根的值的大小一定大于左子树；
	 *       那么可以先找到第一个大于根结点值的结点位置m，这个点也是左右子树的分界点。
	 *       这样就将结点划分为了左右子树，由于已经满足了左子树值均小于根节点的值，因此只需要满足右子树的值大于根节点。
	 */
	int []postorder=null;
    public boolean verifyPostorder(int[] postorder) {
        this.postorder=postorder;
        return compare(0,postorder.length-1);
    }
    
    /**
     * @param i:  (i,m-1) 左子树
     * @param m   (m,j-1) 右子树
     * @param j   根节点
     * @return    当子树只有一个结点时直接退出
     */
    public boolean compare(int i,int j) {
    	// 子树只有一个结点直接返回true
    	if(i>=j)
    		return true;
    	// 找到左右子树的分界点---- 第一个大于根节点的结点位置
    	int p=i;
    	while(postorder[p]<postorder[j]) p++;
    	// 找到后需要保证结点右子树的所有结点值都大于根节点的值
    	int m=p;
    	while(postorder[p]>postorder[j]) p++;
    	return (p==j)&&compare(i,m-1)&&compare(m,j-1);
    }
    
    /**
     * 方法二： 辅助栈法
     * 思路： 由于后序遍历(左右根)的倒序(根右左)  为先序遍历(根左右)的镜像。那么其值也存在一定的关系。
     * 对于倒序数组 {Rn,Rn-1,Rn-2,....,R1}
     * 当节点值 Rn-1>Rn时，Rn-1一定为Rn的右结点；
     * 当结点值 Rn-1<Rn时，Rn-1为root(在Rn~Rn-1中)的左节点；
     * 解决： 因此考虑使用辅助栈的方法来解决。
     *   1.借助一个单调栈 stack来存储值递增的结点；
     *   2.每当遇到值递减的结点时，通过出栈来更新root；
     *   3.每轮都判断Ri和root的关系，初始时root为无穷大
     *          如果 Ri<root，合理，继续；
     *          如果 Ri>root，不合理，返回false;
     * @param args
     */
    public boolean verifyPostorder2(int[] postorder) {
    	Stack<Integer> stack =new Stack();
    	int root = Integer.MAX_VALUE;
    	for(int i=postorder.length-1;i>=0;i--) {
    		 if(postorder[i]>root) return false;
    		 
    		 //当碰到递减的情况，不断出栈来更新root
    		 while(!stack.isEmpty() && stack.peek()>postorder[i])
    		 { 
    			 root=stack.pop(); 
    		 }
    	     stack.push(postorder[i]);
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		剑指33 t = new 剑指33();
		int[] arr = new int[] {1,3,2,6,5};
		System.out.println(t.verifyPostorder(arr));
	}
}
