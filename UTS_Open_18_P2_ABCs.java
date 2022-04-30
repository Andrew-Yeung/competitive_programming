/*
Author: Andrew Yeung
Date:   
Link:
*/

import java.util.*;
import java.io.*;

public class ABCs {

    public static void main(String[] args) throws IOException {
        //
        int [] a = new int[3];
        int [] b = new int[3];
        int [] c = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = readInt();
        }
        for (int i = 0; i < 3; i++) {
            b[i] = readInt();
        }
        for (int i = 0; i < 3; i++) {
            c[i] = readInt();
        }
        long ans = 0;
        if(b[2] == a[1] && c[2] > 0)ans += c[2];
        if(b[1] == a[0] && c[1] > 0)ans += c[1];
        if(b[0] == a[2] && c[0] > 0)ans += c[0];
        System.out.println(ans);
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
