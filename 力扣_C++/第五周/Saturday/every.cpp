#include<iostream>
using namespace std;

struct ListNode{
	int val;
	ListNode* next;
	ListNode(int x) : val(x), next(NULL){}
};

class every {
public:
	/*
	题解：首先假设指针A和指针B，A的速度是B的2倍，那么路程 f=2s；
	      而指针A走过的路程比指针B快n个圆周长c；
		  f-s=nc; f=2s；
		  联立可以得出s=nc、f=2nc；
		  而一个从初始点出发的链表经过入口再次到达入口走过的路程：  m=l+nc；
		  总结可以得出 B 指针在相遇时总是走过nc，从相遇点再走l距离就可以到达入口，此时可以再次通过快慢指针来操作得到入口点的位置。
	 */

	ListNode *detectCycle(ListNode *head) {
		ListNode *h1=head, *h2=head;
		bool flag = false;
		if (h1 == NULL)
			return NULL;
		//1.首先寻找第一个相遇的结点，h1指针快，h2指针慢
		while (h1->next != NULL && h1->next->next!=NULL && h2->next != NULL){
			h1 = h1->next->next;
			h2 = h2->next;
			if (h1 == h2){
				flag = true;
				break;
			}
		}

		//2.找到后再通过移动找到环的入口点
		if (flag){
			h1 = head;
			while (h1 != h2){
				h1 = h1->next;
				h2 = h2->next;
			}
			return h1;
		}
		return NULL;
	}
};

int main(){
	ListNode *h1=new ListNode(1);
	ListNode *h2 = new ListNode(2);
	h1->next = h2;
	h2->next = h1;
	every t;
	t.detectCycle(h1);
}