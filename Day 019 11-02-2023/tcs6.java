import java.io.*;
import java.util.*;

public class Solution {
    static int fib(int n){
        if(n ==1 || n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n%2 != 0)
            System.out.println(n);
        else{
            System.out.println(fib(n/2));
        }
    }
}
