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
	��⣺���ȼ���ָ��A��ָ��B��A���ٶ���B��2������ô·�� f=2s��
	      ��ָ��A�߹���·�̱�ָ��B��n��Բ�ܳ�c��
		  f-s=nc; f=2s��
		  �������Եó�s=nc��f=2nc��
		  ��һ���ӳ�ʼ�����������������ٴε�������߹���·�̣�  m=l+nc��
		  �ܽ���Եó� B ָ��������ʱ�����߹�nc��������������l����Ϳ��Ե�����ڣ���ʱ�����ٴ�ͨ������ָ���������õ���ڵ��λ�á�
	 */

	ListNode *detectCycle(ListNode *head) {
		ListNode *h1=head, *h2=head;
		bool flag = false;
		if (h1 == NULL)
			return NULL;
		//1.����Ѱ�ҵ�һ�������Ľ�㣬h1ָ��죬h2ָ����
		while (h1->next != NULL && h1->next->next!=NULL && h2->next != NULL){
			h1 = h1->next->next;
			h2 = h2->next;
			if (h1 == h2){
				flag = true;
				break;
			}
		}

		//2.�ҵ�����ͨ���ƶ��ҵ�������ڵ�
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