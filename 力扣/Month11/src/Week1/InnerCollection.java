package Week1;

/**
 * 并查集的构造、简单的方法实现
 */
public class InnerCollection {
	private final int SIZE=10;
    private int nums[];
    
    //初始化n个结点
    void Init(int n) {
    	for(int i=0;i<n;i++)
    		nums[i]=i;
    }
    
    //找出当前结点所在树的根节点-----根结点x=nums[x]
    int find(int x) {
    	if(x == nums[x])
    		return x;
    	return find(nums[x]);
    }
    
    //合并两个结点
    void unit(int x,int y) {
    	x=find(x);
    	y=find(y);
    	if(x==y)
    		return;
    	nums[x]=y;
    }
    
    //判断x和y是否同属于一个集合
    boolean isSame(int x,int y) {
    	return find(x)==find(y);
    }
    
}
