import java.util.*;
import java.io.*;

public class ok {

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), a = readInt(), b = readInt();
        List<Integer> adj[] = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            int x = readInt(), y = readInt();
            adj[x].add(y); adj[y].add(x);
        }
        Queue<Integer> q = new LinkedList();
        int [] dis = new int[n + 1];
        boolean [] vis = new boolean[n + 1];
        q.add(1);
        vis[1] = true;
        while(!q.isEmpty()){
            int c = q.poll();
            for(int x : adj[c]){
                if(!vis[x]){
                    q.add(x);
                    vis[x] = true;
                    dis[x] = dis[c] + 1;
                }
            }
        }
        int ans = 0;
        if(!vis[a]){
            System.out.println(-1);
            return;
        }
        ans += dis[a];
        Arrays.fill(vis, false);
        Arrays.fill(dis, 0);
        q.add(a);
        vis[a] = true;
        while(!q.isEmpty()){
            int c = q.poll();
            for(int x : adj[c]){
                if(!vis[x]){
                    q.add(x);
                    vis[x] = true;
                    dis[x] = dis[c] + 1;
                }
            }
        }
        if(!vis[b]){
            System.out.println(-1);
        }else System.out.println(ans + dis[b]);
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
