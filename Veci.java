/*
Author: Andrew Yeung
Date:   March 5, 2022
Link:   https://dmoj.ca/problem/coci07c4p2
*/

import java.util.*;
import java.io.*;

public class Veci {
    static boolean check (String a, String b){
        char [] one = a.toCharArray();
        char [] two = b.toCharArray();
        Arrays.sort(one);
        Arrays.sort(two);
        if(Arrays.equals(one, two)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        int x = readInt();
        String thing = Integer.toString(x);
        for(int i = x + 1; i < 1000000; i++){
            if(check(thing, Integer.toString(i))){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
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
