class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] edge: prerequisites){
            int a = edge[0];
            int b = edge[1];
            
            adj.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){   
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int course = queue.poll();

            for(int neighbour : adj.get(course)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        for(int degree : indegree){
            if(degree != 0){
                return false;
            }
        }

        return true;

    }
}
