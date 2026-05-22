class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];

        for(int i = 0; i<arr.length; i++){
            arr[i] = 1;
            for(int j = 0; j<nums.length; j++){
                if(i == j){
                    continue;
                }
                arr[i] *= nums[j];
            }
        }

        return arr;
    }
}  
