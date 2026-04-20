class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //nested loop
        //subtract 0 from numbers 1 and 2
        //check to see if the set contains the nums
        //if it does then u can prob increase the coun
        //its just dealing with indices + two sum (two sum w/sorted)
        Arrays.sort(nums);
        int three = 0;
        List<List<Integer>> li = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            while(l < r){
                three = nums[i] + nums[l] + nums[r];
                if(three < 0){
                    l++;
                }else if(three > 0){
                    r--;
                }else{
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[l]);
                    arr.add(nums[r]);
                    li.add(arr);
                    l++;
                    while(nums[l] == nums[l-1] && l < r){
                        l++;
                    }
                }
            }
        }

        return li;
    }
}
