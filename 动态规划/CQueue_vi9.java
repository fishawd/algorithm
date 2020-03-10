import java.util.Stack;

/**
 * @author jian
 * @date 2020/3/10 23:46
 */
public class CQueue_vi9 {
    // 思路：队列 先进先出，栈后进先出，
    // 进队： 进入stack1，stack1出栈压入stack2
    // 出队：弹出stack2，stack2为空时，再将stack1压入stack2
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return -1;
        }

    }
}
