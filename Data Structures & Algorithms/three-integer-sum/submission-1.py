class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        three = 0
        li = []
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            l = i+1
            r = len(nums)-1
            while l < r:
                three = nums[i] + nums[l] + nums[r]
                if three < 0:
                    l+=1
                elif three > 0:
                    r-=1
                else:
                    arr = []
                    arr.append(nums[i])
                    arr.append(nums[l])
                    arr.append(nums[r])
                    li.append(arr)
                    l+=1
                    while nums[l] == nums[l-1] and l < r:
                        l+=1
        return li