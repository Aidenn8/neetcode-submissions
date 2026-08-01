class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //can map for each of s1 and s2
        //then check to see if asll keys & vals = in s2 from s1
        //-----
        //arr size 26
        //two pointers?
        //l and r 

        // b f d 
        // d e f a b

        //******

        // a b c d e f g h i j k
        // 0 1 1 1


        // a b c d e f g h i j k
        // 1 1 0 1 1 1
        // l
        //     r
        //arr 26 is good cause auto sorts
        //use hashmap w/ freq count to const check the subaraays

        //check by length of s1
        //shift whole window
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];



        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();

        for(int i = 0; i<s1.length(); i++){
            h1.put(s1.charAt(i), h1.getOrDefault(s1.charAt(i), 0) + 1);
        }


        int l = 0;
        for(int r = 0; r<s2.length(); r++){
            //count s2 freq
            h2.put(s2.charAt(r), h2.getOrDefault(s2.charAt(r), 0) + 1);

            //check if our of bounds
            if(r - l + 1 > s1.length()){
                //IF NOT EQUAL SHIFT WINDIW
                h2.put(s2.charAt(l), h2.get(s2.charAt(l)) - 1);
                if(h2.get(s2.charAt(l)) == 0){
                    h2.remove(s2.charAt(l));
                }

                l++; 
            }
            if(h1.equals(h2)){
                return true;
            }

        }
        return false;



    }
}
