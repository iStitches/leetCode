package sword_offer;

import java.util.ArrayList;

/** 
 ** ������  n���ܵĽ�����      m��ÿ��ɾ����� 
 ** Լɪ�����⣺ÿһ�ִ����еĻ���ɾ����һ��ֵ������ʹ�����ַ���
 *   1.�ݹ鷨����һ��ArrayList�ȴ洢�����˵���ţ�ÿ��ɾ�����±�Ϊidx��idx=(idx+m-1)%n��
 *   2.��̬�滮���ο�https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/huan-ge-jiao-du-ju-li-jie-jue-yue-se-fu-huan-by-as/
 *         ȷ��״̬��dp[i]��ʾ����Ϊiʱ�������Ǹ��˶�Ӧ�����֣�
 *         ת�Ʒ��̣�dp[i]=(dp[i-1]+m)%i
 *         ȷ���߽磺dp[1]=0;
 * @author dell
 *
 */
public class offer62 {
	//1.�ݹ鷨
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
	
	//2.��̬�滮
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
