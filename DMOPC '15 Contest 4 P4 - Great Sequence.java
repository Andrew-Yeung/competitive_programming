/*
Author: Andrew Yeung
Date:
Link:
*/

import java.util.*;
import java.io.*;

public class cry {

    public static void main(String[] args) throws IOException {
        //i cry
        int n = readInt(); long k = readLong(), q = readLong();
        HashMap<Integer, List<Integer>> map = new HashMap();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
            if(map.get(arr[i])==null){
                List<Integer> a = new ArrayList();
                a.add(i+1);
                map.put(arr[i], a);
            }else{
                map.get(arr[i]).add(i+1);
            }
        }
        //System.out.println(map);
        //map stores indexes
        int [] psa = new int[n];
        psa[0] = arr[0];
        for(int i = 1; i < n;i++){
            psa[i] = psa[i - 1] + arr[i];
        }

        while(q-->0){
            int a = readInt(), b = readInt();
            int x = readInt() - 1, y = readInt() - 1;
            if(map.get(a)==null || map.get(b)==null){
                System.out.println("No");
                continue;
            }
            long sum = 0;
            if(x == 0){
                sum = psa[y];
            }else{
                sum = psa[y] - psa[x - 1];
            }
            if(sum <= k){
                System.out.println("No");
                continue;
            }
            x++;y++;
            int FirstA = lower_bound(map.get(a), x);
            int FirstB = lower_bound(map.get(b), x);
            if(FirstA == map.get(a).size() || FirstB==map.get(b).size()){
                System.out.println("No");
                continue;
            }
           // System.out.println(FirstA + " " + FirstB);
            //System.out.println(map.get(a).get(FirstA) + " "+ map.get(b).get(FirstB));
            if(map.get(a).get(FirstA) <= y && map.get(b).get(FirstB) <= y){
                System.out.println("Yes");
            }else System.out.println("No");
        }
    }
    static int lower_bound(List<Integer> a, int x) {
        //return 1st element >= x. if no such element, return a.length
        int lo = 0, hi = a.size()-1, ans = a.size();
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            if(a.get((int)mid) >= x) { ans = mid; hi = mid - 1; }
            else lo = mid + 1;
        }
        return ans;
    }
    final private static int BUFFER_SIZE = 1 << 16;
    private static DataInputStream din = new DataInputStream(System.in);
    private static byte[] buffer = new byte[BUFFER_SIZE];
    private static int bufferPointer = 0, bytesRead = 0;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = Read()) != -1) {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public static String read() throws IOException {
        byte[] ret = new byte[1024];
        int idx = 0;
        byte c = Read();
        while (c <= ' ') {
            c = Read();
        }
        do {
            ret[idx++] = c;
            c = Read();
        } while (c != -1 && c != ' ' && c != '\n' && c != '\r');
        return new String(ret, 0, idx);
    }

    public static int readInt() throws IOException {
        int ret = 0;
        byte c = Read();
        while (c <= ' ')
            c = Read();
        boolean neg = (c == '-');
        if (neg)
            c = Read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = Read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public static long readLong() throws IOException {
        long ret = 0;
        byte c = Read();
        while (c <= ' ')
            c = Read();
        boolean neg = (c == '-');
        if (neg)
            c = Read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = Read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public static double readDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = Read();
        while (c <= ' ')
            c = Read();
        boolean neg = (c == '-');
        if (neg)
            c = Read();

        do {
            ret = ret * 10 + c - '0';
        } while ((c = Read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = Read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private static void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private static byte Read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }

    static void print(Object o) {
        pr.print(o);
    }

    static void println(Object o) {
        pr.println(o);
    }

    static void flush() {
        pr.flush();
    }

    static void println() {
        pr.println();
    }

    static void exit() throws IOException {
        din.close();
        pr.close();
        System.exit(0);
    }
}
