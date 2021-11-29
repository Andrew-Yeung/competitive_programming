/*
Author: Andrew Yeung
Date:   November 29th, 2021
Link:   https://dmoj.ca/problem/usaco19openbronze1
*/

import java.util.*;
import java.io.*;
public class BucketBrigade {
    static class pair{
        int r, c;
        pair(int r0, int c0){ r= r0; c=c0;}
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        char[][] grid = new char[10][10];
        int start_x =0, start_y=0, end_x=0, end_y=0;
        for(int i=0;i<10;i++){
            String a = readLine();
            for(int j=0;j<a.length();j++){
                grid[i][j]=a.charAt(j);
                if(grid[i][j]=='B'){start_x=i; start_y=j;}
                if(grid[i][j]=='L'){end_x=i; end_y=j;}
            }
        }
        Queue<pair> q=new LinkedList();
        boolean[][] vis= new boolean[10][19]; int[][] dis= new int[10][19];
        int[][] direction={{-1,0}, {1,0}, {0, -1}, {0, 1}};
        pair start = new pair(start_x, start_y), end = new pair(end_x, end_y);
        q.add(start); vis[start.r][start.c]=true;
        while(!q.isEmpty()){
            int r1=q.peek().r, c1 = q.peek().c; q.poll();
            for(int t=0;t<4;t++){
                int nr = r1+direction[t][0], nc = c1+direction[t][1];
                if(nr < 0 || nr >=10|| nc <0 || nc >=10|| vis[nr][nc] ||grid[nr][nc]=='R')continue;
                q.add(new pair(nr,nc));
                vis[nr][nc]=true;
                dis[nr][nc]=dis[r1][c1]+1;
            }
        }
        System.out.println(dis[end.r][end.c]-1);

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
