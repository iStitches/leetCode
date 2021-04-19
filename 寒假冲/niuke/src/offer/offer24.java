package offer;

import java.util.ArrayList;

public class offer24 {
	ArrayList<Integer> list = new ArrayList();
	
    public int GetUglyNumber_Solution(int index) {
        list.add(1);
        list.add(2);
        list.add(3);
//        list.add(4);
//        list.add(5);
        int num = 4;
        while(list.size()<index) {
        	if((num%2==0 && list.contains(num/2) || (num%3==0 && list.contains(num/3) || (num%5==0 && list.contains(num/5)))))
        	{
        		list.add(num);
        	}
        	num++;
        }
        return list.get(index-1); 
    }
	
	public int GetUgly(int index) {
		if(index<=0)
			return 0;
		ArrayList<Integer> list = new ArrayList();
		int p2=0,p3=0,p5=0;
		list.add(1);
		
	    for(int i=0;i<index;i++) {
	    	int cur = Math.min(list.get(p2)*2, Math.min(list.get(p3)*3, list.get(p5)*5));
	    	list.add(cur);
	    	if(cur%2 == 0)
	    		p2++;
	    	if(cur%3 == 0)
	    		p3++;
	    	if(cur%5 == 0)
	    		p5++;
	    }
	    
	    return list.get(index-1);
	}
    	
    public static void main(String[] args) {
		offer24 t = new offer24();
		System.out.println(t.GetUglyNumber_Solution(1000));
//		System.out.println(t.GetUgly(1000));
	}
}
