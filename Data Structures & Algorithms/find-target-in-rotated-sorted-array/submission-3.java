class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        //< or <= --> it should be <=
        while(l <= r){
            int m = (l+r)/2;

            //check the edge cases --> 1 candidate 
            if(l == r && r == m){
                if(target == nums[l]){
                    return l;
                }else{
                    break;
                }
            }


            //check to see if the middle is the target
            if(nums[m] == target){
                return m;
            }

            //theres one edge case where its already ascending --> that means both halves are ascending and my algorithm doesn't handle it
            if(nums[r] - nums[m] > 0 && nums[m] - nums[l] > 0){
                //if both sides are ascending --> just choose the side that actually has the element
                if(nums[l] <= target && target <= nums[m]){
                    //if the target is on the left side
                    r = m - 1;
                }else if(target <= nums[r] && target >= nums[m]){
                    //if the target is on the right side
                    l = m + 1;
                }
            }

            if(nums[r] - nums[m] > 0){
                //right side ascending
                //once have ascending side
                if(nums[m] <= target && target <= nums[r]){
                    //must be on the right side
                    l = m + 1;
                }else{
                    //must be on the left side
                    r = m - 1;
                }
            }else{
                //left side is ascending
                if(nums[l] <= target && target <= nums[m]){
                    //on left side
                    r = m - 1;
                }else{
                    //on right side
                    l = m + 1;
                }
                /*
                3 1 target = 0
                l = 0
                r = 1
                m = 0
                
                l = 1
                r = 1
                m = 1
                */
            }
            //break;


        }
        return -1;
    }
}
/*
is my target between the ascending side --> you know if one side is ascending by looking to see if
- if the right side - middle is positive then the right side is ascending
- if the middle - left side is positive then the left side is ascending

so once you have the ascending side --> look at the furthest value towards that side --> if your target is between that value and the middle go look within
otherwise has to be on the other side

this doesn't work though because what if the target value is just less than the smallest value inside the array or greater than the biggest value inside the array

- can i handle this case separately

well --> does my algorithm already handle it?
if its not in the array at all
itll just continously choosing the non ascending side --> eventually when it gets down to the last candidate and sees its not the target itll just return -1
so it should be fine?

that means my alg still should work



*/
/*


3,4,5,6,1,2

target = 1

3 4 5 6 1 2

l = 0
r = 5
m = 2

is this not just binary search but with choosing the half based on if its > or < than the middle

2 < 5 --> choose right side
the target will always be between the side that 
if your target is between the left bound and the middle (in terms of value) --> then move left
if its greater then move right

don't you just compare left/right bound and middle to see if your target lands between

3 4 5 6 1 2

l = 0
r = 5
m = 2

since target = 1 and middle<target


2 3 4 5 6 1

6 1 2 3 4 5
well if you know where the smallest value is then you have a good range?
you have the smallest value and 
you can find which side the smallest value is on
thats also the side that probably has all values smaller than the middle value
if your target is less than the middle value then you want to choose the half that has the smallest value

target = 1

2 3 4 5 6 1

l = 0
r = 5
m = 2

invariant: my target has to be between l and r

target is less than 3
so choose side that has the smallest val --> choose right because 1 is < 4 (if the right value is less than the middle one it must be on that side)


l = 3
r = 5
m = 4

target is less than 6

l = 5
r = 5
m = 5

if they are all equal AND it is not the target that means that it does not exist
--> at each iteration i should be checking to see if the middle value = the target
don't need to worry about middle-1 case out of bounds then

test with more examples


target = -1
3,5,6,0,1,2

l = 0
r = 5
m = 2

choose right

l = 3
r = 5
m = 4

choose left

l = 3
r = 3
m = 3

l = r = m but it is not the target --> means it must not exist


target = 4

3,5,6,0,1,2


l = 0
r = 5
m = 2

choose left because the target is smaller and the smallest value is 






so you know which side resets the order




is it a given that only one half will always be ascending - yes
if my target is not in the range between the middle and the ascending side then it must be on the other side? --> is that how you deteremine which half the target could be in


target = 4

3,5,6,0,1,2

5 6 0 1 2 3

l = 0
r = 5
m = 2

target = 4
is my target between the ascending side --> you know if one side is ascending by looking to see if
- if the right side - middle is positive then the right side is ascending
- if the middle - left side is positive then the left side is ascending

so once you have the ascending side --> look at the furthest value towards that side --> if your target is between that value and the middle go look within
otherwise has to be on the other side

this doesn't work though because what if the target value is just less than the smallest value inside the array or greater than the biggest value inside the array

- can i handle this case separately

well --> does my algorithm already handle it?
if its not in the array at all
itll just continously choosing the non ascending side --> eventually when it gets down to the last candidate and sees its not the target itll just return -1
so it should be fine?

that means my alg still should work


target = 4

3,5,6,0,1,2

l = 0
r = 5
m = 2

choose left
l = 0
r = 1
m = 0

3 5

which side is ascending? --> right

l = 1
r = 1
m = 1

they are all equal --> check to see if its the target --> no --> exit and return -1

what if my final two were like this:

5 3 4 
5 3

l = 0
r = 1
m = 0
right side not ascending so choose left

l = 0
r = -1
--> break out of loop --> return -1





target = 4

5 6 0 1 2 3

target = 3

7 3 4 5 6

l = 0
r = 4
m = 2

l = 0
r = 1
m = 0

left side is ascending --> check to see if 3 is between --> no -- choose right

okay what about edge cases now

1) ascending

target: 1

1 2 3 4 5 6

l = 0
r = 5
m = 2

my idea of which side to choose fails now becuase both sides are ascending --> its not an automatic if not one then the other --> i need to check both
so in this case if they are both ascending then i just need to check which bounds in order to determine which side to cut

//ill just handle this case separately later --> i think i have an idea




2) 1 element

5

l = 0
r = 0
m = 0
all 3 are equal --> check if its the target --> if not exit --> this is already handled


1 3
l = 0
r = 1
m = 0

target = 3

its ascending to the right --> so check right side
- isn't it just because i use exclusive bounds when is should be doing inclusive

3 1 
target = 0

l = 0
r = 1
m = 0

look at left side
3-3 --> 0

3 1
target = 1
l = 0
r = 1
m = 0




i wanna go through loop one more time
i only need to break if the value doesn't exist at all




*/