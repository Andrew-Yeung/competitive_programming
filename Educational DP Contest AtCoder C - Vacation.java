import java.util.*;
import java.io.*;

public class dpc {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        long [][] dp = new long[n][3];
        for (int i = 0; i < n; i++) {
            int a = readInt(), b = readInt(), c = readInt();
            if(i == 0){
                dp[0][0] = a; dp[0][1] = b; dp[0][2] = c;
            }else{
                dp[i][0] = a + Math.max(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = b + Math.max(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = c + Math.max(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        System.out.println(Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2])));
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
