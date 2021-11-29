/*
Author: Andrew Yeung
Date:   November 27th, 2021
Link:   https://dmoj.ca/problem/hci16oversleep
*/

import java.util.*;
import java.io.*;
public class Oversleep {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int r=readInt(),c=readInt();
        char[][]matrix=new char[r][c];
        int startx = 0,starty=0,endx=0,endy=0;
        for(int i=0;i<r;i++){
            String a=readLine();
            for(int j=0;j<a.length();j++){
                matrix[i][j]=a.charAt(j);
                if(matrix[i][j]=='s'){startx=i; starty=j;}
                if(matrix[i][j]=='e'){endx=i; endy=j;}
            }
        }
        Queue<pair> q=new LinkedList();
        boolean[][] vis= new boolean[r][c]; int[][] dis= new int[r][c];
        int[][] direction={{-1,0}, {1,0}, {0, -1}, {0, 1}};
        pair start = new pair(startx,starty), end = new pair(endx,endy);
        q.add(start); vis[start.r][start.c]=true;
        while(!q.isEmpty()){
            int r1=q.peek().r, c1 = q.peek().c; q.poll();
            for(int i=0;i<4;i++){
                int nr = r1+direction[i][0], nc = c1+direction[i][1];
                if(nr < 0 || nr >=r|| nc <0 || nc >=c|| vis[nr][nc] ||matrix[nr][nc]=='X')continue;
                q.add(new pair(nr,nc));
                vis[nr][nc]=true;
                dis[nr][nc]=dis[r1][c1]+1;
            }
        }
        System.out.println(vis[end.r][end.c]?(dis[end.r][end.c])-1: -1);
    }
    static class pair{
        int r,c;
        pair(int r0, int c0){ r= r0; c=c0;}
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
