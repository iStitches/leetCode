package sword_offer;

public class ��ָ17 {
  /**
   * ���������ӡ----��� ��1�����nλ����������
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
	  //�������������е�λ��
		  String s = new String(num).substring(start);
		  res.append(s).append(",");
		  if(start+nine==n)
			  start--;
		  return;
	  }
	  //û�б�����ʹ洢��ǰλ��num������
	  for(char ch:loop) {
		  if(ch=='9')
			  nine++;
		  num[x] = ch;
		  dfs(x+1);
	  }
	  nine--;   //ע�������nine Ϊ9�ĸ�����ÿ�εݹ���ɺ�����1
  }
  
  public static void main(String[] args) {
	 ��ָ17 t= new ��ָ17();
	 t.printNumber(2);
}
}
