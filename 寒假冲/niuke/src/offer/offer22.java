package offer;

import java.util.ArrayList;
import java.util.Arrays;

public class offer22 {
    ArrayList<String> res = new ArrayList<String>();
    StringBuilder builder = new StringBuilder();
    boolean []used;
    
    public ArrayList<String> Permutation(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        used = new boolean[array.length];
        dfs(0,array);
        return res;
    }
    
    public void dfs(int len,char[] array){
        if(len == array.length){
            res.add(builder.toString());
            return;
        }
        for(int i=0;i<array.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0 && array[i]==array[i-1] && !used[i-1])
                continue;
            used[i] = true;
            builder.append(array[i]);
            dfs(len+1,array);
            used[i]=false;
            builder.deleteCharAt(builder.length()-1);
        }
    }
    public static void main(String[] args) {
		offer22 t = new offer22();
		ArrayList<String> res = t.Permutation("ab");
		System.out.println("sdfsd");
	}
}
