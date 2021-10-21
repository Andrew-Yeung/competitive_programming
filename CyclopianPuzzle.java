import java.util.*;
import java.io.*;
public class puzzle{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void hanoi(int n, String one, String two, String three) {
        if(n == 0){
            return;
        }
        hanoi(n - 1, one, three, two);
        System.out.println(one + three);
        hanoi(n - 1, two, one, three);
    }
    public static void main(String[] args) throws IOException{
       
        int n =readInt();
        hanoi(n, "A", "B", "C");
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
