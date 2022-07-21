import java.util.*;
import java.io.*;

public class ChampContest {

    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt();
        int [] arr = new int[n];
        int [] sort = new int[n];
        int [] ans = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
            sort[i] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            int a = readInt() - 1, b = readInt() - 1;
            if(arr[a] > arr[b]) ans[a]--;
            if(arr[b] > arr[a]) ans[b]--;
        }
        Arrays.sort(sort);
        for(int i = 0; i < n; i++){
            int amount = lower_bound(sort, arr[i]);
            if(amount == 0 || amount == sort.length) ans[i] += 0;
            else ans[i] += amount;
            if(i != n - 1) System.out.print(ans[i] + " ");
            else System.out.println(ans[i]);
        }
    }
    static int lower_bound(int a[], long x) {
        long lo = 0, hi = a.length-1, ans = a.length;
        while(lo <= hi) {
            long mid = (lo + hi)/2;
            if(a[(int)mid] >= x) { ans = mid; hi = mid - 1; }
            else lo = mid + 1;
        }
        return (int)ans;
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
