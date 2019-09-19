import java.util.Stack;


/**
 * 暴力法
 */
class Solution {
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
            }else {
                return 0;
            }
        }
        return stack.isEmpty() ? s.length() : 0;
    }

}





