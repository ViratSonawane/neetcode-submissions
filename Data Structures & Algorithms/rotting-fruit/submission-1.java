class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int freshOranges = 0;
        int time = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                }else if(grid[i][j] == 2){
                    queue.offer(new int[] {i , j});
                }
            }
        }


        int[][] directions = {           {-1 , 0},
                                {0 , -1},         {0 , 1},
                                          {1 , 0}           };

        while(!queue.isEmpty() && freshOranges > 0){
            int size = queue.size();

            for(int v = 0; v < size; v ++){
                int[] currCoordinates = queue.poll();
                int r = currCoordinates[0];
                int c = currCoordinates[1];

                for(int[] dir : directions){
                    int newr = r + dir[0];
                    int newc = c + dir[1];

                    if(newr >= 0 && newr < m && newc >= 0 && newc < n && grid[newr][newc] == 1){
                        queue.offer(new int[] {newr , newc});
                        grid[newr][newc] = 2;
                        freshOranges--;
                    }

                }
            }
            
            time++;
        }

        return freshOranges == 0 ? time : -1;

    }
}
