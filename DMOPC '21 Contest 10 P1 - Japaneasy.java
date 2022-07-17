import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        HashSet<Character> con = new HashSet();
        con.add('k');con.add('n');con.add('h');
        con.add('m');con.add('r');
        HashSet<Character> vowel = new HashSet();
        vowel.add('a');
        vowel.add('i');
        vowel.add('u');
        vowel.add('e');
        vowel.add('o');

        int t = readInt();
        for(int w = 0; w < t; w++){
            String x = next();
            boolean check = true;
            for (int i = 0; i < x.length(); i++) {
                char c = x.charAt(i);
                if(c=='h'){
                    if(i == x.length()-1){
                        check=false;
                    }
                    else if(x.charAt(i+1)=='u'){
                        check = false;
                    }
                }
                if(!con.contains(c) && !vowel.contains(c) && c !='f'){
                    check = false;
                }
                if(con.contains(c)){
                    if(i == x.length()-1){
                        check=false;
                    }
                    else if(!vowel.contains(x.charAt(i+1))){
                        check = false;
                    }
                }
                if(c=='f'){
                    if(i == x.length()-1){
                        check=false;
                    }
                    else if(x.charAt(i+1)!='u'){
                        check = false;
                    }
                }
            }
            if(check) System.out.println("YES");
            else System.out.println("NO");
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
