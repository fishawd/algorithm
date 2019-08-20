/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/8/20
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int> &nums) {
        vector<vector<int>> res;
        if (nums.empty())
            return res;
        int i = 0, j = nums.size() - 1;
        //排序
        sort(nums.begin(), nums.end());
        //quickSort(nums, i, j);
        for (int k = i; k <= j; k++) {
            //最小的大于0，三数之和肯定大于0
            if (nums[k] > 0)
                break;
            //去除重复的
            if (k > 0 && nums[k] == nums[k - 1])
                continue;
            int left = k + 1;
            int right = j;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (sum == 0) {
                    vector<int> temp = {nums[k], nums[left], nums[right]};
                    res.push_back(temp);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else {
                    if (sum > 0) right--;
                    if (sum < 0) left++;
                }
            }
        }
        return res;
    }

//    //快排
//    void quickSort(vector<int> &nums, int start, int end) {
//        int i = start, j = end;
//        int temp = nums[i];
//        if (i < j) {
//            while (i < j) {
//                //从后往前找，找到第一个比temp小的
//                while (nums[j] > temp && i < j) j--;
//                if (i < j) {
//                    nums[i] = nums[j];
//                    i++;
//                }
//                //从前往后找，找到第一个比temp大的
//                while (nums[i] < temp && i < j) i++;
//                if (i < j) {
//                    nums[j] = nums[i];
//                    j--;
//                }
//            }
//            nums[i] = temp;
//            quickSort(nums, start, i - 1);
//            quickSort(nums, i + 1, end);
//        }
//    }
};