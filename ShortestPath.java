import java.util.*;
import java.io.*;
public class ShortestPath {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        boolean[][] adj = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int a = readInt();
                if(a == 1) adj[i][j]=true;
                else adj[i][j]=false;
            }
        }
        boolean[] visited = new boolean[n];
        int[] distance = new int[n+1];
        Arrays.fill(visited, false);
        List<Integer> q = new ArrayList();
        q.add(0); //first vertex
        visited[0]=true;
        int curr;
        while(!q.isEmpty()){
            boolean used = false;
            curr = q.get(0);
            q.remove(q.get(0));
            for(int i=0;i<n;i++){
                if(adj[curr][i] && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                    distance[i]=distance[curr]+1;
                }
            }
        }
        System.out.println(distance[n-1]);

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
