/*
Author: Andrew Yeung
Date:   December 8th, 2021
Link:   https://dmoj.ca/problem/oly21practice81
*/

import java.util.*;
import java.io.*;
public class BobEscapeMaze{
    static class pair{
        int r,c;
        pair(int r0, int c0){r=r0; c=c0;}
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        //template BFS, up down right left or knight L move
        int r = readInt(),c=readInt();
        char[][]g=new char[r][c];
        int start_x=readInt()-1,start_y=readInt()-1,end_x=readInt()-1, end_y=readInt()-1;
        for(int i=0;i<r;i++){
            String a = next();
            for(int j=0;j<a.length();j++){
                g[i][j]=a.charAt(j);
            }
        }
        int[][] d = {{-1,0}, {1,0}, {0, -1}, {0, 1}, {2, 1}, {1,2},{-1, 2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        pair start = new pair(start_x,start_y), end = new pair(end_x, end_y);
        boolean[][] vis = new boolean[r][c]; int[][] dis = new int[r][c];
        Queue<pair> q = new LinkedList();
        q.add(start); vis[start.r][start.c]=true;
        while(!q.isEmpty()){
            int r1=q.peek().r, c1=q.peek().c; q.poll();
            for(int i=0;i<12;i++){
                int nr = r1+ d[i][0], nc =c1+d[i][1];
                if(nr < 0 || nr >=r|| nc <0 || nc >=c|| vis[nr][nc] ||g[nr][nc]=='#')continue;
                q.add(new pair(nr,nc));
                vis[nr][nc]=true;
                dis[nr][nc]=dis[r1][c1]+1;
            }
        }
        System.out.println(vis[end.r][end.c]?dis[end.r][end.c]:-1);
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
