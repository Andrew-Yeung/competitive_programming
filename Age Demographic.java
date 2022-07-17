/*
Author: Andrew Yeung
Date:   
Link:
*/

import java.util.*;
import java.io.*;

public class AgeDemographic {
    static int lower_bound(int []a, int x) {
        //return 1st element >= x. if no such element, return a.length
        int lo = 0, hi = a.length-1, ans = a.length;
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            if(a[(int)mid] >= x) { ans = mid; hi = mid - 1; }
            else lo = mid + 1;
        }
        return ans;
    }
    static int upper_bound(int a[], int x) {
        //return 1st element > x. if no such element, return a.length
        int lo = 0, hi = a.length-1, ans = a.length;
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            if(a[mid] > x) { ans = mid; hi = mid - 1; }
            else lo = mid + 1;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }
        Arrays.sort(arr);
        int q = readInt();
        while(q-->0){
            int a = readInt(), b = readInt();
            int lower = lower_bound(arr, a);
            int upper = upper_bound(arr, b) - 1;

            if(lower == arr.length || (upper+1)==0 || arr[lower]>b){
                System.out.println(0);
                continue;
            }
            if((upper+1) == arr.length){
                System.out.println(n - lower);
            }
            else System.out.println(Math.abs(lower - upper) + 1);
        }
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
