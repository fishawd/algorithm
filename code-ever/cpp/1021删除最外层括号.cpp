/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/7/23
 */
#include <iostream>
#include <stack>
using namespace std;
//1021删除最外层的括号解法1：遍历S，每当栈空时，记下外围括号的位置
class Solution {
public:
    string removeOuterParentheses(string S){
        stack<char> stack;
        string string1;
        int i = 0,j = 0;
        for(char str : S){
            j++;
            if (str == '('){
                stack.push(str);
            }
            if (str == ')'){
                stack.pop();
                if(stack.empty()){
                    string1 += S.substr(i+1,j-i-2);
                    i = j;
                }
            }
        }
        return string1;
    }
};

int main(){
    Solution solution;
    string string1 = solution.removeOuterParentheses("(()())(())");
    cout << string1 << endl;
    return 0;
}