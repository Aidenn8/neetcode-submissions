class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;

        int windowSize = 0;
        int maxChar = 0;
        int windowLength = 0;
        int diff = 0;
        int total = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        for(int r = 0; r<s.length(); r++){
            h.put(s.charAt(r), h.getOrDefault(s.charAt(r), 0) + 1);
            //count freq
            //find max chars
            maxChar = Math.max(maxChar, h.get(s.charAt(r)));
            //calc diff
            while(r - l + 1 - maxChar > k){
                h.put(s.charAt(l), h.get(s.charAt(l)) - 1);
                l++;
                //slide and remove if invalid
            }

            //slide until left is gone

            //if valid then calc --> 

            //r-l + 1 b/c that gives number of elements btwn
            if(((r - l + 1) - maxChar) <= k){
                total = Math.max(total, r - l + 1);
            }
            //total is just the sum of window len & maxChars


        }
        return total;
        //need length of curr window
        //need freq of character
        // windowlength - maxfreq = a
        // a <= k
        // total = maxfreq + a
        //if a > k
        //move left pointer

        //A A B C



    }
}


// X
// 1 + k

// move until diff then add k or until string runs out
