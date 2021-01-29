package Week1;

/**
 * ���鼯�Ĺ��졢�򵥵ķ���ʵ��
 */
public class InnerCollection {
	private final int SIZE=10;
    private int nums[];
    
    //��ʼ��n�����
    void Init(int n) {
    	for(int i=0;i<n;i++)
    		nums[i]=i;
    }
    
    //�ҳ���ǰ����������ĸ��ڵ�-----�����x=nums[x]
    int find(int x) {
    	if(x == nums[x])
    		return x;
    	return find(nums[x]);
    }
    
    //�ϲ��������
    void unit(int x,int y) {
    	x=find(x);
    	y=find(y);
    	if(x==y)
    		return;
    	nums[x]=y;
    }
    
    //�ж�x��y�Ƿ�ͬ����һ������
    boolean isSame(int x,int y) {
    	return find(x)==find(y);
    }
    
}
