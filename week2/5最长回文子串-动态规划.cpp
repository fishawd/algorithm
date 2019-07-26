/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/7/25
 */
#include <iostream>
#include <vector>
//5.最长回文子串-- 动态规划
using namespace std;
class Solution {
public:
    string longestPalindrome(string s) {
        int i, j;
        int n = s.size();
        if (n <= 1)
            return s;
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        string palindrome;
        int start = 0, max_len = 1;
        for (j = 1; j < n; j++) { //j等于1，说明从长度为1的回文开始寻找
            for (i = 0; i < j; i++) {
                if (s[i] == s[j] &&  ( j -i < 3 or dp[i + 1][j - 1])) {//j-i小于三个字符不用再判断，因为单个字符必然是回文，
                                                                    // 即s[k][k]为真,若s[i] == s[j] 并且 j-i=2，说明这个三个字符为回文
                    dp[i][j] = true;
                    if (j - i + 1 > max_len) {
                        start = i;
                        max_len = j - i + 1;
                    }
                }
            }
        }
        return s.substr(start, max_len);
    }
};

int main(){
    Solution solution;
    string s = solution.longestPalindrome("cbbd");
    cout << s << endl;
}