class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int currMaxLength = 0;
        int maxLength = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> h = new HashSet<>();
        while(i < s.length() && j<s.length()){
            if(!h.contains(s.charAt(j))){
                h.add(s.charAt(j));
                currMaxLength++;
                j++;
            }else{
                if(currMaxLength > maxLength){
                    maxLength = currMaxLength;
                }
                currMaxLength = 0;
                h.clear();
                i++;
                j=i;

            }
            if(currMaxLength > maxLength){
                maxLength = currMaxLength;
            }
            
        }
        return maxLength;
        
    }
}
