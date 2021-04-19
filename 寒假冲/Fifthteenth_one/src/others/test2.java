package others;

public class test2 {
	public int orchestraLayout(int num, int xPos, int yPos) {
        int top=0,down=num-1,left=0,right=num-1,i=top,j=left,tmp=1,m;

        boolean flag = false;
        
        while(true){
        	for(m=left;m<=right;m++) {
        		j=m;
        		if(i==xPos && j==yPos) {
        			return tmp;
        		}
        		tmp=(tmp+1)%9;
        		tmp=tmp==0?9:tmp;
        	}
        	top++;
        	if(top>down) break;
        	
        	for(m=top;m<=down;m++) {
        		i=m;
        		if(i==xPos && j==yPos) {
        			return tmp;
        		}
        		tmp=(tmp+1)%9;
        		tmp=tmp==0?9:tmp;
        	}
        	right--;
        	if(right<left)break;
        	
        	for(m=right;m>=left;m--) {
        		j=m;
        		if(i==xPos && j==yPos) {
        			return tmp;
        		}
        		tmp=(tmp+1)%9;
        		tmp=tmp==0?9:tmp;
        	}
        	down--;
        	if(down<top)break;
        	
        	for(m=down;m>=top;m--) {
        		i=m;
        		if(i==xPos && j==yPos) {
        			return tmp;
        		}
        		tmp=(tmp+1)%9;
        		tmp=tmp==0?9:tmp;
        	}
        	left++;
        	if(left>right)break;
        }
        
        return tmp;
    }
	
	public static void main(String[] args) {
		test2 t =new test2();
		int res=t.orchestraLayout(4,2,1);
		System.out.println(res);
	}
}
