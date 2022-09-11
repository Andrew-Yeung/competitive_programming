import java.util.*;
import java.io.*;

public class Frog2 {

    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt();
        int [] arr = new int[n + 1];
        int [] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = readInt();
        }
        Arrays.fill(dp, (int) 1e9 + 5);
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if(i - j < 1) continue;
                dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(arr[i] - arr[i - j]));
            }
        }
        System.out.println(dp[n]);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
