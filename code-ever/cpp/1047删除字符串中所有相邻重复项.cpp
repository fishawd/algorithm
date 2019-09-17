/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/7/23
 */
#include <iostream>
#include <stack>
using namespace std;

// 1047.删除字符串中所有的相邻重复项

class Solution {
public:
    string removeDuplicates(string S) {
        stack<char> stack;
        string string1;
        string string2;
        for(char str : S){
            if(!stack.empty()){
                if (stack.top() == str)
                    stack.pop();
                else
                    stack.push(str);
            } else{
                stack.push(str);
            }
        }
        while (!stack.empty()){
            string1 += stack.top();
            stack.pop();
        }
        for(int i = string1.size()-1; i >= 0 ; i--)
            string2 += string1[i];
        return string2;
    }
};