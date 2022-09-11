import java.util.*;
import java.io.*;

public class Nightmare_a_thon {

    public static void main(String[] args) throws IOException {
        int n = readInt(), q = readInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }
        int [][] freq = new int[11][n];
        for(int i = 1; i <= 10; i++){
            if(arr[0] == i) freq[i][0] = 1;
            for (int j = 1; j < n; j++) {
                freq[i][j] = freq[i][j - 1];
                if(arr[j] == i) freq[i][j]++;
            }
        }
        int [] left = new int[n + 2];
        int [] right = new int[n + 2];
        left[1] = arr[0];
        right[n] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            left[i + 1] = Math.max(left[i], arr[i]);
            right[n - i] = Math.max(right[n - i + 1], arr[n - i - 1]);
        }
        for(int t = 0; t < q; t++){
            int x = readInt(), y = readInt();
            int one = Math.max(left[x - 1], right[y + 1]);
            int two = freq[one][n - 1] - freq[one][y - 1];
            if(x > 1) two += freq[one][x - 2];
            System.out.println(one + " " + two);
        }
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
