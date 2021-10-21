import java.util.*;
import java.io.*;
public class PublicTransport{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static boolean[][] matrix;
    static boolean[] visited;
    static int[] depth;
    static int vertices;
    public static void main(String[] args) throws IOException{
        int lines = readInt(), og = readInt(), target = readInt(), escalators = readInt();
        matrix = new boolean[lines][lines];
        visited = new boolean[lines]; depth = new int[lines+1]; vertices = lines;
        for(int i=0;i<escalators;i++){
            int x = readInt(), y = readInt(); //edges are directed, one way
            matrix[x-1][y-1]=true;
        }
        BFS(og-1);
        System.out.println(depth[target-1]);
       // System.out.println(visited[target-1]);

    }
    static void BFS(int start){
        visited = new boolean[vertices];
        Arrays.fill(visited, false);
        List<Integer> q = new ArrayList<>();
        q.add(start);
        visited[start] = true;
        int vis;
        while(!q.isEmpty()){
            boolean isused = false;
            vis = q.get(0);
            q.remove(q.get(0));
            for(int i=0;i<vertices;i++){
                if(matrix[vis][i] == true && (!visited[i])){
                    q.add(i);
                    visited[i] = true;
                    depth[i]=depth[vis]+1;
                }
            }
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
