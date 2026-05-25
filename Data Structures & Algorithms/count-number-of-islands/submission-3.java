class Solution {
    public int numIslands(char[][] grid) {
        //do thsi recursviely
        //search all next islands
        int total = 0;
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                if(grid[r][c] == '1'){
                    search(grid, r, c);
                    total+=1;
                }

            }
        }
        return total;
    }  

    public void search(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r>grid.length-1 || c > grid[0].length-1){
            return;
        }
        if(grid[r][c] == '1'){
            grid[r][c] = '0';
            search(grid, r+1, c);
            search(grid, r, c+1);
            search(grid, r-1, c);
            search(grid, r, c-1);
        }
    }
}

