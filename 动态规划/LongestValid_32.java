import java.util.Stack;

/**
 * 动态规划
 * 1. dp[i]表示从0-i的有效长度
 * 2. 所有的'('都是0
 * 3. 如果s[i] == ')' 并且s[i-1] == '('，那么dp[i] = dp[i-2]+2
 * 4. 如果s[i] == ')' 并且s[i-1] == ')', 如果 dp[i-dp[i-1]-1] == '(', 那么dp[i] = dp[i-1] + dp[i-dp[i-1]-2]+2
 * <p>
 * <p>
 * <p>
 * 例如 “)()())”，初始条件，dp={0,0,0,0,0,0}
 */
class LongestValid_32 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        int[] dp = new int[n];
        if (n <= 1)
            return max;
        for (int i = 1; i < n; i++) {

            if (s.charAt(i) == ')') {

                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (s.charAt(i - 1) == ')' && i >= dp[i - 1] + 1 && s.charAt(i - dp[i - 1] - 1) == '(') {

                    if (i >= dp[i - 1] + 2) {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}

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
class Solution2 {
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

/**
 * 栈解法
 * 1.从向右扫描，当遇见左括号时，将下标入栈
 * 2.遇见右括号时候出栈
 * 出栈后，如果栈不空，则当前下标减去栈顶的下标
 * 如果栈空，则将当前坐标入栈
 * 3.为了正确计算第一个合法长度的序列，先将-1放入栈中
 */
class Solution3 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        if (n <= 1)
            return max;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    max = Math.max(max, len);
                }

            }
        }
        return max;

    }
}

/**
 * 暴力法
 */
class Solution4 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        if (n <= 1)
            return max;
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j += 2) {
                int len = maxValidParentheses(s.substring(i, j));
                max = max > len ? max : len;
            }
        }
        return max;
    }

    private int maxValidParentheses(String s) {
        //遇到'('进栈，遇到')'出栈
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(String.valueOf(s.charAt(i)));
            } else if (s.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                return 0;
            }
        }
        return stack.isEmpty() ? s.length() : 0;
    }

}