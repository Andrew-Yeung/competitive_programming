/*
Author: Andrew Yeung
Date:   November 27th, 2021
Link:   https://dmoj.ca/problem/dwite08c1p3
*/

import java.util.*;
import java.io.*;
public class SchoolsAMaze {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static class pair{
        int r, c; pair(int r0, int c0){r=r0; c=c0;}
    }
    public static void main(String[] args) throws IOException{
        //BFS each
        char[][] matrix = new char[10][19];
        for(int i=0;i<10;i++){
            String a=readLine();
            for(int j=0;j<a.length();j++){
                matrix[i][j]=a.charAt(j);
            }
        }
        for(int i=0;i<5;i++){
            String a = readLine();
            if(a.length()==1) System.out.println(0);
            else{
                int ans = 0;
                for(int j=0;j<a.length()-1;j++){
                    char first = a.charAt(j);
                    char second = a.charAt(j+1);
                    int one_x = 0, one_y = 0, two_x=0, two_y=0;
                    orz:
                    for(int r=0;r<10;r++){
                        for(int c=0;c<19;c++){
                            if(matrix[r][c]==first){one_x=r; one_y=c;}
                            if(matrix[r][c]==second){two_x=r; two_y=c;}
                            if(one_x != 0 && two_x != 0)break orz;
                        }
                    }
                    Queue<pair> q=new LinkedList();
                    boolean[][] vis= new boolean[10][19]; int[][] dis= new int[10][19];
                    int[][] direction={{-1,0}, {1,0}, {0, -1}, {0, 1}};
                    pair start = new pair(one_x, one_y), end = new pair(two_x, two_y);
                    q.add(start); vis[start.r][start.c]=true;
                    while(!q.isEmpty()){
                        int r1=q.peek().r, c1 = q.peek().c; q.poll();
                        for(int t=0;t<4;t++){
                            int nr = r1+direction[t][0], nc = c1+direction[t][1];
                            if(nr < 0 || nr >=10|| nc <0 || nc >=19|| vis[nr][nc] ||matrix[nr][nc]=='#')continue;
                            q.add(new pair(nr,nc));
                            vis[nr][nc]=true;
                            dis[nr][nc]=dis[r1][c1]+1;
                        }
                    }
                    ans+=dis[end.r][end.c];
                }
                System.out.println(ans);
            }
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
