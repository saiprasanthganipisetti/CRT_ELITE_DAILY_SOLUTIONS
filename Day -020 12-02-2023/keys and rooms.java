class Solution {
    class Pair{
        int val;
        List<Integer> neighbours;
        public Pair(int val, List<Integer> neighbours){
            this.val = val; 
            this.neighbours = neighbours;
        }
    }

    public boolean check(int source, Queue<Pair> queue, List<List<Integer>> rooms, boolean[] visited){
        int count = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i < n; i++){
                Pair curr = queue.poll();
                count += 1;
                visited[curr.val] = true;
                for(int neigh : curr.neighbours){
                    if(!visited[neigh]){
                        queue.offer(new Pair(neigh,rooms.get(neigh)));
                    }
                }
            }
        }
        for(int i = 0; i < visited.length; i++){
            if(visited[i]==false)
                return false;
        }
        return true;

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, rooms.get(0)));
        boolean[] visited = new boolean[rooms.size()];
        return check(0, queue, rooms, visited);
    }
}
