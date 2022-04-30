import java.util.*;
import java.io.*;

public class p1p1p1pp1pp1p1 {
    static long MM = (int)1e9;
    public static void main(String[] args) throws IOException {
        long n = readLong(), k = readLong();
        if(n >= k){
            if(k == 1){
                for(int i = 1;i<=n;i++){
                    if(i == n)System.out.println(i);
                    else System.out.print(i + " ");
                }
                return;
            }
            List<Long> ans = new ArrayList();
            long start = k - 1;
            long difference = 1;
            long check = 0;
            long prev1 = -1, prev2 = -1;
            for(int i = 0; i< n/2; i++){
                if(start == difference || start == prev1 || difference==prev2||start==prev2||difference==prev1)break;
                ans.add(start);
                ans.add(difference);
                prev1 = start; prev2 = difference;
                check+=2;
                start--;
                difference++;
            }
            long left = n - check;

            long first = k;
            long second = 2*k;
            long highest = 0;
            for(int i = 0; i < left/2; i++){
                if(first > MM || second > MM){
                    System.out.println(-1);
                    return;
                }
                highest = Math.max(highest, Math.max(first,second));
                ans.add(first);
                ans.add(second);
                first += k*2;
                second +=k*2;
            }
            //System.out.println(highest);
            if(n % 2 == 1){
                ans.add((highest)+k);
            }
            for(int i = 0; i < ans.size();i++){
                if(i == ans.size()-1) System.out.println(ans.get(i));
                else System.out.print(ans.get(i) + " ");
            }
        }else{
            List<Long> ans = new ArrayList();
            if(n % 2 == 0){
                long start = k - 1;
                long difference = 1;
                for(int i = 0; i< n/2; i++){
                    ans.add(start);
                    ans.add(difference);
                    start--;
                    difference++;
                }
            }else{
                long start = k - 1;
                long difference = 1;
                for(int i = 0; i< n/2; i++){
                    ans.add(start);
                    ans.add(difference);
                    start--;
                    difference++;
                }
                ans.add(k);
            }
            for(int i = 0; i < ans.size();i++){
                if(i == ans.size()-1) System.out.println(ans.get(i));
                else System.out.print(ans.get(i) + " ");
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
