/*
Author: Andrew Yeung
Date:   March 2, 2022
Link:   https://dmoj.ca/problem/dph
*/

import java.util.*;
import java.io.*;

public class Grid1 {

    public static void main(String[] args) throws IOException {
        int H = readInt(), W = readInt();
        boolean [][] vis = new boolean [H + 1][W + 1];
        long [][] dp = new long [H + 1][W + 1];
        for (int i = 1; i <= H; i++) {
            String a = next();
            for (int j = 1; j <= a.length(); j++) {
                Character current = a.charAt(j - 1);
                if(current == '#'){
                    vis[i][j] = true;
                }
            }
        }
        dp[0][1] = 1;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if(vis[i][j]){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % (long)(Math.pow(10, 9) + 7);
                }
            }
        }
        System.out.println(dp[H][W] % (long)(Math.pow(10, 9) + 7));
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
