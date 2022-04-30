import java.util.*;
import java.io.*;

public class PathToWaterloo {

    public static    void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        List<Integer> adj[] = new ArrayList[(int)1e6];
        for(int i = 0; i <= (int)1e6-1; i++){
            adj[i] = new ArrayList();
        }
        adj[1].add(2);
        HashMap<String, Integer> places = new HashMap();
        places.put("home", 0);
        places.put("Waterloo GO", 6969);
        int count = 1;
        for(int i = 1; i<=n;i++){
            String a = readLine();
            if(places.get(a)==null){
                places.put(a, count);
                count++;
            }
        }
        for(int i = 1; i<=m;i++){
            String thing = readLine();
            int split = 0;
            for (int j = 0; j < thing.length(); j++) {
                if(thing.charAt(j)=='-'){
                    split  =j;break;
                }
            }
            String first = thing.substring(0, split);
            String second = thing.substring(split + 1, thing.length());
            int x = places.get(first), y = places.get(second);
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] vis = new boolean[(int)1e6];
        int [] dis = new int[(int)1e6];
        Queue<Integer> q = new LinkedList();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int current = q.poll();;
            for(int i : adj[current]){
                if(!vis[i]){
                    q.add(i);
                    vis[i] = true;
                    dis[i] = dis[current] + 1;
                }
            }
        }
        if(vis[6969]){
            System.out.println(dis[6969]);
        }else{
            System.out.println("RIP ACE");
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
