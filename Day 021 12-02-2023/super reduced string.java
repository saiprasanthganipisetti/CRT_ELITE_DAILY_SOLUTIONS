import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static String superReducedString(String s) {
        String res = "Empty String";
        if(s.length() == 0)
           return res;
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;
        while(count < s.length()-1){
            if(s.charAt(count) == s.charAt(count+1)){
                arr.add(count);
                count += 2;
            }
            else{
                count += 1;
            }
        }
        System.out.println(arr);
        if(arr.size() == 0){
            return s;
        }
        else{
            System.out.println("else hello");
            int k = 0;
            for(int i : arr){
                s = s.substring(0,i-k).concat(s.substring(i+2-k));
                k += 2;
            }
            System.out.println("s before calling "+s);
            return superReducedString(s);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
