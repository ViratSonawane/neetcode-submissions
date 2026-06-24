class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;

        

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(grid[i][j] == '1'){
                    // trigger BFS;
                    grid[i][j] = '0';
                    dfs(grid , i , j , m , n);
                    count++;
                    
                }

            }
        }

        return count;
    }

    public void dfs(char[][] grid , int i , int j , int m , int n){
        int[][] directions = {
                    {-1 , 0},
            {0 , -1},        {0 , 1},
                    {1 , 0}
        };

        for(int[] dir : directions){
            int newr = i + dir[0];
            int newc = j + dir[1];

            if(newr >= 0 && newr < m && newc >= 0 && newc < n && grid[newr][newc] == '1'){
                grid[newr][newc] = '0';
                dfs(grid , newr , newc , m , n);
            }
        }
    }
}
