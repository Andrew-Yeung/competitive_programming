import java.util.*;
import java.io.*;
public class AddingReversedNumbers {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        for(int i = 0; i < n; i++){
            int a = readInt();
            int b = readInt();
            String aa = String.valueOf(a);
            String bb = String.valueOf(b);
            StringBuilder aaa = new StringBuilder(aa).reverse();
            StringBuilder bbb = new StringBuilder(bb).reverse();
            int aaaa = Integer.parseInt(aaa.toString());
            int bbbb = Integer.parseInt(bbb.toString());
            int sum = aaaa + bbbb;
            String yes = String.valueOf(sum);
            StringBuilder hi = new StringBuilder(yes).reverse();
            outer:
            while(true){
                if(hi.charAt(0) == '0'){
                    hi.deleteCharAt(0);
                }else{
                    break outer;
                }
            }
            System.out.println(hi);
        }

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
