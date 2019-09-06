/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/9/6
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//双指针算法
/**
 *  对每一个i，获得nums[i]，left = i + 1, right = nums.size - 1,
 *  如果sum > target,那么right--, 如果 sum < target，那么left++ ，如果sum = target，直接返回
 *
 */
class Solution {
public:
    int threeSumClosest(vector<int> &nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        int left, right;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i++) {
            left = i + 1;
            right = nums.size() - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (abs(target - sum) < abs(target-res))
                    res = sum;
                if (sum > target)
                    right--;
                else if (sum < target)
                    left++;
                else
                    return res;
            }
        }
        return res;
    }
};