class Solution(object):
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        """
        """
        用栈存放每一回合的分数
        """
        stack = list()
        for i in range(len(ops)):
            if ops[i] == '+':
                stack.append(stack[-1] + stack[-2])
            elif ops[i] == 'D':
                stack.append(stack[-1] * 2)
            elif ops[i] == 'C':
                stack.pop()
            else:
                stack.append(int(ops[i]))

        return sum(stack)

