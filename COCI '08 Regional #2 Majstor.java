import java.util.*;
import java.io.*;

public class Majstor {
    static int n;
    public static void main(String[] args) throws IOException {
        int r = readInt();
        char [] arr = readLine().toCharArray();
        n = readInt(); int ans = 0, max = 0;
        char[][] scores = new char[n][r];
        for (int i = 0; i < n; i++) {
            String x = next();
            for (int j = 0; j < x.length(); j++) {
                scores[i][j] = x.charAt(j);
                if(arr[j] == 'S' && scores[i][j] == 'P'){
                    ans += 2; continue;
                }
                if(arr[j] == 'P' && scores[i][j] == 'R'){
                    ans += 2; continue;
                }
                if(arr[j] == 'R' && scores[i][j] == 'S'){
                    ans += 2; continue;
                }
                if(arr[j] == scores[i][j]){
                    ans++;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            max += Math.max(solve('R', i, scores), Math.max(solve('P', i, scores), solve('S', i, scores)));
        }
        System.out.println(ans);
        System.out.println(max);
    }
    static int solve(char c, int index, char[][] grid){
        int r = 0;
        for (int i = 0; i < n; i++) {
            if(c == 'S' && grid[i][index] == 'P'){
                r += 2; continue;
            }
            if(c == 'P' && grid[i][index] == 'R'){
                r += 2; continue;
            }
            if(c == 'R' && grid[i][index] == 'S'){
                r += 2; continue;
            }
            if(c == grid[i][index]) {
                r++;
            }
        }
        return r;
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
