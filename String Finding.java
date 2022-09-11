import java.util.*;
import java.io.*;

public class StringFinding {
    final static int base = 131;
    final static int MOD = (int) 1e9 + 7;
    public static void main(String[] args) throws IOException {
        String s = next(), t = next();
        char [] arr = s.toCharArray();
        int len = t.length();
        long [] hash = new long[s.length()];
        long [] power = new long[s.length()];
        power[0] = 1;
        hash[0] = arr[0];
        for(int i = 1; i < s.length(); i++){
            hash[i] = (hash[i - 1] * base + arr[i]) % MOD;
            power[i] = power[i - 1] * base % MOD;
        }
        long [] hash_2_2 = new long[len];
        hash_2_2[0] = t.charAt(0);
        for (int i = 1; i < len; i++) {
            hash_2_2[i] = (hash_2_2[i - 1] * base + t.charAt(i)) % MOD;
        }
        long check = hash_2_2[len - 1];
        for(int l = 0, r = len - 1; r < s.length(); l++, r++){
            long compare = l == 0 ? hash[r] : (hash[r] - hash[l - 1] * power[r - l + 1] % MOD + MOD) % MOD;
            if(check == compare){
                System.out.println(l);
                return;
            }
        }
        System.out.println(-1);
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
