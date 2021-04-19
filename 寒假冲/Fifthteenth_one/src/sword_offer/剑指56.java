package sword_offer;

import java.util.Arrays;

/**  题目：找出数组中两个不同的数字(只有2个)
 * * 思路：位运算？
 * *         相同的两个数的各个二进制位相同，自己和自己异或后一定为0。那么如果能够将数组中相同的数进行异或，不同的数分在不同的组就能够得到结果；
 * *         因此本题的关键就是对数组进行分组，需要满足相同的数在同一组、不同的数在不同组
 * *       如何分组？
 * *         两个不同的数的二进制位中一定至少有一位不同，而相同的数的这一位一定相同。安装这一位进行分组，就可以进行满足要求
 * *         的分组。
 * @author dell
 *
 */
public class 剑指56 {
    public int[] singleNumbers(int[] nums) {
         //1.先将所有的数都异或来查找最低位的那个1
    	 int ret = 0;
    	 for(int num:nums)
    		 ret = ret ^ num;
    	 
    	 //2.找到最低位为1的位置
    	 int div = 1;
    	 while((div & ret)==0)
    		 div <<= 1;
    	 
    	 //3.进行分组
    	 int a=0,b=0;
    	 for(int num:nums) {
    		 //如果当前数字这一位为1
    		 if((num & div)!=0)
    			 a ^= num;
    		 //反之当前位为0
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
//		剑指56 t = new 剑指56();
//		int[] res = t.singleNumbers(new int[] {1,2,5,2});
//		System.out.println(Arrays.toString(res));
		int res=1;
		for(int i=0;i<5;i++)
			res <<=1;
	    System.out.println(res);
	}
}
