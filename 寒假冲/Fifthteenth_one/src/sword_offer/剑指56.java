package sword_offer;

import java.util.Arrays;

/**  ��Ŀ���ҳ�������������ͬ������(ֻ��2��)
 * * ˼·��λ���㣿
 * *         ��ͬ���������ĸ���������λ��ͬ���Լ����Լ�����һ��Ϊ0����ô����ܹ�����������ͬ����������򣬲�ͬ�������ڲ�ͬ������ܹ��õ������
 * *         ��˱���Ĺؼ����Ƕ�������з��飬��Ҫ������ͬ������ͬһ�顢��ͬ�����ڲ�ͬ��
 * *       ��η��飿
 * *         ������ͬ�����Ķ�����λ��һ��������һλ��ͬ������ͬ��������һλһ����ͬ����װ��һλ���з��飬�Ϳ��Խ�������Ҫ��
 * *         �ķ��顣
 * @author dell
 *
 */
public class ��ָ56 {
    public int[] singleNumbers(int[] nums) {
         //1.�Ƚ����е�����������������λ���Ǹ�1
    	 int ret = 0;
    	 for(int num:nums)
    		 ret = ret ^ num;
    	 
    	 //2.�ҵ����λΪ1��λ��
    	 int div = 1;
    	 while((div & ret)==0)
    		 div <<= 1;
    	 
    	 //3.���з���
    	 int a=0,b=0;
    	 for(int num:nums) {
    		 //�����ǰ������һλΪ1
    		 if((num & div)!=0)
    			 a ^= num;
    		 //��֮��ǰλΪ0
    		 else
    			 b ^= num;
    	 }
    	 return new int[] {a,b};
    }
//	public int[] singleNumbers(int[] nums) {
//        int ret = 0;
//        for (int n : nums) {
//            ret ^= n;
//        }
//        int div = 1;
//        while ((div & ret) == 0) {
//            div <<= 1;
//        }
//        int a = 0, b = 0;
//        for (int n : nums) {
//            if ((div & n) != 0) {
//                a ^= n;
//            } else {
//                b ^= n;
//            }
//        }
//        return new int[]{a, b};
//    }
	
	public static void main(String[] args) {
//		��ָ56 t = new ��ָ56();
//		int[] res = t.singleNumbers(new int[] {1,2,5,2});
//		System.out.println(Arrays.toString(res));
		int res=1;
		for(int i=0;i<5;i++)
			res <<=1;
	    System.out.println(res);
	}
}
