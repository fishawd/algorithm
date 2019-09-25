/**
 * 栈解法
 * 1.从向右扫描，当遇见左括号时，将下标入栈
 * 2.遇见右括号时候出栈
 *      出栈后，如果栈不空，则当前下标减去栈顶的下标
 *             如果栈空，则将当前坐标入栈
 * 3.为了正确计算第一个合法长度的序列，先将-1放入栈中
 */
class Solution {
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