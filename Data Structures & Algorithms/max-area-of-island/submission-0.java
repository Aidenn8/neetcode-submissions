class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int total = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                total = Math.max(total, dfs(grid, i, j));
            }
        }
        return total;
    }

    public int dfs(int[][] grid, int r, int c){
        if(r<0 || c<0 || r>grid.length-1 || c > grid[0].length-1){
            return 0;
        }
        if(grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        return 1 + dfs(grid, r+1, c) + dfs(grid, r, c+1) + dfs(grid, r-1, c) + dfs(grid, r, c-1);
    }
}
