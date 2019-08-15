/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/8/15
 */

#include <iostream>

using namespace std;

/**
 *  1-9有9个数，9， 10-99有 90个数 ，180  100-999有900个数，2700，1000~9999 9000个数 360000
 *   s(n) = 9 * 10^(n-1) * n  n = 1,2,3,4....
 *   F(s) = s(1)+s(2)+s(3)+...
 *
 */
class Solution {
public:
    int findNthDigit(int n) {

        if (n < 10)
            return n;
        int i = 0;
        long long sum = 0;
        while (sum < n) {
            i++;
            sum += cal(i-1) * i * 9;
        }
        int start = sum - cal(i-1) * i * 9;
        long long j = start;
        int k =  cal(i - 1) - 1;
        while (j < n) {
            j += i;
            k++;
        }
        int l = (n - start - 1 + i) % i;
        return to_string(k)[l] - '0';


    }

    long long cal(int n) {
        long long sum = 1;
        for (int i = 0; i < n; i++) {
            sum *= 10;
        }
        return sum;
    }
};