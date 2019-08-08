/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/8/8
 */
#include <iostream>
#include <vector>

using namespace std;

/**
 * 双指针解法，前后各维持一个指针，用maxarea来表示最大面积。在当前情况下，只有移动较短的指针才会可能使面积增大。
 */
class Solution {
public:
    int maxArea(vector<int> &height) {
        int maxarea = 0;
        int i = 0, j = height.size() - 1;
        while (i < j) {
            int temp = min(height[i], height[j]) * (j - i);
            maxarea = temp > maxarea ? temp : maxarea;
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxarea;
    }
};