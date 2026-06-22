class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check to amke sure they all are 1-9
        //oragnized by rows and cols
        //but you also want to check separate 3x3 grids?
        //what if you map each square to a value
        //
        HashMap<String, Set<Character>> h = new HashMap<>();
        //trick is to use /3 as unique id for each of the 3x3 grids


        //check rows  cols
        for(int i = 0; i<board.length; i++){
            HashMap<Character, Integer> m1 = new HashMap<>();
            HashMap<Character, Integer> m2 = new HashMap<>();
            for(int j = 0; j<board[0].length; j++){

                String id =  i/3 + "," + j/3;
                //this is the id for each box


                if(board[i][j] != '.'){
                    if(!h.keySet().contains(id)){
                        h.put(id, new HashSet<Character>());

                    }else if(h.get(id).contains(board[i][j])){
                        return false;
                    }
                    h.get(id).add(board[i][j]);
                }
                
                if(board[i][j] != '.'){
                    if(!m1.containsKey(board[i][j])){
                        m1.put(board[i][j], 1);
                    }else{
                        return false;
                    }
                }
                if(board[j][i] != '.'){
                    if(!m2.containsKey(board[j][i])){
                        m2.put(board[j][i], 1);
                    }else{
                        return false;
                    }
                }
                

            }

            //now I want to check all the individual 3x3s



        }
        


        // for(int i = 0; i<board[0].length; i++){
        //     HashMap<Character, Integer> m2 = new HashMap<>();

        //     for(int j = 0; j<board.length; j++){
        //         if(!m2.containsKey(board[i][j])){
        //             m2.put(board[i][j], 1);
        //         }else{
        //             return false;
        //         }
        //     }
        // }





        return true;
    }
}
