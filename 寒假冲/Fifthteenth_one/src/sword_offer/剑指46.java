package sword_offer;

public class ½£Ö¸46 {
    int count = 0;

    public int translateNum(int num) {
        String tmp = String.valueOf(num);
        char[] array = tmp.toCharArray();
        dfs(array.length,0,new StringBuilder(),array);
        return count;
    }
    
    public void dfs(int len,int depth,StringBuilder builder,char[] array){
        if(depth >= len){
            count++;
            return;
        }

        for(int i=depth;i<len;i++){
            char temp = (char) ('a'-'0'+array[i]);
            builder.append(temp);
            dfs(len,depth+1,builder,array);
            builder.deleteCharAt(builder.length()-1);
            if(i<len-1 && array[i]*10+array[i+1]<=25){
                temp = (char) ('a'-'0'+array[i]*10+array[i+1]);
                builder.append(temp);
                dfs(len,depth+2,builder,array);
                builder.delete(builder.length()-2,builder.length());
                i++;
            }
        }
    }
    
    public static void main(String[] args) {
		½£Ö¸46 t = new ½£Ö¸46();
		int res  = t.translateNum(12258);
		System.out.println(res);
	}
}
