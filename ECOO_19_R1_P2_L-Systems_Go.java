/*
Author: Andrew Yeung
Date:   
Link:
*/

import java.util.*;
import java.io.*;

public class LSystemsGo {
    static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) throws IOException {
        int test = 10;
        while(test-->0){
            int r = readInt(), t = readInt();
            String A = next();

            HashMap<String, String> thing = new HashMap();
            for (int i = 0; i < r; i++) {
                String C = next();
                String bruh = next();
                thing.put(C, bruh);
            }
            long [] BRUHWTF = new long[26];
            for (int i = 0; i < A.length(); i++) {
                BRUHWTF[alpha.indexOf(A.charAt(i))]++;
            }
            for (int i = 0; i < t; i++) {
                long [] arr = Arrays.copyOf(BRUHWTF, BRUHWTF.length);
                for (int j = 0; j < BRUHWTF.length; j++) {
                    if(BRUHWTF[j] != 0){
                        String COR = thing.get(Character.toString(alpha.charAt(j)));
                        for (int l = 0; l < COR.length(); l++) {
                            arr[alpha.indexOf(COR.charAt(l))]+=BRUHWTF[j];
                        }
                        arr[alpha.indexOf(alpha.charAt(j))]-=BRUHWTF[j];
                    }
                }
                BRUHWTF = arr;
            }
            //System.out.println(Arrays.toString(BRUHWTF));
            long sum = 0;
            for (int i = 0; i < BRUHWTF.length; i++) {
                sum += BRUHWTF[i];
            }
            //track first
            char start = A.charAt(0);
            for (int i = 0; i < t; i++) {
                char uwu = thing.get(Character.toString(start)).charAt(0);
                start = uwu;
            }
            //track last
            char last = A.charAt(A.length()-1);
            for (int i = 0; i < t; i++) {
                char uwu = thing.get(Character.toString(last)).charAt(thing.get(Character.toString(last)).length()-1);
                last = uwu;
            }
            System.out.print(start);
            System.out.print(last);
            System.out.println(" " + sum);
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
