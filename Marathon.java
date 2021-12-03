/*
Author: Andrew Yeung
Date:   December 3rd, 2021
Link:   https://dmoj.ca/problem/gfssoc2j4
*/

import java.util.*;
import java.io.*;
public class Marathon{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), q =readInt();
        int[] psa = new int[n]; int prev = 0;
        for(int i=0;i<n;i++){
            int a = readInt();
            if(i==0)prev = a;
            else prev += a;
            psa[i]= prev;
        }
        for(int i=0;i<q;i++){
            int x=readInt(), y=readInt();
            int thing = x>=2?psa[y-1]-psa[x-2]:psa[y-1];
            System.out.println(psa[psa.length-1]-thing);
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
