class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        mp = set()
        for i in range(len(nums)):
            if nums[i] not in mp:
                mp.add(nums[i])
            else:
                return True
        
        return False


            

        