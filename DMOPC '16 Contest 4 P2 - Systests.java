/*
Author: Andrew Yeung
Date:   
Link:
*/

import java.util.*;
import java.io.*;

public class sysets {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        long[] start = new long[n];
        long[] end = new long[n];
        long[] val = new long[n];
        for (int i = 0; i < n; i++) {
            start[i] = readLong();
            end[i] = readLong();
            val[i] = readLong();
        }
        int f = readInt();
        long[] arr = new long[f];
        for (int i = 0; i < f; i++) {
            arr[i] = readLong();
        }
        Arrays.sort(arr);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long index = lower_bound(arr, start[i]);
            if(index == arr.length){
                ans+=val[i];
                continue;
            }
            if(arr[(int)index] == start[i])continue;
            if(arr[(int) (index)] > end[i]){
                ans += val[i];
            }
        }
        System.out.println(ans);
    }
    static long lower_bound(long a[], long x) {
        //return 1st element >= x. if no such element, return a.length
        long lo = 0, hi = a.length-1, ans = a.length;
        while(lo <= hi) {
            long mid = (lo + hi)/2;
            if(a[(int)mid] >= x) { ans = mid; hi = mid - 1; }
            else lo = mid + 1;
        }
        return ans;
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
