class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length-1;
        int maxA = 0;

        while(l < r){
            int shorter = Math.max(heights[l], heights[r]);
            // int tryThis = Math.min(heights[l], heights[r]) * (r-l);
            // maxA = Math.max(maxA, tryThis);
            if((Math.min(heights[l], heights[r]) * (r-l)) > maxA){
                 maxA = (Math.min(heights[l], heights[r])) * (r-l);

            }
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxA;
    }
}


// you want two pointers
// i1 and i2

// you want to maximize (i2 - i1) * (lower bar height)
