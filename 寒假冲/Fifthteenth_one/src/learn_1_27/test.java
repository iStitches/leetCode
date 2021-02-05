package learn_1_27;

public class test {
	 public void binaryToDecimal(int n){
	      String str = "";
	      while(n!=0){
	          str = n%2+str;
	          n = n/2;
	      }
	          System.out.println(str);
	 }
	 
	 public void binaryToDecimal2(int n){
	      for(int i = 31;i >= 0; i--)
	          System.out.print(n >>> i & 1);
	 }
	 public static void main(String[] args) {
		test t = new test();
		t.binaryToDecimal(8);
		t.binaryToDecimal2(128);
	}
}
