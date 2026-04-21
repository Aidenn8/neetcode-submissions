class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        int mid = (l+r) / 2;
        while(l < r){
            mid = (l+r)/2 ;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                //search right half
                l = mid+1;
            }
            if(nums[mid] > target){
                r = mid;
            }
        }
        if(nums[l] == target){
            return l;
        }
        return -1;
    }
}

// 1 2 3 4 5 6
// 5/2
// 2 