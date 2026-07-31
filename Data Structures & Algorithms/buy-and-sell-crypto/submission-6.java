class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for(int i : prices){
            //found max
            //stpre min
            //continue for bigger
            if(i - min > max){
                max = i - min;
                continue;
            }
            if(min > i){
                min = i;
            }
        }
        return max;
    }
}
