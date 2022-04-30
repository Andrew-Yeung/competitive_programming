import java.util.*;
import java.io.*;

public class dmopcmarchcontestproblem1{
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        long [] [] grid = new long [n][m];

        for(int i = 0; i  < n;i++){
            for (int j = 0; j < m; j++) {
                grid[i][j] = readLong();
            }
        }

        if(grid[n - 1][m - 1]==0){
            grid[n - 1][m - 1] = (long)1e18;
        }
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(grid[i][j] != 0)continue;
                else{
                    if(i == n - 1){
                        grid[i][j] = grid[i][j + 1] - 1;
                    }
                    else if(j == m - 1){
                        grid[i][j] = grid[i + 1][j] - 1;
                    }else{
                        grid[i][j] = Math.min(grid[i][j + 1], grid[i + 1][j]) - 1;
                    }
                }
            }
        }

        ///
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if(grid[i][j] <= 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        //check
        for(int i = 0; i < n; i++){
            List<Long> ok = new ArrayList();
            HashSet<Long> dup = new HashSet();
            for (int j = 0; j < m; j++) {
                ok.add(grid[i][j]);
                dup.add(grid[i][j]);
            }
            List<Long> check = new ArrayList(ok);
            Collections.sort(check);
            if(!check.equals(ok) || dup.size() != check.size()){
                System.out.println(-1);
                return;
            }
        }
        //check vert
        for(int i = 0; i < m; i++){
            List<Long> ok = new ArrayList();
            HashSet<Long> dup = new HashSet();
            for(int j = 0; j < n; j++){
                ok.add(grid[j][i]);
                dup.add(grid[j][i]);
            }
            List<Long> check = new ArrayList(ok);
            Collections.sort(check);
            if(!check.equals(ok) || dup.size() != check.size()){
                System.out.println(-1);
                return;
            }
        }

        for(int i = 0; i < n;i++){
            for(int j = 0;j <m;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
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
