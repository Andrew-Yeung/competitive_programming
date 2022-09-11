import java.util.*;
import java.io.*;

public class PizzaBag {
    static class pair{
        long val, index;
        pair(long a, long b){
            val = a;
            index = b;
        }
    }
    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt();
        long [] psa = new long[2*n];
        psa[0] = readLong(); psa[n] = psa[0];
        for(int i = 1; i < n; i++){
            psa[i] = readLong();
            psa[i + n] = psa[i];
            psa[i] += psa[i - 1];
        }
        for(int i = n; i < n * 2; i++){
            psa[i] += psa[i - 1];
        }
        Deque<pair> min = new ArrayDeque();
        long ans = 0;
        for(int i = 0; i < 2*n; i++){
            while(!min.isEmpty() && min.getFirst().index < i - k) min.removeFirst();
            while(!min.isEmpty() && min.getLast().val > psa[i]) min.removeLast();
            min.addLast(new pair(psa[i], i));
            ans = Math.max(ans, psa[i] - min.getFirst().val);
        }
        System.out.println(ans);
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
