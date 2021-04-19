#include<iostream>
#include<stack>
#include<queue>
#include<map>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

struct Node{
	char data;
	int weight;
	Node(char _data,int _weight){
		data = _data;
		weight = _weight;
	} 
    friend bool operator < (const Node &a,const Node &b){
		return a.weight < b.weight;
	}
};


int main(){
//	stack<int> s;
//	for(int i=1;i<=5;i++)
//	    s.push(i);
//	cout<<"Õ»¶¥ÔªËØ£º"<<s.top();
//	while(!s.empty()) 
//	   cout<<s.top()<<endl;
    
//    queue<int> q;
//    for(int i=1;i<=4;i++)
//       q.push(i);
//       
//    while(!q.empty()){
//    	cout<<q.front()<<"  "<<q.back()<<endl;
//    	q.pop();
//	}
//
//    priority_queue<int> q;
//    q.push(2);
//    q.push(3);
//    q.push(1);
//    q.push(6);
//    q.push(4);
//    while(!q.empty()){
//    	cout<<q.top()<<" "<<endl; 
//    	q.pop(); 
//	}
//      priority_queue<Node> q;
//      Node node1('a',3);
//      Node node2('b',2);
//      Node node3('c',1);
//      q.push(node1);
//      q.push(node2);
//      q.push(node3);
//      
//    while(!q.empty()){
//    	cout<<q.top().weight<<" "<<endl; 
//    	q.pop(); 
//	}

//    map<int,string> map1;
//    map1.insert(pair<int,string>(1,"aaa"));
//    map1.insert(pair<int,string>(2,"bbb"));
//    map1.insert(pair<int,string>(3,"ccc"));
//    for(map<int,string>::iterator it = map1.begin();it != map1.end();it++){
//    	cout<<it->first<<"  "<<it->second<<endl;
//	}
//	if(map1.find(1) == map1.end())
//	   cout<<"Î´ÕÒµ½";
//	else{
//		map<int,string>::iterator it = map1.find(1);
//		cout<<it->first;
//		cout<<it->second; 
//	}
//	map1.erase(2);
	    
	  vector<int> a;
	  vector<int> b(5,3);
	  a.push_back(1);
	  a.push_back(5);
	  a.push_back(2);
	  a.push_back(3);
//	  for(int i=0;i<a.size();i++)
//	     cout<<a[i]<<endl;
//	  sort(a.begin(),a.end());
//	  for(int i=0;i<a.size();i++)
//	     cout<<a[i]<<endl;
	  reverse(a.begin(),a.end());
	      	  for(int i=0;i<a.size();i++)
	     cout<<a[i]<<endl;
	  vector<vector<int> > obj(5,vector<int>(4));
	  int idx = 1;
	  for(int i=0;i<5;i++){
	  	for(int j=0;j<4;j++)
		  obj[i][j] =  idx++;
	  }
	  	  for(int i=0;i<5;i++){
	  	for(int j=0;j<4;j++)
		  cout<<obj[i][j]<<"  ";
		  cout<<endl;
	  }
}
