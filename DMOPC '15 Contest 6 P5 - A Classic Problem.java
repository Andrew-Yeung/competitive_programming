import java.util.*;
import java.io.*;

public class AClassicProblem {

    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt();
        long ans = 0;
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }
        Deque<Integer> max = new ArrayDeque();
        Deque<Integer> min = new ArrayDeque();
        for(int left = 0, right = 0; right < n; right++){
            while(!max.isEmpty() && max.getLast() < arr[right]) max.removeLast();
            while(!min.isEmpty() && min.getLast() > arr[right]) min.removeLast();
            max.addLast(arr[right]);
            min.addLast(arr[right]);
            while(max.getFirst() - min.getFirst() > k){
                if(max.getFirst() == arr[left]) max.removeFirst();
                if(min.getFirst() == arr[left]) min.removeFirst();
                left++;
            }
            ans += right - left + 1;
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
