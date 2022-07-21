import java.util.*;
import java.io.*;

public class cameras {
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt(), range = readInt();
        int [] mark = new int[n + 1];
        for (int i = 0; i < k; i++) {
            mark[readInt()] = 1;
        }
        int x = 0;
        for(int i = 1; i <= range; i++){
            x += mark[i];
        }
        int l = 1, r = range, ans = 0;
        while(true){
            if(r == n && x >= 2){
                System.out.println(ans);
                return;
            }
            if(x >= 2){
                l++; r++;
                x -= mark[l - 1];
                x += mark[r];
            }else{
                int need = 2 - x, cur = r;
                while(need > 0){
                    if(mark[cur] != 1){
                        mark[cur] = 1;
                        need--;
                        ans++;
                    }
                    cur--;
                }
                x = 2;
            }
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
