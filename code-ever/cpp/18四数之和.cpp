/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/9/9
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 *  尝试采用三指针算法,
 *  对于每个i, left=i+1 ,mid = left+1,  right=n-1
 *
 */

class Solution {
public:
    vector<vector<int>> fourSum(vector<int> &nums, int target) {
        vector<vector<int>> res;
        if ( nums.size() < 4)
            return res;
        sort(nums.begin(), nums.end());
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            //跳过重复数字
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i + 1;
            int mid = left + 1;
            int right = n - 1;
            while (left < right) {
                while (mid < right) {//先移动mid
                    int sum = nums[i] + nums[mid] + nums[left] + nums[right];
                    if (sum == target) {
                        vector<int> temp = {nums[i], nums[left],nums[mid],nums[right]};
                        res.push_back(temp);
                        mid++;
                        right--;
                        //去除重复元素
                        while (mid < right && nums[mid] == nums[mid - 1]) mid++;
                        while (mid < right && nums[right] == nums[right + 1]) right--;
                    } else {
                        if (sum > target) right--;
                        if (sum < target) mid++;
                    }
                }
                left++;
                while (left < right && nums[left] == nums[left-1]) left++;
                mid = left + 1;
                right = n - 1;
            }
        }
        return res;
    }
};