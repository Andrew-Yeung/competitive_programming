/*
Author: Andrew Yeung
Date:    feb 25,2022
Link:       https://dmoj.ca/problem/dmopc16c1p3
*/

import java.util.*;
import java.io.*;

public class ShoeShopping {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int [] arr = new int [n + 1];
        for(int i = 1;i<=n;i++){
            arr[i] = readInt();

        }
        double [] dp = new double [n + 1];
        dp[1] = arr[1];
        if(n == 1){
            System.out.println(dp[1]);
            return;
        }
        dp[2] = (double)Math.min(arr[1], arr[2])/2 + Math.max(arr[1], arr[2]);
        if(n == 2){
            System.out.println(dp[2]);
            return;
        }
        for(int i = 3; i<= n;i++){
            //three options, take 1, take 2 with discount, take 3 with bigger discount
            double option_1 = dp[i - 1] + arr[i];
            double option_2 = dp[i - 2] + (double) Math.min(arr[i], arr[i - 1])/2 + Math.max(arr[i], arr[i - 1]);
            double option_3 = dp[i - 3] + arr[i] + arr[i - 1] + arr[i - 2] - Math.min(arr[i], Math.min(arr[i - 1], arr[i - 2]));
            dp[i] = Math.min(option_1, Math.min(option_2, option_3));
        }
        //System.out.println(Arrays.toString(dp));
        System.out.printf("%.1f", dp[n]);
    }

    static class pair {
        int r, c;

        pair(int r0, int c0) {
            r = r0;
            c = c0;
        }
    }

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

    static int quickpow(int x, int exp, int mod) {
        //function gets exponents really fast
        if (exp == 0) {
            return 1;
        }
        int t = quickpow(x, exp / 2, mod);
        t = t * t % mod;
        if (exp % 2 == 0) return t;
        return t * x % mod;
    }

    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static boolean contains(String[] arr, String target) {
        boolean flag = false;
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals(target)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    static boolean prime(int n) {
        if (n <= 1) return false;
        else if (n == 2) return true;
        else if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //dsu
    static int find_set(int p[], int d) { //parent array and the target parent you're looking for
        if (d != p[d]) p[d] = find_set(p, p[d]);
        return p[d];
    }

    static void union(int p[], int x, int y) {
        int a = find_set(p, x), b = find_set(p, y);
        p[a] = b;
    }

    public static class edge implements Comparable<edge> {
        int u, v, w;

        edge(int u0, int v0, int w0) {
            u = u0;
            v = v0;
            w = w0;
        }

        public int compareTo(edge x) {
            return w - x.w;
        }
    }
}
