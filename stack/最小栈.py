
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.helper = []
    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.stack.append(x)
        if len(self.helper) == 0 or self.helper[-1] >= x:
            self.helper.append(x)

    def pop(self):
        """
        :rtype: None
        """
        if len(self.stack) >0:
            x = self.stack.pop()
            if x == self.helper[-1]:
                self.helper.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.helper[-1]

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-1)
obj.push(2)
obj.push(3)
obj.push(4)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()
print(param_3,param_4)