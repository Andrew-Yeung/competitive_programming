import java.util.*;
import java.io.*;
public class DirectedGraphConnectivity {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        boolean[][] matrix = new boolean[n][n]; int[] one = new int[m]; int[] two = new int[m];
        for(int i=0;i<m;i++){
            //directed
            int x = readInt()-1, y = readInt()-1;
            matrix[x][y]=true; one[i]=x; two[i]=y;
        }
        //bruce force delete each connect BFS to see if still connected.
        for(int i=0;i<m;i++){
            int x = one[i], y = two[i];
            matrix[x][y]=false;
            boolean[] vis = new boolean[n]; Arrays.fill(vis, false);
            List<Integer> q = new ArrayList();
            q.add(0); vis[0]=true;
            int cur;
            while(!q.isEmpty()){
                cur = q.get(0); q.remove(q.get(0));
                for(int j=0;j<n;j++){
                    if(matrix[cur][j] && !vis[j]){
                        q.add(j); vis[j]=true;
                    }
                }
            }
            System.out.println(vis[n-1]?"YES":"NO");
            matrix[x][y]=true;
        }
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
