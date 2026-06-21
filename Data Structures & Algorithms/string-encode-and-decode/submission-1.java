class Solution {

    public String encode(List<String> strs) {

        StringBuilder s = new StringBuilder();
        for(int i  = 0; i<strs.size(); i++){
            s.append(strs.get(i).length());
            s.append("#");
            s.append(strs.get(i));
            
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> s = new ArrayList<>();
        int i  = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            String addNow = str.substring(j+1, j + len + 1);
            s.add(addNow);
            
            i = j + len + 1;

        }
        return s;
    }
}
//4#abba5
