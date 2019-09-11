/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/9/11
 */
#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

// 方法一：两次遍历
// 倒数第n个节点，就是正数第k-n个节点

class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        if (!head)
            return head;
        //添加一个头结点，方便删除第一个结点
        ListNode *p = new ListNode(0);
        p->next = head;
        ListNode *q = p;//保存头指针
        int k = 0;
        while (head){
            k++;
            head = head->next;
        }
        int cur = k - n;
        int i = 0;
        while (i < cur && p){//找到被删除结点的前一个结点
            p = p->next;
            i++;
        }
        if (p && p->next)
            p->next = p->next->next;
        return q->next;
    }
};