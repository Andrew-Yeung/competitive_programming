

import java.util.*;
import java.io.*;

public class Frog1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int [] arr = new int [n + 1];
        for(int i=1;i<=n;i++){
            arr[i] = readInt();
        }
        int [] dp = new int [n + 1];
        //dp state: minimum # of moves to get to square i.
        if(n == 1){
            System.out.println(0);
            return;
        }
        if(n == 2){
            System.out.println(Math.abs(arr[2] - arr[1]));
            return;
        }
        dp[1] = 0;
        dp[2] = Math.abs(arr[2] - arr[1]);
        for(int i = 3;i<=n;i++){
            //two options
            //1. jump 1
            //2. jump 2
            //compare previous dp states and take min
            int one = dp[i - 1] + Math.abs(arr[i - 1] - arr[i]); //take one, which is why you backtrack 1
            int two = dp[i - 2] + Math.abs(arr[i - 2] - arr[i]); //take two
            dp[i] = Math.min(one, two);
        }
        System.out.println(dp[n]);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
