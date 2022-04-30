import java.util.*;
import java.io.*;

public class avacadoTree {

    public static void main(String[] args) throws IOException {
        //
        //

        //
        long n=readLong(),q=readLong(); long h=readLong();
        long [] hi = new long [(int)n];
        long[] bruh = new long [(int)n];
        for(int i=0;i<n;i++){
            hi[i]=readLong();
            bruh[i]=readLong();
        }
        long[]psa=new long[(int)n];
        //skip the one that is too high
        if(hi[0]<=h)psa[0]=bruh[0];
        for(int i=1;i<n;i++){
            if(hi[i]<=h){
                psa[i]=psa[i-1]+bruh[i];
            }
            else psa[i]=psa[i-1];
        }
        //System.out.println(Arrays.toString(psa));
        long ans = 0;
        for (int i = 0; i < q; i++) {
            int x = readInt(),y=readInt();
            if(x==1){
                ans=Math.max(ans, psa[y-1]);
                //System.out.println(psa[y-1]);
            }else if(x==y){
                if(psa[x-1]!=psa[x-2]){
                    ans=Math.max(ans, psa[x-1]-psa[x-2]);
                    //System.out.println(psa[x-1]-psa[x-2]);
                }
                else ans=Math.max(ans, 0);
            }else{
                ans=Math.max(ans, psa[y-1]-psa[x-2]);
                //System.out.println(psa[y-1]-psa[x-1]);
            }
        }
        System.out.println(ans);
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
