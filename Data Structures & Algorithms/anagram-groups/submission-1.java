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

//main logic is that you are gonna create a map to map out a specific code to each string
//then you are going to use [c - 'a'] and an array of size 26 (for each letter of the alphabet)
//by doing this u can index and count the number of each character in the array
//then you can go and turn this back into a string to use as the key for each actual string in the original array
//then if that key exists in your map, you can just add the string to the list
//otherwise, create the new spot in your map with a new list mapped to that string
//then return just the values list
