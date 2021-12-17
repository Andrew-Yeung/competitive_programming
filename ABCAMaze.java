/*
Author: Andrew Yeung
Date:   December 16th, 2021
Link:   https://dmoj.ca/problem/dwite11c3p4
*/

import java.util.*;
import java.io.*;
public class ABCAmaze {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int ii=5;
        while(ii-->0){
            int anst=0;
            int r=readInt(),c=readInt();
            char[][] matrix = new char[r][c];
            int ax = 0, ay=0,bx=0,by=0,cx=0,cy=0;
            for(int i=0;i<r;i++){
                String a=next();
                for(int j=0;j<a.length();j++){
                    matrix[i][j]=a.charAt(j);
                    char ok = matrix[i][j];
                    if(ok == 'A'){ax=i; ay=j;}
                    if(ok == 'B'){bx=i; by=j;}
                    if(ok == 'C'){cx=i; cy=j;}
                }
            }
            Queue<pair> q=new LinkedList();
            boolean[][] vis = new boolean[r][c];
            int[][] dis = new int[r][c];
            pair A = new pair(ax,ay);
            pair B = new pair(bx, by);
            pair C = new pair(cx, cy);
            q.add(A); vis[A.r][A.c]=true;
            int[][] direction = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
            while(!q.isEmpty()){
                int r1=q.peek().r, c1 = q.peek().c; q.poll();
                for(int i=0;i<4;i++){
                    int nr = r1+direction[i][0], nc = c1+direction[i][1];
                    if(nr < 0 || nr >=r|| nc <0 || nc >=c|| vis[nr][nc] ||matrix[nr][nc]=='#')continue;
                    q.add(new pair(nr,nc));
                    vis[nr][nc]=true;
                    dis[nr][nc]=dis[r1][c1]+1;
                }
            }

            anst += dis[B.r][B.c]+dis[C.r][C.c];
            //
            Queue<pair> q1=new LinkedList();
            boolean[][] vis1 = new boolean[r][c];
            int[][] dis1 = new int[r][c];

            q1.add(B); vis1[B.r][B.c]=true;

            while(!q1.isEmpty()){
                int r1=q1.peek().r, c1 = q1.peek().c; q1.poll();
                for(int i=0;i<4;i++){
                    int nr = r1+direction[i][0], nc = c1+direction[i][1];
                    if(nr < 0 || nr >=r|| nc <0 || nc >=c|| vis1[nr][nc] ||matrix[nr][nc]=='#')continue;
                    q1.add(new pair(nr,nc));
                    vis1[nr][nc]=true;
                    dis1[nr][nc]=dis1[r1][c1]+1;
                }
            }
            System.out.println(anst+dis1[C.r][C.c]);
        }

    }
    static class pair{
        int r,c;
        pair(int r0, int c0){r = r0; c=c0;}
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
    static int quickpow(int x, int exp, int mod){
        //function gets exponents really fast
        if(exp == 0){
            return 1;
        }
        int t = quickpow(x, exp/2, mod);
        t = t*t % mod;
        if(exp % 2 == 0) return t;
        return t*x % mod;
    }
    static boolean contains(String[] arr, String target){
        boolean flag = false;
        if(arr.length > 0){
            for(int i=0;i<arr.length;i++){
                if(arr[i].equals(target)){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    static boolean prime(int n){
        if(n<=1)return false;
        else if(n==2)return true;
        else if(n%2==0)return false;
        for(int i=3;i<=Math.sqrt(n);i+=2) {
            if(n%i == 0)return false;
        }
        return true;
    }

    //dsu
    static int find_set(int p[], int d){ //parent array and the target parent you're looking for
        if(d != p[d])p[d]=find_set(p,p[d]);
        return p[d];
    }
    static void union(int p[], int x,int y){
        int a=find_set(p, x), b = find_set(p, y);
        p[a]=b;
    }
}
