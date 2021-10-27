//fastest java sub as of 2021-10-27
import java.util.*;
import java.io.*;
public class DealingWithKnots {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int q = readInt();
        boolean[][] adj = new boolean[q][q];
        for(int i=0;i<q;i++){
            int x = readInt(), y = readInt(); //edges are directed
            adj[x-1][y-1]=true;
        }
        int a = readInt(), b = readInt();
        boolean[] visited = new boolean[q];
        Arrays.fill(visited, false);
        List<Integer> qu = new ArrayList();
        qu.add(a-1); //first vertex
        visited[0]=true;
        int curr;
        while(!qu.isEmpty()){
            boolean used = false;
            curr = qu.get(0);
            qu.remove(qu.get(0));
            for(int i=0;i<q;i++){
                if(adj[curr][i] && !visited[i]){
                    qu.add(i);
                    visited[i]=true;
                }
            }
        }
        System.out.println(visited[b-1] ==true? "Tangled":"Not Tangled");

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
