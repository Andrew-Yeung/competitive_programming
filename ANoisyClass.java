/*
Author: Andrew Yeung
Date:   November 30th, 2021
Link:   https://dmoj.ca/problem/anoisyclass
*/

import java.util.*;
import java.io.*;
public class ANoisyClass {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        //topological sort
        int n = readInt(), m = readInt();
        List<Integer> adj[] = new ArrayList[n+1];
        int[] in_degree = new int[n+1];
        for(int i=1;i<=n;i++)adj[i]=new ArrayList();
        for(int i=0;i<m;i++){
            int x = readInt(), y = readInt(); //directed connection
            adj[x].add(y);
            in_degree[y]++;
        }
        //topological sort
        PriorityQueue<Integer> q = new PriorityQueue();
        for(int i=1;i<=n;i++){
            if(in_degree[i]==0)q.add(i); //no incoming edges
        }
        List<Integer> ans = new ArrayList();
        while(!q.isEmpty()){
            int current = q.poll();
            ans.add(current);
            for(int i: adj[current]){
                in_degree[i]--;
                if(in_degree[i]==0)q.add(i);
            }
        }
        //if we have all nodes in list, there is a possible ordering, otherwise no
        System.out.println(ans.size()==n?"Y":"N");
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
