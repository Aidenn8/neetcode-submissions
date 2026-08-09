class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ind = new int[temperatures.length];
        
        ArrayDeque<Integer> d = new ArrayDeque<>();

        for(int i = 0; i<temperatures.length; i++){
            while(d.peek() != null && temperatures[i] > temperatures[d.peek()]){
                int val = d.pop();
                ind[val] = i - val;
            }

            d.push(i);

        }
        return ind;
    }
}

/*


30,38,30,36,35,40,28
0  1  2  3  4  5  6



i=0

d: 0

i=1
d: 0 1


val = 1
d: 0 

ind: 0 1 0 0 0 0

i = 2








v1
-----------

st: 30 38

pop 30

- keep track that i = 0 --> 38 (popped val)
- increment i?

st: 38

st: 38 30 --> not bigger so ignore

i = 1 

how do you keep track of what index you are on/adding the next biggest to

st: 38 30 30

if equal then ignore

st: 38 30 30 36 --> bigger so pop down

pop 30 (2)

note i = 2

st: 38 30 36




but note --> 36 bigger than 30 so before pop next keep track that 36 is biggest for

in that case shouldn't I map each temp to its index w/hashmap - but can't cause dups
- could just array then




st: 38 36 

st: 38 36 35 

st: 




-------


store indices instead?

30,38,30,36,35,40,28

0  1  2  3  4  5  6

the logic is that you pop the index subtract the index 
you pop the stack
subtract the popped val from the new one (i)
continue on




*/