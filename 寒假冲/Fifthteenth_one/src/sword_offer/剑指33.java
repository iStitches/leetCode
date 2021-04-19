package sword_offer;

import java.util.Stack;

public class ��ָ33 {
	/**
	 * ����һ�� �ݹ���η�
	 * ˼·���������(���Ҹ�),ͬʱ��������һ��������,��������ֵ��Сһ�����ڸ�,����ֵ�Ĵ�Сһ��������������
	 *       ��ô�������ҵ���һ�����ڸ����ֵ�Ľ��λ��m�������Ҳ�����������ķֽ�㡣
	 *       �����ͽ���㻮��Ϊ�����������������Ѿ�������������ֵ��С�ڸ��ڵ��ֵ�����ֻ��Ҫ������������ֵ���ڸ��ڵ㡣
	 */
	int []postorder=null;
    public boolean verifyPostorder(int[] postorder) {
        this.postorder=postorder;
        return compare(0,postorder.length-1);
    }
    
    /**
     * @param i:  (i,m-1) ������
     * @param m   (m,j-1) ������
     * @param j   ���ڵ�
     * @return    ������ֻ��һ�����ʱֱ���˳�
     */
    public boolean compare(int i,int j) {
    	// ����ֻ��һ�����ֱ�ӷ���true
    	if(i>=j)
    		return true;
    	// �ҵ����������ķֽ��---- ��һ�����ڸ��ڵ�Ľ��λ��
    	int p=i;
    	while(postorder[p]<postorder[j]) p++;
    	// �ҵ�����Ҫ��֤��������������н��ֵ�����ڸ��ڵ��ֵ
    	int m=p;
    	while(postorder[p]>postorder[j]) p++;
    	return (p==j)&&compare(i,m-1)&&compare(m,j-1);
    }
    
    /**
     * �������� ����ջ��
     * ˼·�� ���ں������(���Ҹ�)�ĵ���(������)  Ϊ�������(������)�ľ�����ô��ֵҲ����һ���Ĺ�ϵ��
     * ���ڵ������� {Rn,Rn-1,Rn-2,....,R1}
     * ���ڵ�ֵ Rn-1>Rnʱ��Rn-1һ��ΪRn���ҽ�㣻
     * �����ֵ Rn-1<Rnʱ��Rn-1Ϊroot(��Rn~Rn-1��)����ڵ㣻
     * ����� ��˿���ʹ�ø���ջ�ķ����������
     *   1.����һ������ջ stack���洢ֵ�����Ľ�㣻
     *   2.ÿ������ֵ�ݼ��Ľ��ʱ��ͨ����ջ������root��
     *   3.ÿ�ֶ��ж�Ri��root�Ĺ�ϵ����ʼʱrootΪ�����
     *          ��� Ri<root������������
     *          ��� Ri>root������������false;
     * @param args
     */
    public boolean verifyPostorder2(int[] postorder) {
    	Stack<Integer> stack =new Stack();
    	int root = Integer.MAX_VALUE;
    	for(int i=postorder.length-1;i>=0;i--) {
    		 if(postorder[i]>root) return false;
    		 
    		 //�������ݼ�����������ϳ�ջ������root
    		 while(!stack.isEmpty() && stack.peek()>postorder[i])
    		 { 
    			 root=stack.pop(); 
    		 }
    	     stack.push(postorder[i]);
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		��ָ33 t = new ��ָ33();
		int[] arr = new int[] {1,3,2,6,5};
		System.out.println(t.verifyPostorder(arr));
	}
}
