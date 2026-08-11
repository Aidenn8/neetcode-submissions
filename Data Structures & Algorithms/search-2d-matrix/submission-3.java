class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //first lets id which row my target is in
        int top = 0;
        int bottom = matrix.length-1;

        /*
        [ 1, 2, 4, 8]
        [10,11,12,13]
        [14,20,30,40]

        t = 0
        b = 2
        m = 1
        target < matrix[1][0]
        target > matrix[1][3]
        targetRow = 

        */


        /*
        [ 1, 3, 5, 7]
        [10,11,16,20]
        [23,30,34,60]

        top = 0
        bottom = 2
        target = 3
        m = 1
        matrix[1][0]
        bottom = 0

        middle = 0
        target < matrix[0][0]
        no
        target>matrix[0][3]
        no
        targetRow=0

        */

        int targetRow = -1;

        while(top <= bottom){

            int middle = (top+bottom)/2;
            //if the target is before the left 
            if(target < matrix[middle][0]){
                bottom = middle - 1;
            }else if(target > matrix[middle][matrix[0].length-1]){
                //if its in the bottom half
                top = middle + 1;
            }else{
                //found the target row
                targetRow = middle;
                break;
            }
        }
        //if there is no targetRow then it doesn't exist within the matrix
        if(targetRow == -1){
            return false;
        }




        //found target row
        //now its just a binary search within the row for the target

        /*
        targetRow = 0
        [ 1, 3, 5, 7]
        [10,11,16,20]
        [23,30,34,60]
        r = 0
        l = 3

        middle = 1
        target < matrix[0][1]


        */
        System.out.println(targetRow);

        int l = 0;
        int r = matrix[0].length-1;
        while(l <= r){
            int middle = (r+l)/2;
            System.out.println(matrix[targetRow][middle]);
            //if in the first half
            if(target < matrix[targetRow][middle]){
                //move the right pointer to the middle - 1
                r = middle - 1;
            }else if(target > matrix[targetRow][middle]){
                l = middle + 1;
            }else if(target == matrix[targetRow][middle]){
                //found the target
                return true;
            }
        }
        //if passes through without finding the target - means doesn't exist
        return false;


    }
}

/*
so my full algorithm is literally just two binary searches

first you want to id which row the target is in
you do that by looking at the middle row and then check these things
if your target is bounded between the leftmost and rightmost values of that row then you found your row
if you target is less than the leftmost value then that means its in the top half and you cut the top half and repeat to find the row
if your target is greater than the rightmost value then that means its in the bottom half and you cut the bottom half and repeat to find the row


how do you write a binary search algorithm again?

10 11 12 13
l        r

two pointers i think

m = (l+r)/2 = 1

within a for loop
or maybe use a while loop?
while(l <= r)
m= (l+r)/2
if(target < arr[m]){
    r = m;
}else if(target > arr[m]){
    l = m+1;
}else{
    return true;
}


return false;


10 11 12 13
 l  m


then check

*/


/*
binary search it?
store into a 1d array?



 1  2  4  8 
10 11 12 13
14 20 30 40

4x4



1 2 4 8 10 11 12 13 




why don't i slap it into a 1d array and then just search with binary



but that would be O(m*n) --> no bueno


you can just look at 



examine each row individually


target = 10

 1  2  4  8 
10 11 12 13
14 20 30 40


look at first row
not between 1 or 8
look at second row
is between 10 and 13
now focus on the 2nd row
split into 2 and look at half
in the first half
then just run binary search

O(n + logm)

okay how do i figure out what row the target is in quicker
do i basically have two different points
one of them is on the left side top
the other one is on the right side bottom

or maybe its like
you cut the matrix in half (look at the middle row)
if its not between and the target is less than the left most element then split the top half
if its not between and the target is greater than the right most element then split the bottom half
repeat until you find the row that the left value of the row < target < the right value of the row



*/


































/*


[9 17 14 23 11]

m = 5

[4 2    3  1]

[4, 2, 4, 3, 1]

find subarray that has length less than k

k=3


need a base 

you can add values to the 

build a subarray of length k that is a multiple of m

m = 5

but it can't be a direct multiple of m (if k>1)

4 3 

you can generate k-1 values and they lowk don't matter except for the kth one
cause you just subtract the sum of k-1 from the closest multiple of 5 to get the kth value

that will get you the subarray of length k
but how do you make sure that the subarrays within the subarray k are also not multiples of m (5)

recursive?
you keep on removing the next value within the subarray k and testing?
you shrink the subarray again and again

so lets say you build 
4 2 4 3 2

you should look at 4 2 4 3 2 which is valid
but then you should look at 4 2 4 3 is fine
4 2 4 fine
4 2 fine
4 fine

but then you can do the same when expanding to the right

basically you have a subarray and then you need to look at both the left and the right
maybe it makes it easier to just keep the subarray to the left/right and then expand out

1 2 3 
you can just choose any number?
how do you know what numbers to start with?
they shouldn't be a multiple of m
i guess maybe you build outwards?
and only when you are at k-1 term then you can make the kth value to make the total k subarray a multiple of 5

you start with 


all you really need to track is if the subarray you are building contains a multiple of 5

in the example 

9 17 14 23 11
4  2  4  3  1
5 15 10 20 10






you are just adding by multiples of 5 until its valid from this


where to start

m = 5
k = 3
a = 5

[0, 0, 0, 0, 0]

[]


example just added mmultiples of 5 to 4 2 4 3 1
4 2 4 works



---
n is how big the array is
k is the length of the subarray
m is the multiple




m = 3
k = 3
a = 6

6

2 2 2 1 1 1
two numbers can't add up to k




just fill with 1 1 1 1 reminder



k cannot be greater than 


*/

// public int[] thing(int n, int k, int m) {
//     //n is overall length
//     //k is subarray
//     //m is multiple

//     //not possible
//     if(k>m){
//         return null;
//     }


//     int[] arr = new int[n];

//     for(int i = 0; i<k; i++){
//         //fill up until k-1 with 1s
//         arr[i] = 1;
//     }

//     //fill the 
//     for(int i = 0; i<arr.length; i++){

//     }

// }













