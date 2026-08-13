class TimeMap {
    Map<String, TreeMap<Integer, String>> h;
    public TimeMap() {
        h = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> t = new TreeMap<>();
        t.put(timestamp, value);

        if(!h.keySet().contains(key)){
            h.put(key, t);  
        }else{
            h.get(key).put(timestamp, value);
        }
    }
    
    public String get(String key, int timestamp) {
        if(h.keySet().contains(key) == false){
            return "";
        }
        if(timestamp < h.get(key).firstKey()){
            return "";           
        }
        int k = h.get(key).floorKey(timestamp);
        return h.get(key).get(k);
    }
}
