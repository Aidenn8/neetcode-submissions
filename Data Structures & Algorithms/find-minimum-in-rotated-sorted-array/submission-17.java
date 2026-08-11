class Solution {
    public int findMin(int[] nums) {
        
        int l = 0;
        int r = nums.length-1;
        int middle = 0;
        while(l <= r){
            middle = (l+r)/2;

            if(l == r && r == middle && middle == l){
                return nums[r];
            }
    
            if(middle != 0){
                if(nums[middle-1] > nums[middle]){
                    return nums[middle];
                }
            }
            
            if(nums[nums.length-1] - nums[middle] < 0){
                l = middle + 1;
            }else if(nums[nums.length-1] - nums[middle] > 0){
                r = middle - 1;
            }
        }
        return nums[middle];
    



    }
}