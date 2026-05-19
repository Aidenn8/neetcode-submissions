class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        arr = []
        l = 0
        r = len(numbers) - 1
        while l < r:
            sum = numbers[l] + numbers[r]
            if sum < target:
                l+=1
            elif sum > target:
                r-=1
            else:
                arr.append(l+1)
                arr.append(r+1)
                break
        
        return arr



