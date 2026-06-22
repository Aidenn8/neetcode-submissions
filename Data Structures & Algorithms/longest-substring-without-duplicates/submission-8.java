class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        //logic is basically 2 pointer and then you move the left pointer until u get a unique val
        int l = 0;
        HashSet<Character> h = new HashSet<>();
        for(int r = 0; r<s.length(); r++){
            while(h.contains(s.charAt(r))){
                h.remove(s.charAt(l));
                l++;
            }
            length = Math.max(length, r - l + 1);
            h.add(s.charAt(r));


        }
        return length;
    }
}
// " azxyzxyz"
//   ^
//     ^

// charSet: z x y
// res = r - l + 1 = 1


