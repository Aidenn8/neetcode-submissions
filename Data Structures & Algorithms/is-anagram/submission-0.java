class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            if(!m1.containsKey(s.charAt(i))){
                m1.put(s.charAt(i), 1);
            }else{
                m1.put(s.charAt(i), m1.get(s.charAt(i))+1);
            }
        }
        for(int i = 0; i<t.length(); i++){
            if(!m2.containsKey(t.charAt(i))){
                m2.put(t.charAt(i), 1);
            }else{
                m2.put(t.charAt(i), m2.get(t.charAt(i))+1);
            }
        }
        return m1.equals(m2);

    }
}
