class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();

        for(Character c : s.toCharArray()){
            if(!h1.keySet().contains(c)){
                h1.put(c, 1);
            }else{
                h1.put(c, h1.get(c) + 1);
            }

        }
        for(Character c : t.toCharArray()){
            if(!h2.keySet().contains(c)){
                h2.put(c, 1);
            }else{
                h2.put(c, h2.get(c) + 1);
            }

        }

        return h1.equals(h2);
    }
}
