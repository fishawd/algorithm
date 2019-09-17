/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/9/10
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 *  固定两个数字，用双指针算法
 *
 */

class Solution {
public:
    vector<vector<int>> fourSum(vector<int> &nums, int target) {
        vector<vector<int>> res;
        int n = nums.size();
        if (n < 4)
            return res;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n - 3; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            //优化1 最小的4数之和大于target，则跳出
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            //优化2 最大的4数之和小于target，则跳出
            if (nums[n - 1] + nums[n - 2] + nums[n - 3] + nums[n - 4] < target)
                break;
            //优化3 最大的3数之以及nums[i]的和小于target，那么i就太小，进入下次循环
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target)
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                //这里开始就类似三数之和了
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                //优化，同上
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target)
                    continue;
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        vector<int> temp = {nums[i], nums[j], nums[left], nums[right]};
                        res.push_back(temp);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
};