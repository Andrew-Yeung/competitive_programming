import java.util.*;
import java.io.*;

public class THICC_17_P5_Smarties {

    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt(), MM = (int) (1e5+3), distinct = 0;
        int [] a = new int[MM], f = new int[(int)1e6 + 5];
        long ans = 0;
        for(int l=1, r=1; r<=n; r++) {
            a[r] = readInt(); f[a[r]]++;
            if(f[a[r]] == 1) distinct++;
            while(distinct >= k) {
                ans += n-r+1;
                f[a[l]]--;
                if(f[a[l]]==0) distinct--;
                l++;
            }
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
