/*
Author: Andrew Yeung
Date:   
Link:
*/

import java.util.*;
import java.io.*;

public class TakeANumber {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        List<Integer> q = new ArrayList();
        int c = 0;
        while(true){
            String a = next();
            if(a.equals("EOF"))break;
            else if(a.equals("TAKE")){
                q.add(n);
                n++; c++;
                if(n==1000)n=1;
            }
            else if(a.equals("SERVE")){
                q.remove(0);
            }else{
                System.out.println(c + " " + q.size() + " " + n);
                c =0;
                q.clear();
            }
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
