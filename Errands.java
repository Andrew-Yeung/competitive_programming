/*
Author: Andrew Yeung
Date:   December 2nd, 2021
Link:   https://dmoj.ca/problem/globexcup18j5
*/

import java.util.*;
import java.io.*;
public class Errands {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n=readInt(),m=readInt(),q=readInt(),c=readInt();
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0;i<n;i++)adj[i]=new ArrayList();
        for(int i=0;i<m;i++){
            int x = readInt()-1,y=readInt()-1;
            adj[x].add(y); adj[y].add(x);
        }
        Queue<Integer> Q = new LinkedList();
        boolean[] vis = new boolean[n]; int[] dis = new int[n+1];
        Q.add(c-1);vis[c-1]=true;
        while(!Q.isEmpty()){
            int current = Q.poll();
            for(int i:adj[current]){
                if(!vis[i]){
                    Q.add(i); vis[i]=true; dis[i]=dis[current]+1;
                }
            }
        }
        for(int i=0;i<q;i++){
            int x=readInt()-1,y=readInt()-1;
            System.out.println(vis[x]&&vis[y]?dis[x]+dis[y]:"This is a scam!");
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
