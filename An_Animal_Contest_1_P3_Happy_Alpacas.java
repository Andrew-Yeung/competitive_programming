import java.util.*;
import java.io.*;

public class HappyAlpacas {

    public static void main(String[] args) throws IOException {
        //AD HAWK MOMENT.
        int n = readInt(), x = readInt();
        //constructive alg
        //two of the same = even
        //use only 1 and 2 because only even and odd matter
        if(n % 2 != x % 2){
            System.out.println(-1);
        }else{
            //same parity
            List<Integer> ans = new ArrayList();
            if(n % 2 == 0){
                for (int i = 0; i < (n-x)/2; i++) {
                    ans.add(2);
                    ans.add(1);
                }
                while(ans.size()!=n){
                    ans.add(1);
                }
            }else{
                if(n==x){
                    for (int i = 0; i < n; i++) {
                        ans.add(1);
                    }
                }else{
                    //
                    int count1 = x+1;
                    for (int i = 0; i < count1/2; i++) {
                        ans.add(1);
                    }

                    int rem = n-count1;
                    for (int i = 0; i < rem; i++) {
                        if(i%2==0){
                            ans.add(2);
                        }else ans.add(1);
                    }
                    for (int i = 0; i < count1/2; i++) {
                        ans.add(1);
                    }
                }
            }
            for(int i=0;i<ans.size();i++){
                if(i==ans.size()-1) System.out.println(ans.get(i));
                else System.out.print(ans.get(i)+" ");
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
