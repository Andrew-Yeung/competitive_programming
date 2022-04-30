import java.util.*;
import java.io.*;

public class Alphabet {
    static String alpha = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) throws IOException {
        String a = next();
        int [] arr = new int [a.length()];

        for(int i = 0;i < a.length();i++){
            char current = a.charAt(i);
            arr[i] = alpha.indexOf(current);
        }
        //LIS
        List<Integer> ans = new ArrayList();
        for(int i = 0; i < arr.length;i++){
            if(ans.isEmpty() || arr[i] > ans.get(ans.size() - 1)){
                ans.add(arr[i]);
            }else{
                int p = Collections.binarySearch(ans, arr[i]);
                int index = -p-1;
                if(p < 0)ans.set(index, arr[i]);
            }
        }
        System.out.println(26 - ans.size());

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
