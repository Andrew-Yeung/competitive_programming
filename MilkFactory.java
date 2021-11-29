/*
Author: Andrew Yeung
Date:   November 29th, 2021
Link:   https://dmoj.ca/problem/usaco19openbronze2
*/

import java.util.*;
import java.io.*;
public class USACO_MilkFactory{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        //BFS
        int n =readInt();
        boolean[][] matrix=new boolean[n][n];
        for(int i=0;i<n-1;i++){
            int x =readInt()-1,y=readInt()-1;
            matrix[x][y]=true;
        }
        for(int i=0;i<n;i++){
            int cur = i;
            boolean flag = true;
            for(int j=0;j<n;j++){
                Queue<Integer> q = new LinkedList();
                boolean[]vis = new boolean[n];
                q.add(j); vis[j]=true;
                while(!q.isEmpty()){
                    int a=q.poll();
                    for(int w=0;w<n;w++){
                        if(matrix[a][w] && !vis[w]){
                            q.add(w); vis[w]=true;
                        }
                    }
                }
                if(!vis[cur])flag=false;
            }
            if(flag){
                System.out.println(i+1);
                return;
            }
        }
        //if no ans print -1
        System.out.println(-1);
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
