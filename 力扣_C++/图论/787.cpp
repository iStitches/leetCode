#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>

#define MAX_VALUE 0x7fffffff
#define MAX_SIZE 1000
using namespace std;

int n,a,b,c,src,dst,k;
int graph[MAX_SIZE][MAX_SIZE];
int res = MAX_VALUE;
bool visited[MAX_SIZE];

void dfs(int src,int dst,int k,int price){
	if(src == dst){
		res = price;
		return;
	}
	if(k == 0)
	    return;
	for(int i=0;i<n;i++){
		if(graph[src][i]>0 && !visited[i]){
			if(price+graph[src][i]<=res){
				visited[i]=true;
				dfs(i,dst,k-1,price+graph[src][i]);
				visited[i]=false;
			}
		}
	}
}

int main(){
	cin>>n;
	memset(graph,0,sizeof(graph));
	memset(visited,false,sizeof(visited));
	for(int i=0;i<n;i++)
	{
		cin>>a>>b>>c;
		graph[a][b]=c;
	}
	cin>>src>>dst>>k;
	dfs(src,dst,k+1,0);
	if(res == MAX_VALUE) cout<<-1;
	else cout<<res;
}

