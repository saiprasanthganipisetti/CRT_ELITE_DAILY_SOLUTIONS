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
    
    
    
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int m,n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        Queue<Pair> queue = new LinkedList<>();
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int time = -1;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 2){
                    queue.offer(new Pair(i,j));
                }    
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] a = {1,-1,0,0};
            int[] b = {0,0,1,-1};
            for(int i = 0; i < size; i++){
                Pair curr = queue.poll();
                for(int k = 0; k < 4; k++){
                    int newr = curr.row + a[k];
                    int newc = curr.col + b[k];
                    if(newr < 0 || newr >= m || newc < 0 || newc >= n)
                        continue;
                    if(arr[newr][newc] == 1){
                        queue.offer(new Pair(newr, newc));
                        arr[newr][newc] = 2;
                    }
                }
            }
            time++;
        }
        int flag = 0;
        for(int i =0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1)
                    flag = 1;
            }
        }
        if(flag == 0)
            System.out.println(time);
        else
            System.out.println(-1);
    }
}
