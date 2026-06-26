class Solution {
    int maxArea = 0;
    int currArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    // trigger DFS for this coordinate;
                    currArea++;
                    grid[i][j] = 0;
                    dfs(grid , i , j , m , n);
                    maxArea = Math.max(maxArea , currArea);
                    currArea = 0;
                }
            }
        }

        return maxArea;
    }

    public void dfs(int[][] grid , int r , int c , int m  , int n){
        int[][] directions = {
                     {-1 , 0}, 
            {0 , -1},         {0 , 1}, 
                     {1 , 0} 
        };

        for(int[] dir : directions){
            int newr = r + dir[0];
            int newc = c + dir[1];

            if(newr >= 0 && newr < m && newc >= 0 && newc < n && grid[newr][newc] == 1){
                currArea++;
                grid[newr][newc] = 0;
                dfs(grid , newr , newc , m , n);
            }
        }   

    }   
}
