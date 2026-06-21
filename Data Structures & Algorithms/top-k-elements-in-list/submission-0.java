class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //find the ƒreq of each value and put that into a hashmap
        //use an indexed array to count the frequencies --> index to list
        //loop through the array reversed by k
        List<Integer>[] arr = new List[nums.length+1];
        //its nums.length+1 b/c we want the max frequencies ex. if its like length 4 then lenght of 5 will give us the i[4] slot
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            h.put(nums[i], h.getOrDefault(nums[i], 0) + 1);
        }
        //getOrDefault --> if not already allocated --> set 0
        //hashmap now contains frequency map
        //lets create the lists within the array
        for(int i = 0; i<arr.length; i++){
            arr[i] = new ArrayList<Integer>();
        }
        //i want to now just do my buckets sort
        //go through my map and look at the value --> find the corresponding index in the array and add the key to the list

        for(int i : h.keySet()){
            arr[h.get(i)].add(i);
        }
        int[] finalThing = new int[k];
        //now I just gotta reverse loop
        int count = 0;
        for(int i = arr.length-1; i>0; i--){
            if(count > k){
                break;
            }
            if(!arr[i].isEmpty()){
                for(int j : arr[i]){
                    finalThing[count] = j;
                    count++;
                    if(count == k){
                        return finalThing;
                    }
                }

            }
            
        }
        return finalThing;



    }
}
