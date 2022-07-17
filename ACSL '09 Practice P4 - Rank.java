/*
Author: Andrew Yeung
Date:   
Link:
*/

import java.util.*;
import java.io.*;

public class RAnk {
    static List<Integer> adj[];
    static boolean vis[];
    static boolean inloop[];
    static HashSet<Integer> ans = new HashSet();
    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt();
        adj = new ArrayList[n+1];
        vis = new boolean[n+1];
        inloop = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList();
        }
        while(k-->0){
            int a = readInt(), b = readInt();
            int score_a = readInt(), score_b = readInt();
            if(score_a > score_b){
                adj[a].add(b);
            }else adj[b].add(a);
        }
        for(int i = 1; i <= n;i++){
            //System.out.println(i + " -> " + adj[i]);
        }
        for(int i = 1; i <= n;i++){
            dfs(i);
        }
        System.out.println(ans.size());
    }
    static void dfs(int x){
        vis[x] = true;
        inloop[x] = true;
        for(int cur : adj[x]){
            if(inloop[cur]){
                for (int i = 0; i < inloop.length; i++) {
                    if(inloop[i])ans.add(i);
                }
                return;
            }
            else if(!vis[cur])dfs(cur);
        }
        inloop[x] = false;
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
