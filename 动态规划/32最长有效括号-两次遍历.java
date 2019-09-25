/**
 * 两次遍历法
 * <p>
 * 设定两个指针left,right.
 * 从左往右
 * 遇到 '(' left++
 * 遇到 ')' right++
 * 若left<right的时候继续遍历，
 * 当left=right的时候，求长度
 * 当left>right时候归0，说明当前不再匹配
 * <p>
 * 从右往左重复一次，是为了防止漏检，如 "((()"这种情况
 */
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        if (n <= 1)
            return max;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;

            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return max;

    }
}