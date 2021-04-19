package sword_offer;

public class 剑指17 {
  /**
   * 大数问题打印----输出 从1到最大n位数的所有数
   * @param n
   * @return
   */
  StringBuilder res = new StringBuilder();
  int n,nine,start;
  char []num,loop= {'0','1','2','3','4','5','6','7','8','9'};
  public String printNumber(int n) {
	  this.n=n;
	  start = n-1;
	  nine = 0;
	  num = new char[n];
	  dfs(0);
	  System.out.println(res.toString());
	  return res.toString();
  }
  
  public void dfs(int x) {
	  if(x == n) {
	  //最后遍历完了所有的位数
		  String s = new String(num).substring(start);
		  res.append(s).append(",");
		  if(start+nine==n)
			  start--;
		  return;
	  }
	  //没有遍历完就存储当前位到num数组中
	  for(char ch:loop) {
		  if(ch=='9')
			  nine++;
		  num[x] = ch;
		  dfs(x+1);
	  }
	  nine--;   //注意这里的nine 为9的个数，每次递归完成后必须减1
  }
  
  public static void main(String[] args) {
	 剑指17 t= new 剑指17();
	 t.printNumber(2);
}
}
