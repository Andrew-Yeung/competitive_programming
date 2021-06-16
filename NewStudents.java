import java.util.Scanner;

public class NewStudents {
    public static void main(String[] args) {
        //https://dmoj.ca/problem/dmopc14c1p3
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        int total = 0;
        int x = n;
        for(int i = 0; i < n; i++) {
            Integer a = s.nextInt();
            total += a;
        }
        Integer add = s.nextInt();
        for(int i = 0; i < add; i++){
            x++;
            float a = s.nextInt();
            total+= a;
            float yes = (float)total/x;
            System.out.printf("%.3f", yes);
            System.out.println();
        }

    }
}
//what a free 7 pointer :( ) )) ) 
