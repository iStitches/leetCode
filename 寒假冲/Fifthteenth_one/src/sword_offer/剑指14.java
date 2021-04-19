package sword_offer;

/**
 * ��̬�滮---�Ե����Ͻⷨ
 * @author dell
 *
 */
public class ��ָ14 {
	public int cuttingRope(int n) {
		if(n==2)
			return 1;
		if(n==3)
			return 2;
		// res ���������Ϊi �����ӵ����˻�
		// ע��res[2]��ʱΪ2��Ϊ1����Ϊ���ӳ��ȴ�ʱ����3����ô������ֵ��˳���Ϊ2��һ�ξͲ�Ӧ�ñ��и����ԭ���ӳ��ȼ���
		int []res = new int[n+1];
		res[0]=0;
		res[1]=1;
		res[2]=2;
		res[3]=3;
		for(int i=4;i<=n;i++) {
			int tempMax = 0;
			for(int j=1;j<=i/2;j++) {
				tempMax = Math.max(tempMax,res[j]*res[i-j]);
			}
			res[i] = tempMax;
		}
		return res[n];
	}
	
	public static void main(String[] args) {
		��ָ14 t = new ��ָ14();
		System.out.println(t.cuttingRope(10));
	}
}
