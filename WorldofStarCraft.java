/*
Author: Andrew Yeung
Date:   December 17th, 2021
Link:   https://dmoj.ca/problem/wc18c4s1
*/

import java.util.*;
import java.io.*;
public class WorldofStarCraft {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n=readInt(),m=readInt(),k=readInt();
        char[] c = next().toCharArray();
        int[] p = new int[n+1];
        for(int i=1;i<=n;i++)p[i]=i;

        for(int i=0;i<m;i++){
            int a=readInt(),b=readInt();
            int one = find_set(p, a), two = find_set(p, b);
            if(one != two && c[a-1]==c[b-1]){
                p[one]=p[two];
            }
        }
        int ans = 0;
        for(int i=0;i<k;i++){
            int x=readInt(),y=readInt();
            if(find_set(p,x)==find_set(p,y))ans++;
        }
        System.out.println(ans);
        //full ac :)
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
