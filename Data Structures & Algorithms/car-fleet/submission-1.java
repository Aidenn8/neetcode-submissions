class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //first step is to calculate the time it would take for each of these
        //then i need to sort by ascending position
        //in that case why don't i start by sorting the position array
        //but how do i get the corresponding times?
        //use a map?
        //you don't really care about speed - you just need the time


        float[][] sortPos = new float[position.length][2];
        for(int i = 0; i < position.length; i++){
            sortPos[i][0] = (float)position[i]; 
            sortPos[i][1] = (float)(target - position[i])/speed[i];
            //note there could be a case where the position is = to target and divide by 0 error
        }
        //now i have a time and position array
        //but how do i sort accordingly
        Arrays.sort(sortPos, (a, b) -> Float.compare(b[0], a[0])); //note that this sorts the rows by the first element of each row
        //now have sorted 2d aray of position to time

        /*

        pos: [10, 8, 5, 3, 0]
        t:   [ 1, 1, 7, 3, 12]

        */

        //now build the monotonic stack --> its going to store just the times
        Deque<Float> d = new ArrayDeque<>();

        for(int i = 0; i<position.length; i++){
            //i think my previous logic was wrong
            //instead of popping the bigger value i should keep it because the faster one should just catch up to it and maintain the slower ones speed
            //so instead of popping i should just skip the current faster one and move on --> that way its equivalent to counting them as merging as a fleet --> it literally just gets integrated

            if(d.peek() != null && sortPos[i][1] <= d.peek()){
                continue;
            }
            
            d.push(sortPos[i][1]);
        }

        return d.size();

    }
}
/*
ex.

target = 12
position = [10, 8, 0, 5, 3]
speed    = [ 2, 4, 1, 1, 3]
time     = [ 1, 1,12, 7, 3]

sort by pos

pos: [10, 8, 5, 3, 0]
t:   [ 1, 1, 7, 3, 12]

okay
lets go down the position order
if the time is less than or equal the time for one of the values before
that means it catches up? --> so that is considered 1 fleet


monotonic stack?


sort by position then add to the monotonic stack (ascending)

st: 1 1 7 --> this perfectly fine because ascending
add 3
st: 1 1 7 ... 3
pop 7
st: 1 1 3

actually no it should be less than or equal then pop
so:
st: 1 1
1 is equal so pop 1
st: 1 
- right now im guessing that the total elements in the stack is the final number of fleets but i want to trace it out
st: 1 7
st: 1 7 ... 3
3 is less than 7 so pop 7
st: 1 3
st: 1 3 12
final answer 12
the reason why this works is because by popping the bigger ones you are essentially removing a fleet and coutning them as one
so you want to use a while loop to pop all those that are greater cause that would all be considered 1 fleet
what remains is the total number of "unique" fleets

okay i think this makes sense


*/






/*
Input: target = 10, position = [1,4], speed = [3,2]

2 cars total

target: 10

first car: pos 1, speed 3
second car: pos 4, speed 2

if they catch up they have to keep at same pace
that means you can group them once one car catches up

first calculate for each car how much distance left

1st: 10 - 1 = 9 miles
2nd: 10 - 4 = 6 miles

then need to calculate which is faster?
if i do that then i need to find if the faster one will catch up to the slower
do i need to calculate which is faster?
 - dumbass i already know which is faster

1st: 3 mph
2nd: 2 mph

probably want to sort by which is fastest 

calculate how much time to reach?
miles/mph

1st: 9/3 = 3 hr
2nd: 6/2 = 3 hr


since same time --> 1 fleet

ex. 2

Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]

calc how much left

1st - 6 miles
2nd - 9 miles 
3rd - 10 miles
4th - 3 miles

calc time to reach (note probably want float not int)

1st - 3 hr 
2nd - 4.5 hr
3rd - 10 hr 
4th - 3 hr

since 1st and 4th reach same time that means fleet

now deal with two others

this is a bad example bruh

ex. 3

lets just use time to reach

1st - 3 hr
2nd - 3 hr
3rd - 1 hr
4th - 

----------

diff

sort by position instead

for ex. 2

Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]


1st - 3 hr (4)
2nd - 4.5 hr (1)
3rd - 10 hr (0)
4th - 3 hr (7)

reorder by pos

1st - 3 hr (7)
2nd - 3 hr (4)
3rd - 4.5 hr (1)
4th - 10 hr (0)

the bigger the time it takes the slower it is - act idk if this true

how to know if catches up?

ex.

target = 12
position = [10, 8, 0, 5, 3]
speed    = [ 2, 4, 1, 1, 3]
time     = [ 1, 1,12, 7, 3]

sort by pos

pos: [10, 8, 5, 3, 0]
t:   [ 1, 1, 7, 3, 12]

okay
lets go down the position order
if the time is less than or equal the time for one of the values before
that means it catches up? --> so that is considered 1 fleet


monotonic stack?


sort by position then add to the monotonic stack (ascending)

st: 1 1 7 --> this perfectly fine because ascending
add 3
st: 1 1 7 ... 3
pop 7
st: 1 1 3

actually no it should be less than or equal then pop
so:
st: 1 1
1 is equal so pop 1
st: 1 
- right now im guessing that the total elements in the stack is the final number of fleets but i want to trace it out
st: 1 7
st: 1 7 ... 3
3 is less than 7 so pop 7
st: 1 3
st: 1 3 12
final answer 12
the reason why this works is because by popping the bigger ones you are essentially removing a fleet and coutning them as one
so you want to use a while loop to pop all those that are greater cause that would all be considered 1 fleet
what remains is the total number of "unique" fleets

okay i think this makes sense







*/