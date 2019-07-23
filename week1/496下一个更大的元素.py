class Solution(object):
    def nextGreaterElement(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        n = len(nums2)
        m = len(nums1)
        rlist = list()
        numsdic = dict()
        for i in range(n):
            numsdic[nums2[i]] = i
        for j in range(m):
            k = numsdic[nums1[j]]
            flag = 0
            for l in range(k+1,n):
                if nums2[l] > nums1[j]:
                    rlist.append(nums2[l])
                    flag = 1
                    break;
            if flag == 0:
                rlist.append(-1)
        return rlist