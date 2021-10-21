import java.util.*;
import java.io.*;
public class QueensCantAttackme {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        Integer[][] board = new Integer[n][n];
        //0 = marked
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=1; //not marked
            }
        }
        for(int i=0;i<m;i++){
            int x = readInt(), y = readInt();
            for(int j=0;j<n;j++){
                board[x-1][j]=0;
            }
            for(int j=0;j<n;j++){
                board[j][y-1]=0;
            }
            //diagonals ORZ
            int xx = y-1, yy = x - 1;
            while(xx >= 0 && yy != n){
                board[xx][yy]=0;
                xx--;
                yy++;
            }
            xx = y-1; yy = x - 1;
            while(xx != n && yy >= 0){
                board[xx][yy]=0;
                xx++;
                yy--;
            }
            xx = y-1; yy = x - 1;
            while(xx != n && yy != n){
                board[yy][xx]=0;
                xx++;
                yy++;
            }
            xx = y-1; yy = x - 1;
            while(xx >=0 && yy >=0){
                board[yy][xx]=0;
                xx--;
                yy--;
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1) count++;
            }
        }
        System.out.println(count);

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
