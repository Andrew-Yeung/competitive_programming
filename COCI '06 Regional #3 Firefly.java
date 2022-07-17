/*
Author: Andrew Yeung
Date:   
Link:
*/

import java.util.*;
import java.io.*;

public class fierfly {

    public static void main(String[] args) throws IOException {
        int n = readInt(), h = readInt();
        int [] floor = new int[n/2];
        int [] top = new int[n/2];
        int c = 0, r = 0;
        for (int i = 0; i < n; i++) {
            int x = readInt();
            if(i % 2 == 0){
                floor[c] = x; c++;
            }else{
                top[r] = x;
                r++;
            }
        }
        Arrays.sort(floor);
        Arrays.sort(top);
        int min = Integer.MAX_VALUE;
        int [] values = new int[h];
        for(int i = 1; i <= h; i++){
            int first = 0, second = 0;
            int amount = 0;
            long bottom = lower_bound(floor, i);
            long high = lower_bound(top, (h - i + 1));
            if(bottom != floor.length){
                amount += n/2 - bottom;
            }
            if(high != top.length){
                amount += n/2 - high;
            }
            values[i - 1] = amount;
            min = Math.min(min, amount);
        }
        int ans = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i] == min)ans++;
        }
        System.out.println(min + " " + ans);
    }
    static long lower_bound(int a[], long x) {
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
