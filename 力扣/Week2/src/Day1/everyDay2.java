package Day1;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode  47��ȫ����(����+��֦)
 * @author dell
 *
 */
public class everyDay2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
          Arrays.sort(nums);
          
          List<List<Integer>> result=new ArrayList<List<Integer>>();
          Deque<Integer> queue=new ArrayDeque();
          boolean used[]=new boolean[nums.length]; 
          dfs(nums,0,result,queue,used);
          return result;
    }
    
    /**
     * @param nums     ������
     * @param depth    ��ǰ�����е�Ԫ�ظ���
     * @param result   ���ֵ
     * @param queue    ��ʱ����
     * @param used     ��¼ÿһ���ѭ��----ͨ����¼�Ƿ�ʹ�ù���ִ��
     * @return
     */
    public void dfs(int []nums,int depth,List<List<Integer>> result,Deque<Integer> queue,boolean []used){
        //�����������ȫ����ֹͣ
    	if(depth == nums.length) {
    		result.add(new ArrayList(queue));
    	}
    
    	//����ѭ����ǰ��
    	for(int i=0;i<nums.length;i++) {
    		if(used[i])
    			continue;
    		
    		//��֦----ǰ����ȣ�ǰһ��δ��ʹ�ù�
    		if(i>0 && nums[i] == nums[i-1] && !used[i-1]) {
    			continue;
    		}
    		
    		//������ȱ���
    		queue.add(nums[i]);
    		used[i]=true;
    		dfs(nums,depth+1,result,queue,used);
    		
    		//�����޸�״̬
    		queue.removeLast();
    		used[i]=false;
    	}
    }
}
