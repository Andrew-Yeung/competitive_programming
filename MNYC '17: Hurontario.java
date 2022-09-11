import java.util.*;
import java.io.*;

public class Hurontario {
    final static int base = 131;
    final static int MOD = (int) 1e9 + 7;
    final static int MM = (int) 1e6 + 5;
    public static void main(String[] args) throws IOException {
        String [] x = readLine().split(" ");
        String a = x[0], b = x[1];
        long [] hash_b = new long [b.length()];
        long [] power = new long [MM];
        power[0] = 1;
        hash_b[0] = b.charAt(0);
        for (int i = 1; i < b.length(); i++) {
            hash_b[i] = (hash_b[i - 1] * base + b.charAt(i)) % MOD;
        }
        for (int i = 1; i < MM; i++) {
            power[i] = power[i - 1] * base % MOD;
        }
        int ans = 0;
        long check = 0;
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            check += a.charAt(a.length() - i - 1) * power[i];
            check %= MOD;
            if(check == hash_b[i]) ans = i + 1;
        }
        System.out.println(a + b.substring(ans, b.length()));
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
