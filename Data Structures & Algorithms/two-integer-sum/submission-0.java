class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0;i <nums.length;i ++){
            if(!m.containsKey(target - nums[i])){
                m.put(nums[i], i);
            }else{
                sol[0] = m.get(target - nums[i]);
                sol[1] = i;

                
            }
        }
        return sol;
    }
}