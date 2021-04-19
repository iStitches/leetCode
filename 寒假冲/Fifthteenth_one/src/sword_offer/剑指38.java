package sword_offer;

import java.util.ArrayList;
import java.util.Arrays;

public class ½£Ö¸38 {
    ArrayList<String> list = new ArrayList<String>();
    boolean[] flag;

    public String[] permutation(String s) {
        if(s==null || s.length()==0)
           return null;

        char[] array = s.toCharArray();
        flag = new boolean[array.length];
        Arrays.sort(array);
        dfs(array,0,new StringBuilder());
        return list.toArray(new String[list.size()]);
    }

    public void dfs(char[] array,int depth,StringBuilder builder){
        if(depth == array.length){
            list.add(builder.toString());
            return;
        }

        for(int i=0;i<array.length;i++){
            if(!flag[i]){
                if(i>0 && array[i] == array[i-1] && !flag[i-1])
                   continue;
                flag[i] = true;
                builder.append(array[i]);
                dfs(array,depth+1,builder);
                flag[i] = false;
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }
    
    public static void main(String[] args) {
		½£Ö¸38 t= new ½£Ö¸38();
		String[] res = t.permutation("aab");
		System.out.println(Arrays.toString(res));
		
	}
}
