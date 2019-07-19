class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # 栈 后进先出
        # 用list实现栈
        st = list()
        n = len(s)
        for i in range(n):
            if s[i] == '(' or s[i] == '[' or s[i] == '{':
                st.append(s[i])
            elif len(st) > 0:
                if s[i] == ')':
                    if st.pop() != '(':
                        return False
                elif s[i] == ']':
                    if st.pop() != '[':
                        return False
                else:
                    if st.pop() != '{':
                        return False
            else:
                return False
        if len(st) > 0:
            return False
        return True
