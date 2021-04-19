#include<iostream>
#include<vector>
using namespace std;

class Solution{
	public:
	    int numTrees(int n) {
	        if(n == 0)
	           return 0;
	        vector<int> G(n+1,0);
	        G[0] = G[1] = 1;
	        
	        for(int i=2;i<=n;i++){
	        	for(int j=1;j<=i;j++){
	        		G[i] += G[j-1]*G[i-j];
				}
			}
			return G[n];
	    }
}; 

int main(){
	Solution s;
	int res = s.numTrees(3);
	cout<<res;
}
