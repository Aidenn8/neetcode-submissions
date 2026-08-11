class Solution {
    public int findMin(int[] nums) {
        //the first thing is that you want to find the middle
        //you probably still want that l<=r thing
        int l = 0;
        int r = nums.length-1;
        int middle = 0;
        while(l <= r){
            middle = (l+r)/2;
            /*
            4 5 6 7 
            l = 0
            r = 3
            m = 1
            
            l = 0
            r = 0
            m = 0
            ----------
            1 2
            l = 0
            r = 1
            m = 0

            l = 0
            r = 0
            m = 0

            ---------

            2 1
            l = 0
            r = 1
            m = 0

            l = 1
            r = 1
            m = 1
            m is 0 when you have two or 1 terms left
            --------
            1
            r = 0
            l = 0
            m = 0

            */
            //if they are all 0 then that means its already sorted
            //if they are all equal then just return it
            if(l == r && r == middle && middle == l){
                return nums[r];
            }
    
            if(middle != 0){
                if(nums[middle-1] > nums[middle]){
                    return nums[middle];
                }
            }
            
            //the last - the middle term can never be equal 0 cause all terms are unique
            if(nums[nums.length-1] - nums[middle] < 0){
                //if this is true then you know that you want the right half
                l = middle + 1;
            }else if(nums[nums.length-1] - nums[middle] > 0){
                r = middle - 1;
            //this logic below will only not work when the smallest term is the first term - so just handle that case separately
            }
            // if(l == r && l == 0){
            //     return nums[0];
            // }
        }
        return nums[middle];
        /*
        1 2
        l = 0
        r = 1
        m = 0

        l = 0
        r = 0
        m = 0

        /basically this is what happens when you get down to the last two values on the left side and you need to decide which is bigger

        when is my left value = my middle value - only when you are on the first term
        3 1 2


        2 3 1
        l = 0
        r = 2
        m = 1
        l = 2
        r = 2
        m = 2
        
        2 3 1
        l = 0
        r = 2
        m = 1
        l = 2
        r = 2
        m = 2
    



        1 2 3
        l = 0
        r = 2
        m = 1
        l = 0
        r = 0
        m = 0


        2 1
        l = 0
        r = 1
        m = 0

        l = 1
        r = 1
        m = 1




        3,4,5,6,1,2
        l = 0
        r = 5
        m = 2

        l = 3
        r = 5
        m = 4


        */
        //after you run this whole thing on that 1 edge case what happens?
        /*
        1 2 3 4 5 6

        l = 0
        r = 5
        m = 2
        choose left
        l = 0
        r = 1
        m = 0
        choose left
        l = 0
        r = 0
        m = 0
        if your left equals your right then what?
        it would be infinite which is not good
        my question now is - is the only time that l = r = m when the array is already sorted?

        4,5,6,7
        l = 0
        r = 3
        m = 1
        left
        l = 0
        r = 0
        m=0
        */

    }
}

/*
[3,4,5,6,1,2]
l = 0
r = 5

middle = 2
choose right side
l = 3
r = 5
m = 4

positive value
move your right side

l = 3
r = 3

i think you still run the n-1 check
if





*/
/*

[4,5,0,1,2,3]

 2 3 999 1000 0 1
its whenever you have a negative number from subtracting the right most value from the middle
then you want the right side
otherwise if the right side - the middle you always want the left side no matter what

the reason why is because if the smallest is on the right, that means that the middle value can never be smaller than the rightmost avlue becuase the order starts again

thats also why the numbers being unique matters

its because if the smallest one is on the right half it must mean that at some point on the right half, the ascending order must have switched and basically been reset --> that means that there is no way the right most value could ever be greater than the middle value
the flip side is true for the left





*/

/*





[3,4,5,6,1,2]

Sorted; [1,2,3,4,5,6]

[1, 2, 3, 4, 5, 6]

so if you know the sorted array its just the first element

the input is just the sorted array


maybe need to find out how many more rotations before sorted?

look at positions of smallest and biggest values

3 4 5 6 1 2

biggest: 3
smallest: 4


when you are rotating you are just moving elements from the front to the back

1 2 3 4 5 6

1 rotation

2 3 4 5 6 1

2 rotations

3 4 5 6 1 2

the array length is always the number of times for a full rotation


okay but you know that up until a certain point the array is sorted


[3,4,5,6,1,2]

Sorted: [1,2,3,4,5,6]

up until 6 its sorted

if you want o log n you need to be constantly cutting this array up somehow
i mean you could always look at adajacent values to see if they are ascending if not then you found the smallest?

so lets chop in 2

3 4 5 
6 1 2


okay so here is probably where i start
if the n+1 element is smaller than the nth element then it has to be the smallest one

ig you only need to consider half the array?
4 6 2
cause then you can just look at the prev terms
look at every other term and then chop out the other?
3 4 5 6 1 2
  4   6   2
if the n-1 term is less then continue
otherwise then you found it
then once you have just every other term


4 5 6 1 2 3
  5   1   3
4 5 6 1 2 3
4   6   2

you since 6 and 2 decrease you know it has to be in the 2nd half
you can chop out the first half

4 5 6 1 2 3
4   6   2

    6   2
                then you gotta look at the number between them
4 5 6 1 2 3
    6 1 2
you could do this recursively then
you take

4 5 6 1 2 3
look at half
you look at l+r/2
you get 2 which is 6
you look at the term to the left
since its smaller then you look at the right half
- - 6 1 2 3
l = 2
r = 5
m = 3

you are at 1
look to the left --> its bigger
this is a bad example


3 4 5 6 1 2

look at 5

4 and 5 chill look at right half

3 4 5 6 1 2
    5 6 1 2
l = 2
r = 5
m = 3 (6)
look left its chill
look at right half again

3 4 5 6 1 2
      6 1 2
l = 3
r = 5
m = 4
look left not chill
you found it


6 1 2 3 4 5

okay but that doesn't always work
cause then you need to look at the entire half and compare the middle to all of them not just the one on the left

okay then the question becomes how do you find which half you should look at next
unless you do two recursive calls? - but this isn't linear cause two recursive for each half would still be O(n)

how do you find which half?

maybe something to do with the length of the array and number of rotations

5 6 1 2 3 4

if you divide by 2 then one side always has the end value be bigger than the middle one?
is this true?


1 2 3 4 5 6
want the left half
r: 6-3 = 3
l: 3-1 = 2

6 1 2 3 4 5
want the left half
r: 5-2 = 3
l: 6-2 = 4

5 6 1 2 3 4

4 5 6 1 2 3
want the right half
r: 3-6 =-3
l: 4-6 =-2

3 4 5 6 1 2

r: -3
l: -2

4 5 6 1 2 3
r: -3
l: 

[4,5,0,1,2,3]

 2 3 999 1000 0 1
its whenever you have a negative number from subtracting the right most value from the middle
then you want the right side
otherwise if the right side - the middle you always want the left side no matter what

the reason why is because if the smallest is on the right, that means that the middle value can never be smaller than the rightmost avlue becuase the order starts again

thats also why the numbers being unique matters

its because if the smallest one is on the right half it must mean that at some point on the right half, the ascending order must have switched and basically been reset --> that means that there is no way the right most value could ever be greater than the middle value
the flip side is true for the left


*/