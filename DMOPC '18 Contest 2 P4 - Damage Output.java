import java.util.*;
import java.io.*;

public class DamageOutput {

    public static void main(String[] args) throws IOException {
        int n = readInt(); long m = readLong();
        int [] arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = readInt();
        }
        int ans = n + 1;
        long sum = arr[1];
        if(sum >= m){
            ans = 1;
        }
        for(int left = 1, right = 1; left <= n && right <= n;){
            if(sum >= m){
                ans = Math.min(ans, right - left + 1);
                left++; if(left > n) break;
                sum -= arr[left - 1];
            }else{
                while(sum < m){
                    right++;
                    if(right > n) break;
                    sum += arr[right];
                }
            }
        }
        System.out.println(ans == n + 1 ? -1 : ans);
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
