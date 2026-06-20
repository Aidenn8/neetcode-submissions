class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> mp = new HashMap<>();
        //given array of strings
        //group all anagarams
        //group tgth anagrams? --> map out freq to char
        for(String s : strs){
            int[] m = new int[26];
            for(Character c : s.toCharArray()){
                m[c - 'a']++;
            }
            String k = Arrays.toString(m);
            //now my array has the 0 10 010101 pattern
            if(!mp.keySet().contains(k)){
                mp.put(k, new ArrayList<String>());
                mp.get(k).add(s);
            }else{
                mp.get(k).add(s);
            }
        }
        return new ArrayList<>(mp.values());
    }
}
