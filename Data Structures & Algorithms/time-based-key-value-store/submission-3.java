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
            //now acceesding atreemap

            h.get(key).put(timestamp, value);
        }
    }
    
    public String get(String key, int timestamp) {
        //im guessing that you want to use binary search here
        //when is floorKey null? --> when there are no values that are less than the first timestamp


        //put in a 10 and then requesting a 1 not possible
        //so if the timestamp is less than the first possible timestamp in the treemap then return ""
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

/*
["TimeMap", 
"set", ["alice", "happy", 1], 
"get", ["alice", 1], 
"get", ["alice", 2], 
"set", ["alice", "sad", 3], 
"get", ["alice", 3]]

"set", ["alice", "happy", 1], 
"set", ["alice", "sad", 3], 


alice --> happy (1)
alice --> sad (3)

i could add to the hashmap based on the number attached
--> for searching then i can run binary

but when they call for like alice (2)
i just search for the nearest up until that value 
i could probably just cut the other half out and then search that way 

alice happy 1
alice happy 3
alice happy 4
alice happy 5
alice happy 6

okay so its just a binary search --> doing this because they want O(logn) time complexity
lets say they want 2


1 3 4 5 6

l = 0
r = 4
m = 2

target = 2
choose left
l = 0
r = 1
m = 0

choose right

l = 1
r = 1
m = 1
check middle if = target --> since they are all equal but the middle isn't target then you can break out the while loop and return the n-1 corresponding value (assuming it isn't out of bounds)?

binary search needs to remember the last valid candidate

so basically i can just run a binary search and if the candidate is <= to the target value then i can just store it as my current best timestamp

the only problem is how do i structure my data here
i probably want a hashmap to assign the key to the values
after that --> actually no thats probably not a good idea
maybe ill map the key to the timestamp
but since there can be multiple of the same key
how about i map the timestamp to the key
or i guess i could do it where the hashmap contains an int (the timestamp) as the key and then the value could be a 2d array that contains the string key and the string value

okay nvm

how about just make the string key the actual key and then i can just store the string value and the timestamp together as an array with 2 elements

okay so i want it to be 

Map<String, Map<Integer, String>> --> then when i add to my hashmap
i need to be able to sort it by the timestamp
that means that my inner map must be a treemap that starts with the integer as the key
this is because the treemap will be sorted by ascending order

so every time the .get is called --> i'll look up the corresponding key in the outer hashmap
that will then give me access to another treemap that is already sorted based on timestamp
i just need to binary search that treemap's values based on the timestamps
within the binary search i just need to be constantly be keeping track of valid timestamps that are <= to the given one that was inputted
after i finish my search i should have the valid timestamp and then i can use that teimstamp as the key to the corresponding value that i then output

apparantely there is something called .floorKey that will basically run binary search on the treemap and return the key that is <= the requested timestamp



*/