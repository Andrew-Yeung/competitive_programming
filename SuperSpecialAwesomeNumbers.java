import java.util.*;
import java.io.*;
public class awesomenumbers {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int counter = 0;
        for(int i = 0; i < 5; i++){
            int start = readInt();
            int end = readInt();
            int count = 0; //get to 3 and yee
            for(int j = start; j <= end; j++){
                boolean print = true;
                //if it survives all 3, we increase counter.
                int sum = 0;
                String check = String.valueOf(j);
                for (int p = 0; p < check.length(); p++) {
                    sum += check.charAt(p) - '0'; //this turns string to number
                }
                if(sum % 2 == 0){
                    count++;
                }else{
                    print = false;
                }
                String curr = String.valueOf(j);
                boolean flag = true;
                for(int p = 0; p < curr.length() - 1; p++){
                    if(curr.charAt(p) < curr.charAt(p + 1)){ //checks the next index
                    }else{
                        flag = false;
                    }
                }
                if(flag == true){
                    count++;
                }else{
                    print = false;
                }
                //last check
                for (int w = 2; w < j; w++) { //start at 2 since 1 is invalid
                    if (w * w > j){
                        break;
                    }
                    else if (j % (w * w) == 0) { //if divisble, we know this num can pass
                        print = false;
                    }
                }

                if(print == true){ //means it passed all 3 requirements
                    counter++;
                }
            }
            System.out.println(counter);
            counter = 0;
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
