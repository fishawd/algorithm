/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/7/26
 */

#include <iostream>
#include <cmath>

using namespace std;
/**
 *  1-9有9个数，9， 10-99有 90个数 ，180  100-999有900个数，2700，1000~9999 9000个数 360000
 *   s(n) = 9 * 10^(n-1) * n  n = 1,2,3,4....
 *   F(s) = s(1)+s(2)+s(3)+...
 *   F(s) / 9 = 西格玛 (10^(n-1) * n)
 */
class Solution {
public:
    int findNthDigit(int n) {
        int m = n / 9;
        int i = 1;
        int sum = 0;
        while (sum <= m){
            sum += pow(10.0,i-1) * i;
            i++;
        }
        // 20 , 11
        //

        int start = 9 * pow(10.0, i-1);
        int end = start * i;

        int j = start +1 ;
        int k = 0;
        while (j <= end && j<=n){
            j += i;
            k++;
        }
        return start+k;


    }
};
int main() {
    Solution s;
    string f = s.intToRoman(4);
    //bool d = s.isMatch("ab", ".*c"); //false
    //bool a = s.isMatch("aacd", "aa.d");
    cout << f << endl;
    //cout << d << endl;
    //cout << a << endl;
}