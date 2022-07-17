/*
Author: Andrew Yeung
Date:   
Link:
*/

import java.util.*;
import java.io.*;
import java.util.concurrent.LinkedBlockingDeque;

//https://dmoj.ca/problem/dmopc18c6p4
public class Tank {
    static class pair {
        long first, second;

        pair(long r0, long c0) {
            first = r0;
            second = c0;
        }
    }
    public static void main(String[] args) throws IOException {
        int n = readInt(), p = readInt(), m = readInt();
        pair[] stats = new pair[n];
        for (int i = 0; i < n; i++) {
            long x = readLong(), y = readLong();
            stats[i] = new pair(x,y);
        }
        long[] physical = new long[p];
        long[] magical = new long[m];
        for (int i = 0; i < p; i++) {
            physical[i] = readLong();
        }
        for (int i = 0; i < m; i++) {
            magical[i] = readLong();
        }
        Arrays.sort(physical);Arrays.sort(magical);
        //lower bound + psa
        //make psa and find point where unit is getting affected
        //use lower-bound to find point
        long [] psaphysical = new long[p];
        psaphysical[0] = physical[0];
        for(int i =1;i<p;i++){
            psaphysical[i] = psaphysical[i-1]+physical[i];
        }
        long[] psamagical = new long[m];
        psamagical[0] = magical[0];
        for(int i =1;i<m;i++){
            psamagical[i] = psamagical[i-1]+magical[i];
        }
        long printprint = (long)1e18+9;long II = 0;
        for(int i = 0;i<n;i++){
            //physical first
            long unitp = stats[i].first;
            long index = lower_bound(physical, unitp);
            //find sum from index to end
            long sum = 0;
            if(index == 0){
                sum = psaphysical[p - 1];
            }else{
                sum = psaphysical[p - 1] - psaphysical[(int)index - 1];
            }
            //find the removal
            //the index times the resistance and subtract that from sum
            long ans = sum - ((p - index) * unitp);
            //
            //MAGICAL
            long check = stats[i].second;
            long uwu = lower_bound(magical, check);
            long total = 0;
            if(uwu == 0){
                total = psamagical[m - 1];
            }else{
                total = psamagical[m - 1] - psamagical[(int)uwu - 1];
            }
            long ansans = total - ((m - uwu) * check);
            if(ansans+ans < printprint){
                printprint = ansans+ans;
                II = i + 1;
            }
        }
        System.out.println(II);
    }
    static long lower_bound(long a[], long x) {
        //return 1st element >= x. if no such element, return a.length
        long lo = 0, hi = a.length-1, ans = a.length;
        while(lo <= hi) {
            long mid = (lo + hi)/2;
            if(a[(int)mid] > x) { ans = mid; hi = mid - 1; }
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
