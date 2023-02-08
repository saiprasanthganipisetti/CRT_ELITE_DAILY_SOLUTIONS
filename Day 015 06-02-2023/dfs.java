import java.util.ArrayList;

public class Solution {
    static void dfs(int source, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> ds){
        visited[source] = true;
        ds.add(source);
        for(int neigh : adjList.get(source)){
            if(!visited[neigh])
                dfs(neigh, adjList, visited, ds);
        }
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        //Adding v number of empty arraylists to the adjlist array.
        for(int i = 0; i < v; i++){
            adjList.add(new ArrayList<Integer>());
        }

        //Now filling the adjList
        for(int i = 0; i < edges.size(); i++){
            int m = edges.get(i).get(0);
            int n = edges.get(i).get(1);
            adjList.get(m).add(n);
            adjList.get(n).add(m);
        }

        //Declaring the arraylist to be returned.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        //declaring boolean array to track visited nodes 
        boolean[] visited = new boolean[v];

        for(int i=0; i < v; i++){
            
            if(!visited[i]){
                ArrayList<Integer> ds = new ArrayList<>();
                dfs(i, adjList, visited, ds);
                ans.add(ds);
            }
                
            
        }
        return ans;
    }
}
