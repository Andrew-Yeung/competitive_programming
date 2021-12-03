/*
Author: Andrew Yeung
Date:   December 3rd, 2021
Link:   https://dmoj.ca/problem/ppwindsor18p6
*/

import java.util.*;
import java.io.*;
public class InterNAV {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int c = readInt(), r =readInt();
        char[][]grid = new char[r][c];
        //BFS every room
        List<Character> rooms = new ArrayList();
        int start_x=0,start_y=0;
        for(int i=0;i<r;i++){
            String a = next();
            for(int j=0;j<a.length();j++){
                grid[i][j]=a.charAt(j);
                if(grid[i][j]!='O' && grid[i][j]!='#'){
                    rooms.add(grid[i][j]);
                }
                if(grid[i][j]=='1'){
                    start_x=i; start_y=j;
                }
            }
        }
        pair start = new pair(start_x,start_y);
        int[][] direction={{-1,0}, {1,0}, {0, -1}, {0, 1}};
        List<Integer> ans = new ArrayList();
        for(int i=0;i<rooms.size();i++){
            char room = rooms.get(i);
            int end_x=0, end_y=0;
            here:
            for(int row=0;row<r;row++){
                for(int col=0;col<c;col++){
                    if(grid[row][col]==room){
                        end_x=row; end_y=col;
                        break here;
                    }
                }
            }
            pair end = new pair(end_x, end_y);
            boolean[][] vis = new boolean[r][c];
            Queue<pair> q = new LinkedList();
            q.add(start); vis[start.r][start.c]=true;
            while(!q.isEmpty()){
                int R=q.peek().r, C=q.peek().c;q.poll();
                for(int k=0;k<4;k++){
                    int nr = R+direction[k][0], nc = C+direction[k][1];
                    if(nr < 0 || nr >=r|| nc <0 || nc >=c|| vis[nr][nc] ||grid[nr][nc]=='#')continue;
                    q.add(new pair(nr,nc));
                    vis[nr][nc]=true;
                }
            }
            if(vis[end.r][end.c]==true){
                ans.add(room-'0');
            }
        }
        Collections.sort(ans);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    static class pair{
        int r, c;
        pair(int r0, int c0){r=r0;c=c0;}
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
