class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] beginning = new int[nums.length];
        int[] end = new int[nums.length];
        int[] sol = new int[nums.length];

        //one interation to fill up all values to the left of i
        beginning[0] = 1;
        end[nums.length-1] = 1;
        //wait okay so the logic is that you are going to go multiply all values to the left of i so basically you want to take i-1 vals and multiply them together

        for(int i = 1; i < nums.length; i++){
            beginning[i] = beginning[i-1] * nums[i-1];
        }
        for(int i = nums.length-2; i>=0; i--){
            end[i] = end[i+1] * nums[i+1];
        }
        for(int i = 0; i<nums.length; i++){
            end[i] = beginning[i] * end[i];
        }

        return end;


        // 1, 2, 4, 6

        // beg: 1, 2, 8
        // end: 24, 1


    }
}  
