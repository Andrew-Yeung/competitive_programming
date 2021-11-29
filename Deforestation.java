import java.util.*;
import java.io.*;
public class psa{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=readInt();
        }
        int[] psa =new int[n];
        psa[0]=arr[0];
        for(int i=1;i<n;i++){psa[i]=psa[i-1]+arr[i];}
        
        int q = readInt();
        for(int i=0;i<q;i++){
            int a = readInt(), b=readInt();
            System.out.println(a!=0?psa[b]-psa[a-1]:psa[b]);
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
