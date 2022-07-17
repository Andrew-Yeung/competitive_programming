//hello there

import java.util.*;
import java.io.*;

public class Slikar {
    static int[][] direction = {{-1,0}, {1,0},{0,-1}, {0,1}};
    static class pair {
        int r, c;
        pair(int r0, int c0) {r = r0; c = c0;}
    }
    static void go(char[][] grid, boolean[][] vis, int[][] dis, int startr, int startc, int[][] times, int R, int C){
        Queue<pair> q = new LinkedList();
        q.add(new pair(startr, startc));
        vis[startr][startc]=true;
        while(!q.isEmpty()){
            int r1 = q.peek().r, c1 = q.peek().c;
            q.poll();
            int time = dis[r1][c1];
            boolean[][] block = new boolean[R][C];
           // System.out.println(r1  + " "+c1 + " time -> "+time);
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(times[i][j]<=time && times[i][j]!=-1 &&times[i][j]!=0){
                        block[i][j]=true;
                        grid[i][j]='*';
                    }
                    //System.out.print(block[i][j]+" ");
                }
                //System.out.println();
            }
            //System.out.println("");
            if(block[r1][c1]){
                vis[r1][c1]=false;
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r1 + direction[i][0], nc = c1 + direction[i][1];
                if(nr < 0 || nr >=R|| nc <0 || nc >=C|| vis[nr][nc]||grid[nr][nc]=='X'||grid[nr][nc]=='*'||block[nr][nc])continue;
                q.add(new pair(nr, nc));
                vis[nr][nc] = true;
                dis[nr][nc]=dis[r1][c1]+1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int R = readInt(), C = readInt();
        char [][] grid = new char[R][C];
        List<pair> roots = new ArrayList();
        int x = 0, y = 0;
        int DENX=0, DENY=0;
        for (int i = 0; i < R; i++) {
            String a = next();
            for (int j = 0; j < a.length(); j++) {
                grid[i][j] = a.charAt(j);
                if(grid[i][j]=='*'){
                    roots.add(new pair(i, j));
                }
                if(grid[i][j]=='S'){
                    x = i; y = j;
                }
                if(grid[i][j]=='D'){
                    DENX=i; DENY=j;
                }
            }
        }
        int [][] times = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(grid[i][j]=='X'||grid[i][j]=='D')times[i][j]=-1;
            }
        }
        Queue<pair> q = new LinkedList();
        boolean [][] vis = new boolean[R][C];
        for (int i = 0; i < roots.size(); i++) {
            pair cur = new pair(roots.get(i).r, roots.get(i).c);
            q.add(cur);
            vis[cur.r][cur.c]=true;
        }
        while(!q.isEmpty()){
            int r1 = q.peek().r, c1 = q.peek().c;
            q.poll();
            for(int i = 0; i < 4; i++){
                int nr = r1 + direction[i][0], nc = c1 + direction[i][1];
                if(nr < 0 || nr >=R|| nc <0 || nc >=C|| vis[nr][nc] ||grid[nr][nc]=='X'||grid[nr][nc]=='D')continue;
                q.add(new pair(nr, nc));
                vis[nr][nc] = true;
                times[nr][nc] = times[r1][c1] + 1;
            }
        }
      
        boolean [][] alr = new boolean[R][C];
        int[][] speed = new int[R][C];
        go(grid, alr,speed, x, y,times,R,C);
       
        if(alr[DENX][DENY]){
            System.out.println(speed[DENX][DENY]);
        }else System.out.println("KAKTUS");
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
