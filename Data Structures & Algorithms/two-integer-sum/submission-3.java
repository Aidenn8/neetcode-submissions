class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];

        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            h.put(nums[i], i);
        }

        for(int i = 0; i<nums.length; i++){
            int other = target - nums[i];
            if(h.containsKey(other) && i != h.get(other)){
                arr[0] = i;
                arr[1] = h.get(other);
                break;
            }
        }
        return arr;
    }
}
