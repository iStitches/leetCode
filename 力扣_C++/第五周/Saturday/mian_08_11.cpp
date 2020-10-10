#include<iostream>
#include<vector>
using namespace std;

class mian_08_11{
public:
	int res = 0;
	int waysToChange(int n) {
		vector<int> choice{ 25,10,5,1 };
		dfs(0, n, choice);
		return res;
	}

	void dfs(int begin, int count,vector<int> choice){
		if (count == 0)
		{
			res++;
			return;
		}
        
		if (count < 0)
			return;
		for (int i = begin; i < choice.size(); i++){
			dfs(i, count - choice[i], choice);
		}
	}
};

int main(){
	mian_08_11 t;
	int res=t.waysToChange(10);
	int a = 2;
}