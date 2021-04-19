package sword_offer;

public class offer58 {
    public String reverseWords(String s) {
        if(s==null || s.length()==0)
           return s;
        String[] arr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
             String tmp = arr[i];
             if(tmp!=null && tmp.length()!=0){
                 builder.append(tmp).append(" ");
             }
        }
        if(builder.length()!=0)
           builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }
    
    public static void main(String[] args) {
		offer58 t = new offer58();
		System.out.println(t.reverseWords(" "));
	}
}
