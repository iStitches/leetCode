package sword_offer;

import java.util.ArrayList;

/** 
 ** 参数：  n：总的结点个数      m：每次删除间隔 
 ** 约瑟夫环问题：每一轮从现有的环中删除掉一个值，可以使用两种方法
 *   1.递归法，用一个ArrayList先存储所有人的序号；每轮删除的下标为idx，idx=(idx+m-1)%n；
 *   2.动态规划，参考https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/huan-ge-jiao-du-ju-li-jie-jue-yue-se-fu-huan-by-as/
 *         确定状态：dp[i]表示人数为i时最后存活的那个人对应的数字；
 *         转移方程：dp[i]=(dp[i-1]+m)%i
 *         确定边界：dp[1]=0;
 * @author dell
 *
 */
public class offer62 {
	//1.递归法
//    public int lastRemaining(int n, int m) {
//        int res =0,start=0;
//        ArrayList<Integer> list = new ArrayList();
//        for(int i=0;i<n;i++)
//            list.add(i);
//            
//        for(int j=n;j>1;j--){
//            for(int k=1;k<m;k++){
//                start = (start+1)>=j?(start+1)%j:start+1;
//            }
//            list.remove(start);
//        }
//        return list.get(0);
//    }
	
	//2.动态规划
	public int lastRemaining2(int n,int m) {
		int res = 0;
		for(int i=2;i<=n;i++) {
			res = (res+m)%i;
		}
		return res;
	}
    
    public static void main(String[] args) {
		offer62 t = new offer62();
		System.out.println(t.lastRemaining2(10, 17));
	}
}
