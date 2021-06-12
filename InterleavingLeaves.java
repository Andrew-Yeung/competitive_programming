import java.util.ArrayList;
import java.util.Scanner;

public class Leaves {
    public static void main(String[] args) {
        //https://dmoj.ca/problem/acmtryouts0b
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt(); //test cases


        for(int i = 0; i < n; i++){
            Integer count = s.nextInt();
            String a = s.next();
            String b = s.next();
            char first[] = new char[a.length()];
            char second[] = new char[b.length()];
            for(int j = 0; j < a.length(); j++){
                first[j] = a.charAt(j);
            }
            for(int p = 0; p < b.length(); p++){
                second[p] = b.charAt(p);
            }

            for(int j = first.length-1; j >= 0; j--){
                System.out.print(second[j]);
                System.out.print(first[j]);
            }
            System.out.println("");
        }


    }
}
//damn pretty cool huh
