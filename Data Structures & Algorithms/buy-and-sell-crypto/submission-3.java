class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int currMax = 0;
        int inc = 1;
        int i = 0;
        

        if(prices.length == 1){
            return 0;
        }

        while(i < prices.length){
            
            if(prices[inc] - prices[i] >= 0){
                
                currMax = prices[inc] - prices[i];
                if(currMax > max){
                    max = currMax;
                }
                inc++;
            }else{
                i++;
                inc++;
            }
            if(inc > prices.length - 1){
                inc = prices.length-1;
                i++;
            }
        }
        return max;
    }
}
// 10 2 5 7 3 6 9 1
//      ^
//                ^

// 5 1 5 6 7 1 10

//     ^
//             ^

// 2 1 2 1 0 1 2
//       ^
//             ^
