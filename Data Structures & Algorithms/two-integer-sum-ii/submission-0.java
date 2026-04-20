class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int l = 0;
        int r = numbers.length-1;
        int sum = numbers[l]+numbers[r];
        while(l < r){
            sum = numbers[l] + numbers[r];
            if(sum < target){
                l++;
            }else if(sum > target){
                r--;
            }else{
                arr[0] = l+1;
                arr[1] = r+1;
                break;
            }
        }
        return arr;
    }
}
