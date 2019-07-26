/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/7/23
 */

#include <iostream>
#include <stack>
using namespace std;

// 1021 删除最外层的括号

class Solution {
public:
    string removeOuterParentheses(string S){
        int L = 1,R = 0;
        string rstr;
        for (int i = L;i<S.size();i++){
            if (S[i] == '(')
                L++;
            else
                R++;
            if (L!=R){
                rstr += S[i];
            } else{
                i++;
                L = 1;
                R = 0;

            }
        }
        return rstr;
    }
};

int main(){
    Solution solution;
    string string1 = solution.removeOuterParentheses("(()())(())");
    cout << string1 << endl;
    return 0;
}