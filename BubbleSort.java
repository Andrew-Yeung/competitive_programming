import java.util.*;
import java.io.*;
public class SortBubbel {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = readInt();
        }
        boolean go = true;
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        outer:
        while(go == true) {
            for(int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    for(int k = 0; k < arr.length; k++){
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();
                    boolean check = true;
                    for(int j = 0; j < arr.length - 1; j++){
                        if(arr[j] >= arr[j + 1]){
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        break outer;
                    }

                }
            }
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
