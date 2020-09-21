package Day2;

public class every2 {

    public boolean oneEditAway(String first, String second) {
    	  int distinct=Math.abs(first.length()-second.length());
    	  
          if(distinct >= 2)
        	  return false;

          else{
              int i,j;
              i=j=0;
              int count=0;
              while(i<first.length() && j<second.length() && count<=1) {
            	  if(first.charAt(i) == second.charAt(j)) {
            		  i++;
            		  j++;
            		  continue;
            	  }
            	  count++;
            	  if(j+1<second.length()  && first.charAt(i) == second.charAt(j+1)) {
            		  i++;
            		  j+=2;
            	  }
            	  else if(i+1<second.length() && first.charAt(i+1) == second.charAt(j) ) {
            		  j++;
            		  i+=2;
            	  }
            	  else {
            		  i++;
            		  j++;
            	  }
            	  if(count==2)
            		  break;
              }
              if(count>=2)
            	  return false;
              return true;
          }
    }
    
    public static void main(String[] args) {
		every2 test=new every2();
		System.out.println(test.oneEditAway("ab","bc"));
	}
    
}
