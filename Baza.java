/*
Author: Andrew Yeung
Date:   November 26th, 2021
Link:   https://dmoj.ca/problem/coci16c7p1
*/

import java.util.*;
import java.io.*;
public class COCI_16_7_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int r = readInt(),c=readInt();
        int[][] matrix=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j]=readInt();
            }
        }
        int q=readInt();
        for(int i=0;i<q;i++){
            int[] tmp=new int[c];
            for(int j=0;j<c;j++){
                tmp[j]=readInt();
            }
            //find rows that match
            int ans=0;
            for(int j=0;j<r;j++){
                int count=0;
                for(int w=0;w<c;w++){
                    if(matrix[j][w]==tmp[w]||tmp[w]==-1){
                        count++;
                    }
                }
                if(count == c)ans++;
            }
            System.out.println(ans);
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
