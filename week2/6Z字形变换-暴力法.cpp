/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/7/29
 */
#include <iostream>
#include <vector>
using namespace std;
/**
 * 执行用时 :64 ms, 在所有 C++ 提交中击败了16.06%的用户 内存消耗 :41.8 MB, 在所有 C++ 提交中击败了9.32%的用户。。。。。
 */
class Solution {
public:
    string convert(string s, int numRows) {
        string rstr;
        int n = s.size();
        int row = 0, col = 0, i = 0;
        if (numRows == 1)
            return s;
        vector<vector<char>> A(numRows,vector<char>(n,' '));
        while (i< n) {
            if(row == 0){
                A[row][col] = s[i];
                row++;
                i++;
            }
            if (row == 1 && i < n) {//向下
                A[row][col] = s[i];
                row++;
                i++;
                while (row <= numRows - 1 && i < n) {
                    A[row][col] = s[i];
                    row++;
                    i++;
                }
            }
            if (row == numRows && i < n) {//斜上
                row -= 2;
                col++;
                while (row >= 0 && i < n) {
                    A[row][col] = s[i];
                    row--;
                    col++;
                    i++;
                }
            }
            if(row == -1){
                row = 1;
                col --;
            }
        }
        for (int k = 0; k <numRows; k++){
            for (int l = 0; l <= col; l++){
                if(A[k][l] != ' ')
                    rstr += A[k][l];
            }
        }
        return rstr;
    }
};