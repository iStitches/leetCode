#include<iostream>
#include<vector>
using namespace std;

class  mian_08_02{
public:
	vector<vector<int>> pathWithObstacles(vector<vector<int>>& obstacleGrid) {
		vector<vector<int>> res;
		int leny = obstacleGrid.size();
		int lenx = obstacleGrid[0].size();
		if (leny == 0 || lenx == 0)
			return res;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[leny - 1][lenx - 1] == 1)
			return res;
		bool visit[1000][1000]={false};
		dfs(0, 0, obstacleGrid, res,visit);
		return res;
	}

	bool dfs(int x, int y, vector<vector<int>>& obstacleGrid,vector<vector<int>>& path,bool visit[1000][1000]){
		//�����������ľ�����
		if (x > obstacleGrid.size()-1 || y > obstacleGrid[0].size()-1 || obstacleGrid[x][y] || visit[x][y])
			return false;
		//���ʵ�ǰ���---�޸�visit + ��ӵ�path
		path.push_back(vector < int > {x, y});
		visit[x][y] = true;
		//�ҵ������ֹ
		if (y == obstacleGrid[0].size() - 1 && x == obstacleGrid.size() - 1)
			return true;
		//û���ҵ�������
		if (dfs(x + 1, y, obstacleGrid, path, visit) || dfs(x, y + 1, obstacleGrid, path, visit))
			return true;
		//��ǰ�����Ҿ�û�ҵ�---����
		path.pop_back();
		return false;
	}
};

int main(){
	mian_08_02 t;
	vector<vector<int>> test = { { 0, 0, 0 }, { 0, 1, 0 }, {0,0,0} };
	vector<vector<int>> temp=t.pathWithObstacles(test);
	int a = 9;
}