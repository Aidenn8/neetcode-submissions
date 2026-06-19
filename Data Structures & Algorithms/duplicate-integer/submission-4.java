class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            if(!hs.keySet().contains(nums[i])){
                hs.put(nums[i], 1);
            }else{
                return true;
            }
        }
        return false;
    }
}