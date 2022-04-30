/*
Author: Andrew Yeung
Date:  April 25, 2022
Link:  https://dmoj.ca/problem/ecoo15r1p1
*/

import java.util.*;
import java.io.*;

public class Smartis {

    public static void main(String[] args) throws IOException {
        //
        for (int i = 0; i < 10; i++) {
            HashMap<String, Integer> map = new HashMap();
            map.put("red", 0);
            map.put("orange", 0);
            map.put("blue", 0);
            map.put("green", 0);
            map.put("yellow", 0);
            map.put("pink", 0);
            map.put("violet", 0);
            map.put("brown", 0);

            while(true){
                String color = readLine();
                if(color.equals("end of box")){
                    break;
                }
                int old = map.get(color);
                map.put(color, old + 1);
            }
            int ans = 0;
            ans += map.get("red") * 16;
            if(map.get("orange") % 7 == 0){
                ans += (map.get("orange")/7) * 13;
            }else{
                ans += (map.get("orange")/7) * 13;
                ans += 13;
            }

            if(map.get("blue") % 7 == 0){
                ans += (map.get("blue")/7) * 13;
            }else{
                ans += (map.get("blue")/7) * 13;
                ans += 13;
            }

            if(map.get("green") % 7 == 0){
                ans += (map.get("green")/7) * 13;
            }else{
                ans += (map.get("green")/7) * 13;
                ans += 13;
            }

            if(map.get("yellow") % 7 == 0){
                ans += (map.get("yellow")/7) * 13;
            }else{
                ans += (map.get("yellow")/7) * 13;
                ans += 13;
            }
            if(map.get("pink") % 7 == 0){
                ans += (map.get("pink")/7) * 13;
            }else{
                ans += (map.get("pink")/7) * 13;
                ans += 13;
            }
            if(map.get("violet") % 7 == 0){
                ans += (map.get("violet")/7) * 13;
            }else{
                ans += (map.get("violet")/7) * 13;
                ans += 13;
            }
            if(map.get("brown") % 7 == 0){
                ans += (map.get("brown")/7) * 13;
            }else{
                ans += (map.get("brown")/7) * 13;
                ans += 13;
            }
            System.out.println(ans);
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
