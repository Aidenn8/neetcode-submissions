class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l = 0
        r = len(heights) - 1
        maxA = 0

        while l < r:
            shorter = max(heights[l], heights[r])
            if (min(heights[l], heights[r]) * (r-l)) > maxA:
                maxA = (min(heights[l], heights[r])) * (r-l)
            
            if heights[l] < heights[r]:
                l+=1
            else:
                r-=1
            
        
        return maxA