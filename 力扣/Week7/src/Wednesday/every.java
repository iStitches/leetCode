package Wednesday;

public class every {
    public boolean isLongPressedName(String name, String typed) {
         int i=0,j=0,countA=0,countB=0;
         char arrayA[]=name.toCharArray();
         char arrayB[]=typed.toCharArray();
         int len1=name.length(),len2=typed.length();
         
         while(i<len1 && j<len2) {
        	 char tmp=arrayA[i];
        	 while(i<len1 && arrayA[i]==tmp)
        	 {
        		 countA++;
        		 i++;
        	 }
        	 while(j<len2 && arrayB[j]==tmp)
        	 {
        		 countB++;
        		 j++;
        	 }
        	 if(countA>countB)
        		 return false;
        	 countA=countB=0;
         }
         if(i<len1) {
        	 for(;i<len1;i++) {
        		 if(arrayA[i]!=arrayB[j-1])
        			 return false;
        	 }
         }
         if(j<len2) {
        	 for(;j<len2;j++) {
        		 if(arrayB[j]!=arrayA[i-1])
        			 return false;
        	 }
         }
         
         return true;
    }
    
    public static void main(String[] args) {
		String name="pyplrz";
		String typed="ppyypllr";
		every t=new every();
		t.isLongPressedName(name, typed);
		
	}
}
