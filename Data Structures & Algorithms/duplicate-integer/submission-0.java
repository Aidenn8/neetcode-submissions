class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(h.containsKey(nums[i])){
                return true;
            }else{
                h.put(nums[i], 1);
            }
        }
        return false;
    }
        
}

