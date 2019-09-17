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
 /**
  * 规律：1.row = 0时，从上往下走
  *     2.row <= numRows时候，一直往下，当row = numRows，说明走到了最后一行
  *     3.此时换方向，向斜上方走
  *     4.当row=0时，说明又到了最上方，重复2、3步
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
                row -= 2; //这里row自减2是因为当 row = numRows-1时，row又自增了1，斜上的第一个位置的row与当前的row的值刚好差2
                col++;
                while (row >= 0 && i < n) {
                    A[row][col] = s[i];
                    row--;
                    col++;
                    i++;
                }
            }
            if(row == -1){//这和上边一样，当row=0时，row又进行了自减操作，col自增了
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