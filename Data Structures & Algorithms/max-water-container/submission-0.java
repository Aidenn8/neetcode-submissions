class Solution {
    public int maxArea(int[] heights) {
        int i1 = 0;
        int i2 = heights.length-1;
        int maxA = 0;

        for(int i = 0; i<heights.length; i++){
            for(int j = 0; j<heights.length; j++){
                if(Math.min(heights[i], heights[j]) * Math.abs(j-i) > maxA){
                    maxA = Math.min(heights[i], heights[j]) * Math.abs(j-i);
                }
            }
        }
        return maxA;
    }
}


// you want two pointers
// i1 and i2

// you want to maximize (i2 - i1) * (lower bar height)
