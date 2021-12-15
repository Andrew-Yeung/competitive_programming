import java.util.*;
import java.io.*;
public class modernart{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        long n =readLong();
        int x=readInt(), y=readInt();
        int[] arr = new int[(int)n];
        int[] D = new int[(int)n+2];
        int r=readInt();
        while(r-->0){
            int l=readInt(),rr=readInt();
            D[l]++; D[rr+1]--;
        }
        int[] psa = new int[(int)n+2];
        psa[0]=D[0];
        for(int i=1;i<D.length;i++){
            psa[i]=psa[i-1]+D[i];
        }
        long sum =0;
        for(int i=x;i<=y;i++){
            sum+=psa[i];
        }
        System.out.println(sum);
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
