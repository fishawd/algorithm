class Solution(object):
    def nextGreaterElement(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        """
            1.维护一个从栈顶到栈底单调递减的栈，栈中存放数组元素的下标
            2.从后往前，将数组元素的下标放入栈中。
            3.在将数组元素的下标放入栈中之前，判断栈顶存放的下标对应的数组元素是否小于当前元素。
            4.因为是从后往前遍历，栈中下标所对应的数组元素都在当前元素之后。所以若nums2[week1[-1]] 小于 nums2[i],
            说明当前数组元素的"后一个元素"不满足要求，故弹出栈中"后一个元素"所对应的数组下标，也就是栈顶元素。重复步骤3，4
            直到栈空，说明没有符合要求的元素
        """
        stack = []
        rmap = {}
        rlist = []
        for i in range(len(nums2)-1, -1, -1):
            while len(stack) > 0 and nums2[stack[-1]] < nums2[i]:
                stack.pop()
            rmap[nums2[i]] = -1 if len(stack) == 0 else nums2[stack[-1]]
            stack.append(i)
        for i in range(len(nums1)):
            rlist.append(rmap[nums1[i]])
        return rlist
