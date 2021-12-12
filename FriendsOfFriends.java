/*
Author: Andrew Yeung
Date:   December 11th, 2021
Link:   https://dmoj.ca/problem/sac21ccp5
*/

import java.util.*;
import java.io.*;
public class Friends_of_Friends{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        //template dsu
        int n=readInt(),q=readInt(); int[]p=new int[n+1]; int[]size=new int[n+1];
        for(int i=1;i<=n;i++){
            p[i]=i; size[i]=1;
        }
        while(q-->0){
            int command = readInt();
            if(command == 1){
                int a=readInt(),b=readInt(); //union
                int fa=find_set(p,a), fb=find_set(p,b);
                if(fa!=fb){
                    p[fa]=p[fb];
                    size[fb]+=size[fa];
                }
            }
            else{
                int a=readInt();
                System.out.println(size[find_set(p,a)]);
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
