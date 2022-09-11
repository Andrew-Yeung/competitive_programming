import java.util.*;
import java.io.*;

public class GoingBacktotheDefinitions {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        List<String> ans = new ArrayList();
        for (int i = 0; i < n; i++) {
            ans.add(next());
        }
        Collections.sort(ans, (x, y) -> (y + x).compareTo(x + y));
        for(int i = 0; i < n; i++){
            System.out.print(ans.get(i));
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
