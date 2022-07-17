import java.util.*;
import java.io.*;

public class PortalsCheck {
    static int tc = 5;
    static int find(int x, int [] p){
        if(x != p[x])p[x] = find(p[x], p);
        return p[x];
    }
    public static void main(String[] args) throws IOException {
        while(tc-->0){
            int n = readInt();
            int [] parent = new int[n + 3];
            for(int i = 1; i <= n + 2; i++){
                parent[i] = i;
            }
            HashMap<String, Integer> orz = new HashMap();
            int count = 1;
            for (int i = 0; i < n; i++) {
                int c = readCharacter();
                if(c == 'p'){
                    String a = next(), b = next();
                    if(orz.get(a)==null){
                        orz.put(a, count);
                        count++;
                    }
                    if(orz.get(b)==null){
                        orz.put(b, count);
                        count++;
                    }
                    int x = orz.get(a), y = orz.get(b);
                    if(find(x, parent) != find(y, parent)){
                        parent[find(x, parent)] = parent[find(y, parent)];
                    }
                }else{
                    String a = next(), b = next();
                    if(a.equals(b)){
                        System.out.println("connected");
                        continue;
                    }
                    if(orz.get(a)==null || orz.get(b)==null){
                        System.out.println("not connected");
                        continue;
                    }
                    int x = orz.get(a), y = orz.get(b);
                    if(parent[find(x, parent)] == parent[find(y, parent)]){
                        System.out.println("connected");
                    }else System.out.println("not connected");
                }
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
