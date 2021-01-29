package Week1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test {
	Scanner sc=new Scanner(System.in);
	int T;  //测试次数
	int N;  //人员编号
	int m;  //关系数
	int node[]; //并查集
	
	void res() {
		T=sc.nextInt();
		for(int i=0;i<T;i++) {
		    N=sc.nextInt();
		    node=new int[N+1];
		    init();
		    m=sc.nextInt();
		    for(int j=0;j<m;j++) {
		    	int start=sc.nextInt();
		    	int end=sc.nextInt();
		    	union(start, end);
		    }
		    Set<Integer> set=new HashSet();
		    int res=0;
		    for(int k=1;k<=N;k++) {
		    	if(set.add(find(k)))
		    		res++;
		    }
		    System.out.println(res);
		}
	}
	
	void init() {
		for(int i=1;i<=N;i++)
			node[i]=i;
	}
	int find(int x) {
		if(node[x]==x)
			return x;
		return find(node[x]);
	}
	void union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x==y)
			return;
		node[x]=y;
	}
	
    public static void main(String[] args) {
    	test t=new test();
    	t.res();
}
}
