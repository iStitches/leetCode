package Wednesday;

import java.util.Arrays;

public class mian_10_11 {
          /**
           * ����һ�������������ԣ���������е����ְ��� ��-��-�� �����У�ÿ�α�������ǰλ�ã���ʹ��Ҫ���н���Ҳֻ��ʹ��
           * ����ߵ�ֵԽ��ԽС/Խ��Խ�������ñ�֤������ķ������
           */
		    public void wiggleSort(int[] nums) {
		      Arrays.sort(nums);
		      for(int i=1;i<nums.length;i++)
		      {
		    	  //�涨����λ��Ϊ�塢ż��λ��Ϊ��
		    	  if(nums[i]<nums[i-1] && i%2!=0)
		    	  {
		    		  int temp=nums[i];
		    		  nums[i]=nums[i-1];
		    		  nums[i-1]=temp;
		    	  }
		    	  else if(nums[i]>nums[i-1] && i%2==0)
		    	  {
		    		  int temp=nums[i];
		    		  nums[i]=nums[i-1];
		    		  nums[i-1]=temp;
		    	  }
		      }
		}
}
