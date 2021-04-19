#include<iostream>
#include<algorithm>
#include<string>

using namespace std;

class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int len3 = s3.length();
        int len1 = s1.length();
        int len2 = s2.length();
        if(len3 != len1+len2)
           return false;
        
        auto f = vector<vector<int> >(len1+1,vector<int>(len2+1,false));
        f[0][0] = true;
        for(int i=0;i<len1;i++){
        	if(s3[i] == s1[i])
        	    f[i][0] = true;
            else
                break;
		}
		for(int i=0;i<len2;i++){
        	if(s3[i] == s2[i])
        	    f[0][i] = true;
            else
                break;
		}
		
		for(int i=1;i<len1;i++){
			for(int j=1;j<len2;j++){
				f[i][j] |= (f[i-1][j] && s1[i-1]==s3[i+j-1]);
				f[i][j] |= (f[i][j-1] && s2[j-1]==s3[i+j-1]);
			}
		}
		return f[len1][len2];
    }
};

int main(){
	Solution s;
    string s1 = "aabcc";
    string s2 = "dbbca";
    string s3 = "aadbbcbcac";
	cout<<s.isInterleave(s1,s2,s3);
}
