#include<iostream>
#include<vector>
using namespace std;

class mian_08_09{
public:
	vector<string> generateParenthesis(int n) {
		vector<string> res;
		string tmp;
		dfs(res, tmp, n, n);
		return res;
	}

	//��ȱ���+���ݷ�
	/*
	   �����ŷ�Ϊ���������ã����ҵĸ�����ͬ���ӿյĸ�����������һ�ö�������
	   ����һ����������ʾ�ڽ��ĩβ���һ�������ţ�
	   ����һ����������ʾ�ڽ��ĩβ���һ�������ţ�
	   ����ֻ�е���������������������ʱ���ܽ������ŵķ��ã�
	   ��������������Ϊ0��ʱ�򣬷��ý���
	 */
	void dfs(vector<string>& res, string& tmp, int left, int right){
		//�����������������0  [�����˳�]
		if (left == 0 && right == 0)
		{
			res.push_back(tmp);
			return;
		}
		//���������� < �������� [��֦]
		if (left > right){
			return;
		}

		//�����Ż��У��ȷ���������
		if (left > 0)  //�������ﴫ�ݵ������ã�ȫ�ֶ���ֻ��һ��tmp�����������Ҫ���ݣ�����������ã���ô����Ҫÿ������һ���µ��ַ�������ݹ飬�ǾͲ���Ҫ����
		{
			tmp.push_back('(');
			dfs(res, tmp, left - 1, right);
			tmp.pop_back();
		}
		
        //�����Ż��У��ٷ���������
		if (right > 0)
		{
			tmp.push_back(')');
			dfs(res, tmp, left, right - 1);
			tmp.pop_back();
		}
	}
};