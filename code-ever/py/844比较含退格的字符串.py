class Solution(object):
    def backspaceCompare(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: bool
        """
        stack1 = list()
        stack2 = list()

        for s in S:
            if s == '#':
                if len(stack1) > 0:
                    stack1.pop()
            else:
                stack1.append(s)
        for t in T:
            if t == '#':
                if len(stack2) > 0:
                    stack2.pop()
            else:
                stack2.append(t)
        # m = len(stack1)
        # n = len(stack2)
        # if m != n:
        #     return False
        # else:
        #     for i in range(m):
        #         if stack1[i] != stack2[i]:
        #             return False
        return stack1 == stack2

c = Solution()
s = c.backspaceCompare("ab#c",
"ad#c")
print(s)