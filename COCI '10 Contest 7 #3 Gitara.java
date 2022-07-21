import java.util.*;
import java.io.*;

public class gitara {

    public static void main(String[] args) throws IOException {
        int n = readInt(), p = readInt(), ans = 0;
        List<Integer> adj[] = new ArrayList[7];
        for(int i = 1; i <= 6; i++){
            adj[i] = new ArrayList();
        }
        for (int i = 0; i < n; i++) {
            int s = readInt();
            int x = readInt();
            adj[s].add(x);
        }
        for(int x = 1; x <= 6; x++){
            if(adj[x].isEmpty()) continue;
            Stack<Integer> stack = new Stack();
            for (int i = 0; i < adj[x].size(); i++) {
                int c = adj[x].get(i);
                boolean check = true;
                if(!stack.isEmpty() && c == stack.peek()){
                    continue;
                }
                while(!stack.isEmpty() && stack.peek() > c){
                    stack.pop(); ans++;
                    if(!stack.isEmpty() && stack.peek() == c){
                        check = false; break;
                    }
                }
                if(check){
                    stack.push(c); ans++;
                }
            }
            stack.clear();
        }
        System.out.println(ans);
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
