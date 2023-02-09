import java.io.*;
import java.util.*;

public class Solution {
    static class Pair{
        int row,col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static void bfs(int i, int j, int[][] arr){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i,j));
        while(!q.isEmpty()){
            int size = q.size();
            int[] a = {0,0,1,-1,1,-1,1,-1};
            int[] b = {1,-1,0,0,1,-1,-1,1};
            for(int p = 0; p < size; p++){
                Pair curr = q.poll();
                for(int k = 0; k < 8; k++){
                    int newr = curr.row + a[k];
                    int newc = curr.col + b[k];
                    if(newr < 0 || newr >= arr.length || newc < 0 || newc >=arr[0].length)
                        continue;
                    if(arr[newr][newc] == 1){
                        q.add(new Pair(newr,newc));
                        arr[newr][newc] = 0;
                    }
                }
            }
            
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int count = 0;
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < m; i++){
            for(int j =0; j <n; j++){
                if(arr[i][j] == 1){
                    count++;
                    bfs(i, j, arr);
                }
            }
        }
        System.out.println(count);
    }
}
