class Solution {
    public boolean isPalindrome(String s) {
        int firstIndex = 0;
        int lastIndex = s.length() - 1;
        while(firstIndex<lastIndex){
            while(firstIndex < lastIndex && !Character.isLetterOrDigit(s.charAt(firstIndex))){
                firstIndex++;
            }
            while(lastIndex > firstIndex && !Character.isLetterOrDigit(s.charAt(lastIndex))){
                lastIndex--;
            }
            if(Character.toLowerCase(s.charAt(firstIndex)) != Character.toLowerCase(s.charAt(lastIndex))){
                return false;
            }
            firstIndex++;
            lastIndex--;

        }
        return true;
    }
}
