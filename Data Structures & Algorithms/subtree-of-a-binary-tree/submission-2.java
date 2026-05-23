/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null){
            return false;
        }
        if(isSame(root, subRoot)){
            return true;
        }
        if(isSame(root.left, subRoot) || isSame(root.right, subRoot)){
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);







        // int[][] arr = {{0,0,1},
        //                {1,0,0},
        //                {1,0,0},
        //                {1,0,1}


        //     };
        //     System.out.println(countThingy(arr));
            // return false;
    }
        


    }
    //then i can basically go thorugh my whole root to check tosee if any are the same as my subroot
    //need to create a function to check to see if two trees are the same
    public boolean isSame(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 != null && t2 != null && t1.val == t2.val){
            return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
        }else{
            return false;
        }
    }




//     public int countThingy(int[][] map){
//         int count = 0;
//         for(int i = 0; i < map.length; i++) {
//             for (int j = 0; j < map[0].length; j++) {
//                 if(i > 0 && map[i-1][j] == 1) {
//                     continue;
//                 }
//                 if(j > 0 && map[i][j-1] == 1) {
//                     continue;
//             }
//             if(map[i][j] == 1) {
//                 count++;
//             }
//         }
//     }
//     return count;

// }








// [2,2,1]
// [0,1,1]
// [0,0,0]










