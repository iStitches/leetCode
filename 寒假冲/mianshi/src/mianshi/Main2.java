package mianshi;

import java.util.Scanner;

public class Main2 {
   public static int[] value;
   public static int[][] edge;
   public static boolean[] visited;
   public static int[] lowcost;
   public static int n,t;
	
   public static void main(String[] args) {
	Main2 f = new Main2();
	Scanner sc =new Scanner(System.in);
	n=sc.nextInt();
	t= sc.nextInt();
	value = new int[n+1];
	edge = new int[n+1][n+1];
	
	for(int i=1;i<=n;i++) {
		value[i] = sc.nextInt();
	}
	for(int i=0;i<t;i++) {
		int s = sc.nextInt();
		int e = sc.nextInt();
		int v = sc.nextInt();
		edge[s][e] = v;
	}
	
	visited = new boolean[n+1];
	lowcost = new int[n+1];
	for(int i=1;i<=n;i++) {
		lowcost[i] = edge[1][i];
	}

}
   
   public void find(int curValue) {
	   int max=0,maxId;
	   for(int i=1;i<=n;i++) {
		   if(max < lowcost[i]) {
			   max = lowcost[i];
			   maxId = i;
		   }
	   }
	   
   }
}
