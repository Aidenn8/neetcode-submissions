class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while(l <= r){
            int m = (l+r)/2;

            if(l == r && r == m){
                if(target == nums[l]){
                    return l;
                }else{
                    break;
                }
            }

            if(nums[m] == target){
                return m;
            }

            if(nums[r] - nums[m] > 0 && nums[m] - nums[l] > 0){
                if(nums[l] <= target && target <= nums[m]){
                    r = m - 1;
                }else if(target <= nums[r] && target >= nums[m]){
                    l = m + 1;
                }
            }

            if(nums[r] - nums[m] > 0){
                if(nums[m] <= target && target <= nums[r]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }else{
                if(nums[l] <= target && target <= nums[m]){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
