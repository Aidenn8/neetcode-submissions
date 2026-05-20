class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        totalSum = 0
        spongebob = set()
        for n in nums:
            spongebob.add(n)
        
        for i in range(len(nums)):
            if (nums[i] - 1) not in spongebob:
                innerSum = 1
                while (nums[i] + innerSum) in spongebob:
                    innerSum += 1
                totalSum = max(innerSum, totalSum)

        return totalSum