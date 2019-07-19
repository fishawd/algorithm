class MyStack(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.que1 = []
        self.que2 = []


    def push(self, x):
        """
        Push element x onto stack.
        :type x: int
        :rtype: None
        """
        self.que1.append(x)


    def pop(self):
        """
        Removes the element on top of the stack and returns that element.
        :rtype: int
        """
        for i in range(len(self.que1)):
                self.que2.append(self.que1[i])
        self.que1.clear()
        return self.que2.pop()
    def top(self):
        """
        Get the top element.
        :rtype: int
        """
        return self.que2[-1] if len(self.que1) == 0 else self.que1[-1]

    def empty(self):
        """
        Returns whether the stack is empty.
        :rtype: bool
        """
        if len(self.que1) == 0 and len(self.que2) == 0:
            return True
        return False

