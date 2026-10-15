class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i : nums){
            if(h.keySet().contains(i)){
                return true;
            }else{
                h.put(i, 0);
            }
        }
        return false;
    }
}