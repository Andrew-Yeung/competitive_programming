import java.util.*;
import java.io.*;

public class railwaysort {

    public static void main(String[] args) throws IOException {
        int t = 10;
        while(t-->0){
            int n = readInt();
            List<Integer> arr = new ArrayList();
            for (int i = 0; i < n; i++) {
                arr.add(readInt());
            }
            int m = n, ans = 0, c = n;
            while(c-->0){
                int index = 0;
                for (int i = 0; i < n; i++) {
                    if(arr.get(i) == m){
                        index = i; break;
                    }
                }
                boolean check = true;
                for(int i = index; i >= 0; i--){
                    if(arr.get(i) > m){
                        check = false; break;
                    }
                }
                if(!check){
                    ans += index;
                    arr.remove(index);
                    arr.add(0, m);
                }
                m--;
            }
            System.out.println(ans);
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
