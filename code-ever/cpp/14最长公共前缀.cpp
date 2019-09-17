/**
 *  @Author:游鱼惊梦
 *  @Date: 2019/8/19
 */

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty())
            return "";
        string longest = strs[0];
        for (int i= 1;i<strs.size();i++){
            longest = compare(longest, strs[i]);
        }
        return longest;
    }

    string compare(string longest,string current){
        string res;
        for (int i=0;i< longest.size() && current.size();i++){
            if (longest[i] != current[i])
                return res;
            res += current[i];
        }
        return res;
    }
};