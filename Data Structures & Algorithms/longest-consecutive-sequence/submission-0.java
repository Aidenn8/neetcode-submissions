class Solution {
    public int longestConsecutive(int[] nums) {
        int totalSum = 0;
        
        Set<Integer> spongebob = new HashSet<>();
        for(int n : nums){
            spongebob.add(n);
        }
        for(int i = 0; i<nums.length; i++){
            if(!spongebob.contains(nums[i]-1)){
                int innerSum = 1;
                while(spongebob.contains(nums[i]+innerSum)){
                    innerSum++;
                }
                totalSum = Math.max(innerSum, totalSum);
            }
            
        }
        return totalSum;

    }
}

//12 10 1 2 3 4 2 3